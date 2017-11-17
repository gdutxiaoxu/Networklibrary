package xj.network;

import android.content.Context;

import java.util.Map;

/**
 * @author meitu.xujun  on 2017/4/1 17:59
 * @version 0.1
 */

public interface NetRequest {

    void init(Context context);

     void doGet(String url, final Map<String, String> paramsMap, final IResponseListener
             iResponseListener);

     void doGet(String url, final Map<String, String> paramsMap, NetworkOption networkOption,
                final IResponseListener iResponseListener);


     void doPost(String url, final Map<String, String> paramsMap, final IResponseListener iResponseListener);

     void doPost(String url, final Map<String, String> paramsMap, NetworkOption networkOption,
                 final IResponseListener iResponseListener);



     void cancel(Object tag);



}
