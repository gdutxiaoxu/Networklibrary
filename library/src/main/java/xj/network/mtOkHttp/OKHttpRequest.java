package xj.network.mtOkHttp;

import android.content.Context;
import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
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
import xj.network.NetRequest;
import xj.network.NetUtils;
import xj.network.NetworkOption;

/**
 * @author meitu.xujun  on 2017/11/15
 * @version 0.1
 */
public class OKHttpRequest implements NetRequest {

    static int cacheSize = 10 * 1024 * 1024; // 10 MiB

    private static  OkHttpClient client ;
    private Context mContext;

    public static Handler mHandler=new Handler();

    public static Handler getHandler(){
        if(mHandler==null){
            mHandler=new Handler();
        }
        return mHandler;
    }

    @Override
    public void init(Context context) {
        mContext = context.getApplicationContext();
        client=getCilent();
    }

    private volatile static OKHttpRequest instance = null;

    private OKHttpRequest(){
    }

    public static OKHttpRequest getInstance() {
        if (instance == null) {
            synchronized (OKHttpRequest.class) {
                if (instance == null) {
                    instance = new OKHttpRequest();
                }
            }
        }


        return instance;
    }

    private OkHttpClient getCilent() {
        if(client==null){
            OkHttpClient.Builder mBuilder= new OkHttpClient.Builder().
                    connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new LoggingInterceptor())
                    .cache(new Cache(mContext.getExternalFilesDir("okhttp"),cacheSize));
            client=mBuilder.build();
        }
        return client;

    }

    @Override
    public void doGet(String url, Map<String, String> paramsMap, final IResponseListener iResponseListener) {
        doGet(url,paramsMap,null,iResponseListener);
    }

    @Override
    public void doGet(String url, Map<String, String> paramsMap, NetworkOption networkOption,
                   final   IResponseListener iResponseListener) {
        url= NetUtils.checkUrl(url);
        url=NetUtils.appendUrl(url,paramsMap);
        final NetworkOption option=NetUtils.checkNetworkOption(networkOption,url);
        Request.Builder builder = new Request.Builder().url(url).tag(option.mTag);
        builder=configHeaders(builder,option);

        Request build = builder.build();

        getCilent().newCall(build).enqueue(new Callback() {
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

    private void handleResult(Response response, final IResponseListener iResponseListener) throws IOException {
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

    private void handleError(IOException e, final IResponseListener iResponseListener) {
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

    private Request.Builder configHeaders(Request.Builder builder, NetworkOption option) {
        Map<String, String> headers = option.mHeaders;
        if(headers==null || headers.size()==0){
            return builder;
        }
        Set<Map.Entry<String, String>> entries = headers.entrySet();
        for(Map.Entry<String, String> entry: entries){
            String key = entry.getKey();
            String value = entry.getValue();
            builder.addHeader(key,value);
        }
        return builder;

    }

    @Override
    public void doPost(String url, Map<String, String> paramsMap, final IResponseListener iResponseListener) {
        doPost(url,paramsMap,null,iResponseListener);

    }

    private FormBody.Builder configPushParam(FormBody.Builder builder, Map<String, String> paramsMap) {
        if(paramsMap!=null){
            Set<Map.Entry<String, String>> entries = paramsMap.entrySet();
            for(Map.Entry<String,String> entry:entries ){
                String key = entry.getKey();
                String value = entry.getValue();
                builder.add(key,value);
            }
        }
        return builder;
    }

    @Override
    public void doPost(String url, Map<String, String> paramsMap, NetworkOption networkOption,
                       final IResponseListener iResponseListener) {
        url= NetUtils.checkUrl(url);
        final NetworkOption option=NetUtils.checkNetworkOption(networkOption,url);
        FormBody.Builder builder = new FormBody.Builder();
        builder=configPushParam(builder,paramsMap);
        FormBody formBody = builder.build();

        Request.Builder requestBuilder = new Request.Builder().url(url).post(formBody).tag(option.mTag);
        requestBuilder=configHeaders(requestBuilder,option);
        Request request = requestBuilder.build();
        getCilent().newCall(request).enqueue(new Callback() {
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

    @Override
    public void cancel(Object tag) {
        if(client!=null){
            if(client != null) {
                for(Call call : client.dispatcher().queuedCalls()) {
                    if(call.request().tag().equals(tag))
                        call.cancel();
                }
                for(Call call : client.dispatcher().runningCalls()) {
                    if(call.request().tag().equals(tag))
                        call.cancel();
                }
            }
        }
    }


}
