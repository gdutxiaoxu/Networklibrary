package xj.network;

import java.util.Map;

/**
 * @author meitu.xujun  on 2017/9/7
 * @version 0.1
 */
public class NetworkOption {

    /**
     * 网络请求的 TAG
     */
    public String mBaseUrl;
    public String mTag;
    public Map<String,String> mHeaders;

    public NetworkOption(String tag) {
        this.mTag = tag;
    }

    public static final  class Builder{
        public String tag;
        public Map<String,String> mHeaders;
        public String mBaseUrl;

        public Builder setTag(String tag){
            this.tag=tag;
            return this;
        }

        public Builder setHeaders(Map<String,String> headers){
            mHeaders=headers;
            return this;

        }

        public Builder setBaseUrl(String baseUrl) {
            mBaseUrl = baseUrl;
            return this;
        }

        public NetworkOption build(){
            NetworkOption networkOption = new NetworkOption(tag);
            networkOption.mHeaders=mHeaders;
            networkOption.mBaseUrl=mBaseUrl;
            return networkOption;
        }
    }
}
