package xj.network;

/**
 * @author meitu.xujun  on 2017/3/22 16:10
 * @version 0.1
 */

public interface IResponseListener {

    void onResponse(String response);
    void onFail(HttpException httpException);
}
