package xj.network;

/**
 * @author meitu.xujun  on 2017/4/8 17:26
 * @version 0.1
 */

public class HttpException {

    public int code;
    public Exception e;
    public String errMsg;

    public HttpException() {
    }

    public HttpException(int code, Exception e, String errMsg) {
        this.code = code;
        this.e = e;
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "HttpException{" +
                "code=" + code +
                ", e=" + e +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
