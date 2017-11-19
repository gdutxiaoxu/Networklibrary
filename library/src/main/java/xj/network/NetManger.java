package xj.network;

import android.content.Context;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import xj.network.mtOkHttp.OKHttpRequest;

/**
 * @author meitu.xujun  on 2017/4/1 18:03
 * @version 0.1
 */

public class NetManger {

    private static NetRequest instance;
    private static Context mContext;

    public static NetRequest getRequest(){
        return instance;
    }

    static HashMap<String,NetRequest> mMap=new HashMap<>();

    public static void  init(Context context){
        instance = OKHttpRequest.getInstance();
        mContext = context.getApplicationContext();
        instance.init(NetManger.mContext);
    }

    public static <T extends NetRequest> NetRequest getRequest(Class<T> clz){
        String simpleName = clz.getSimpleName();
        NetRequest request = mMap.get(simpleName);
        if(request ==null){
            try {
                Constructor<T> constructor = clz.getDeclaredConstructor();
                constructor.setAccessible(true);
                request = constructor.newInstance();
                request.init(mContext);
                mMap.put(simpleName,request);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        instance=request;
        return request;

    }

}
