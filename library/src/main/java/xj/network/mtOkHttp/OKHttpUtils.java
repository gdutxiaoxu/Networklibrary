package xj.network.mtOkHttp;

import android.content.Context;
import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import xj.network.HttpException;
import xj.network.IResponseListener;
import xj.network.NetUtils;
import xj.network.NetworkOption;

import static xj.network.mtOkHttp.OKHttpRequest.cacheSize;

/**
 * @author meitu.xujun  on 2017/11/17
 * @version 0.1
 */
public class OKHttpUtils {

    public static Handler mHandler=new Handler();

    public static Handler getHandler(){
        if(mHandler==null){
            mHandler=new Handler();
        }
        return mHandler;
    }

   public static void  doGet(Context context,String url, Map<String, String> paramsMap, NetworkOption networkOption,
                      final IResponseListener iResponseListener){
       OkHttpClient.Builder mBuilder= new OkHttpClient.Builder().
               connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS)
               .readTimeout(30, TimeUnit.SECONDS)
               .addInterceptor(new LoggingInterceptor())
               .cache(new Cache(context.getExternalFilesDir("okhttp"),cacheSize));
       OkHttpClient cilent = mBuilder.build();

       Request.Builder builder = new Request.Builder().url(url);


       Request build = builder.build();

       cilent.newCall(build).enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {
               handleError(e, iResponseListener);
           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
               handleResult(response, iResponseListener);
           }
       });
   }

    public static void doPost(Context context,String url, Map<String, String> paramsMap, NetworkOption networkOption,
                       final IResponseListener iResponseListener) {
        OkHttpClient.Builder mBuilder= new OkHttpClient.Builder().
                connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .cache(new Cache(context.getExternalFilesDir("okhttp"),cacheSize));
        OkHttpClient cilent = mBuilder.build();

        url= NetUtils.checkUrl(url);
        final NetworkOption option=NetUtils.checkNetworkOption(networkOption,url);
        FormBody.Builder builder = new FormBody.Builder();
        FormBody formBody = builder.build();

        Request.Builder requestBuilder = new Request.Builder().url(url).post(formBody).tag(option.mTag);
        Request request = requestBuilder.build();
        cilent.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handleError(e,iResponseListener);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handleResult(response,iResponseListener);
            }
        });
    }


    private static void handleResult(Response response, final IResponseListener iResponseListener) throws IOException {
        final  String result = response.body().string();
        if(iResponseListener!=null){
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    iResponseListener.onResponse(result);
                }
            });

        }
    }

    private static void handleError(IOException e, final IResponseListener iResponseListener) {
        if(iResponseListener!=null){
            final HttpException httpException = new HttpException();
            httpException.e=e;
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    iResponseListener.onFail(httpException);
                }
            });

        }
    }
}
