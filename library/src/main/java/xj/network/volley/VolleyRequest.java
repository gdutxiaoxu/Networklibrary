package xj.network.volley;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import xj.network.HttpException;
import xj.network.IResponseListener;
import xj.network.LogUtil;
import xj.network.NetRequest;
import xj.network.NetUtils;
import xj.network.NetworkOption;

/**
 * @author meitu.xujun  on 2017/9/6
 * @version 0.1
 */

public class VolleyRequest implements NetRequest {

    private static final String TAG = "VolleyRequest";

    private volatile static VolleyRequest instance = null;
    private static RequestQueue requestQueue;
    private Context mContext;

    private VolleyRequest() {
    }

    public static VolleyRequest getInstance() {
        synchronized (VolleyRequest.class) {
            if (instance == null) {
                instance = new VolleyRequest();
            }
        }

        return instance;
    }





    @Override
    public void init(Context context) {
        mContext = context.getApplicationContext();
        requestQueue=getQueue();

    }

    @Override
    public void doGet(String url, Map<String, String> paramsMap, IResponseListener
            iResponseListener) {
        doGet(url, paramsMap, null, iResponseListener);
    }

    @Override
    public void doGet(String url, final Map<String, String> paramsMap, NetworkOption
            networkOption, final IResponseListener iResponseListener) {
        RequestQueue queue = getQueue();
        url = NetUtils.checkUrl(url);
        url = NetUtils.appendUrl(url, paramsMap);

        printMes(url, paramsMap);
        // 检查 NetworkOption 的合法性
        final NetworkOption option = NetUtils.checkNetworkOption(networkOption, url);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response
                .Listener<String>() {
            @Override
            public void onResponse(String response) {
                handleResult(response, iResponseListener);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleError(error, iResponseListener);
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return handleHeaderMap(option);
            }

        };
        // 给每一个请求设置Tag，默认是URl
        request.setTag(option.mTag);
        request.setRetryPolicy(new DefaultRetryPolicy(15 * 1000, 1, 1.0f));
        queue.add(request);

    }

    @NonNull
    private Map<String, String> handleHeaderMap(NetworkOption option) {
        Map<String, String> headers = option.mHeaders;
        // 如果配置的 headers 不为空，采用配置的，否则采用默认的 headers
        if (headers != null && headers.size() > 0) {
            return headers;
        }

        return new HashMap<String, String>();
    }

    private void printMes(String url, Map<String, String> paramsMap) {
        LogUtil.i(" url=" + url);

    }

    @Override
    public void doPost(String url, Map<String, String> paramsMap, IResponseListener
            iResponseListener) {
        doPost(url, paramsMap, null, iResponseListener);
    }

    @Override
    public void doPost(String url, final Map<String, String> paramsMap, NetworkOption
            networkOption, final IResponseListener iResponseListener) {
        url = NetUtils.checkUrl(url);
        final NetworkOption option = NetUtils.checkNetworkOption(networkOption, url);
        printMes(url, paramsMap);
        //        This is Get
        //        url = MeiosUtils.appendUrl(url, paramsMap);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response
                .Listener<String>() {
            @Override
            public void onResponse(String response) {
                handleResult(response, iResponseListener);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleError(error, iResponseListener);

            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return handleHeaderMap(option);
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return paramsMap;
            }
        };
        RequestQueue queue = getQueue();
        // 给每一个请求设置Tag，默认是URl
        request.setTag(option.mTag);
        request.setRetryPolicy(new DefaultRetryPolicy(15 * 1000, 1, 1.0f));
        queue.add(request);
    }

    private void handleResult(String response, IResponseListener iResponseListener) {
        if(iResponseListener!=null){
            iResponseListener.onResponse(response);
        }

    }

    // 处理重新登录的相关逻辑
    private void handleLoginAgain() {

    }

    private void handleError(VolleyError error, IResponseListener iResponseListener) {
        HttpException httpException = new HttpException();
        httpException.e=error;
        if(iResponseListener!=null){
            iResponseListener.onFail(httpException);
        }

    }

    @Override
    public void cancel(final Object tag) {

        getQueue().cancelAll(new RequestQueue.RequestFilter() {
            @Override
            public boolean apply(Request<?> request) {
                return request.getTag().toString().equals(tag.toString());

            }
        });
    }

    private  RequestQueue getQueue() {
        if(requestQueue==null){
            requestQueue=Volley.newRequestQueue(mContext);
        }

        return requestQueue;
    }

    public static String getString(Map<String, String> map) {
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key).append("   ").append(value).append("\n");
        }
        return sb.toString();

    }
}
