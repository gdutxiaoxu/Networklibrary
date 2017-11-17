package xj.network;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author meitu.xujun  on 2017/4/12 15:47
 * @version 0.1
 */

public class NetUtils {

    private static final String TAG = "NetUtils";


    public static Map<String, String> getCommonParams() {

        final Map<String, String> pairs = new HashMap<String, String>();

        return pairs;
    }

    @NonNull
    public static  String checkUrl(String url) {
        if(!url.startsWith("http:") && !url.startsWith("https:")){

        }
        return url;
    }

    public static NetworkOption checkNetworkOption(NetworkOption networkOption, String url) {
        if (networkOption == null) {
            networkOption = new NetworkOption.Builder().setTag(url).build();
        }
        return networkOption;
    }

    public static boolean needLoginAgain(int code) {
        return code == 10112 || code == 10113;
    }

    public static boolean isSuccessful(int code) {
        return code == 0;
    }



    //Add end
    public static String appendUrl(String origin, Map<String, String> nameValuePairs) {
        LogUtil.i(TAG, "original url is: " + origin);
        if (origin == null) {
            return null;
        }
        if(nameValuePairs==null){
            return origin;
        }
        try {
            boolean first = true;
            StringBuilder urlBuilder = new StringBuilder(origin);
            if (!origin.contains("?")) {
                urlBuilder.append("?");
            } else {
                urlBuilder.append("&");
                first = false;
            }
            for (Map.Entry<String, String> entry : nameValuePairs.entrySet()) {
                if (!first) {
                    urlBuilder.append("&");
                } else {
                    first = false;
                }
                String name = entry.getKey();
                String value = entry.getValue();
                Log.i(TAG, "name: " + name + ", value: " + value);
                urlBuilder.append(name);
                urlBuilder.append("=");
                if (value.contains(" ")) {
                    urlBuilder.append(Uri.encode(value, null));
                } else {
                    urlBuilder.append(URLEncoder.encode(value, "UTF-8"));
                }
            }
            Log.i(TAG, "after append get params, new url is: " + urlBuilder.toString());
            return urlBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return origin;
    }
}
