package xj.network;

import android.content.Context;

import xj.network.mtOkHttp.OKHttpRequest;
import xj.network.volley.VolleyRequest;

/**
 * @author meitu.xujun  on 2017/4/1 18:03
 * @version 0.1
 */

public class NetManger {

    private static NetRequest instance;

    public static NetRequest getInstance(){
        return instance;
    }

    public static void  init(Context context){
        instance = OKHttpRequest.getInstance();
        instance.init(context.getApplicationContext());
    }

}
