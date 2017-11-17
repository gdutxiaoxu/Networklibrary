
package xj.network;

import java.util.HashMap;

public  class NetworkConstant {
    public static final String CLIENT_ID = "1000000";

    
    //Add begin by meitu.yijiabin for
    public static final int GIFT_STATUS_INVALID = -1; //error or default
    public static final int GIFT_STATUS_NOT_RECIVER = 0; //
    public static final int GIFT_STATUS_RECIVER = 1;
    public static final int GIFT_STATUS_NOT_AUDIT = 2;   //not audit
    public static final int GIFT_STATUS_SEND = 3;        //already send
    public static final int GIFT_STATUS_SUCCESS = 4;     //user receive
    public static final int GIFT_STATUS_NOT_PASS = 5;    //audit no pass
    public static final int GIFT_STATUS_DRAWING = 6;
    public static final int GIFT_STATUS_DRAW_FAILURE = 7;//draw failure
    
    public static final int GIFT_TYPE_REAL = 1; //real goods
    public static final int GIFT_TYPE_COUPON = 2; //coupon
    public static final int GIFT_TYPE_S_CODE = 3; //s code
    
    public static final int AWARD_SENDTYPE_DEFAULT = 0;
    public static final int AWARD_SENDTYPE_SCRATCH = 1;
    
    public static final String KEY_USER_EXIT_TIME = "user_exit_time_"; 
    public static final String KEY_REMAINING_PROGRESS = "remaining_progress_";
    public static final String KEY_MAXPROGRESS = "maxprogress_";
    public static final String KEY_OPTIMIZATION_PROGRESS = "optimization_progress_"; 
    
    public static final int USER_STATUS_ISSIGNUP = 1;
    public static final int USER_STATUS_NOT_SIGNUP = 0;
    //Add end
    
    public static final int SHOW_LOADING = 1;
    public static final int SHOW_MAIN = 2;
    public static final int SHOW_RELOAD = 3;
    
    public static final String SP_USER = "user";
    public static final String SP_ACCESSTOKEN = "access_token";
    public static final String SP_EXPIRESAT = "expires_at";
    public static final String SP_ID = "id";
    public static final String SP_NAME = "name";
    public static final String SP_REALNAME = "realname";
    public static final String SP_AVATAR = "avatar";
    public static final String SP_AVATAR_CACHE = "avatar_cache";
    public static final String SP_BIRTHDAY = "birthday";
    public static final String SP_GENDER = "gender";
    public static final String SP_PROVINE = "provine";
    public static final String SP_CITY = "city";
    public static final String SP_COUNTRY_ID = "countryid";
    public static final String SP_PROVINCE_ID = "provinceid";
    public static final String SP_CITY_ID = "cityid";
    public static final String SP_ADDRESS = "address";
    public static final String SP_EMAIL = "email";
    public static final String SP_PHONE = "phone";
    public static final String SP_PHONE_CC = "phone_cc";
    public static final String SP_IS_VERIFIED = "is_verified";
    public static final String SP_CREATED_AT = "created_at";
    public static final String SP_IS_AUTO_NAME = "is_auto_name";

    public static final String MEITU_SINA_URL = "http://weibo.com/u/3133173374?topnav=1&wvr=6&topsug=1";
    //Add begin by meitu.yijiabin for
    public static final String MEITU_SINA_UID = "3133173374";
    //Add end
    public static final String IS_FROM_REGISTER = "is_from_register";
    public static final String IS_FROM_MAIN = "is_from_main";

    public static final String CAN_CLEAN_FOLDER = ".meitu.club.temp/cache";

    public static final String PERMISSION_WAS_ALLOWED = "meitu_permission_was_allowed";

    public static final int ACCOUNT_LOGIN_NEED_VERIFY_CODE = 21019;

    public static final int DETAIL_TYPE_APPLY = 1;
    public static final int DETAIL_TYPE_IEMI_BIND = 2;
    public static final int DETAIL_TYPE_PHOTO = 3;
    public static final int DETAIL_TYPE_VOTE = 4;
    public static final int DETAIL_TYPE_SIGNUP = 5;
    public static final int DETAIL_TYPE_COMPARED = 6;
    public static final int DETAIL_TYPE_TO_MEITU = 7;
    //Add begin by meitu.yijiabin for
    public static final int DETAIL_TYPE_SHARE = 8;
    //Add end

    public static final int ACTIVITY_STATUS_NOT_RECEIVE = 0;
    public static final int ACTIVITY_STATUS_AUDITER = 1;
    public static final int ACTIVITY_STATUS_NOT_REVIEWED = 2;
    public static final int ACTIVITY_STATUS_SHIPPED = 3;
    public static final int ACTIVITY_STATUS_RECEIVED = 4;
    public static final int ACTIVITY_STATUS_NOT_PASSED = 5;
    // add begin by yangyoujun for bug 34264
    public static final int ACTIVITY_STATUS_NULL = 6;
    // add end
    
    public static final int NETWORK_UNABLE = 100;
    /*
     *请求超时
     */
    public static final int TIMEOUTERROR = 0;
    /*
     *无法连接服务器
     */
    public static final int NOCONNECTIONERROR = 1;
    /*
     *网络错误
     */
    public static final int NETWORKERROR = 2;
    /*
     *服务器响应失败
     */
    public static final int SERVERERROR = 3;
    /*
     *服务器返回错误
     */
    public static final int PARSEERROR = 4;
    /*
     *其他错误
     */
    public static final int OTHERERROR = 5;
    /*
     * 服务器认证失败
     */
    public static final int AUTHFAILUREERROR = 6;
    
    public static final int TIME_ERROR = 10014;
    //Add begin by meitu.yijiabin for
    public static final String PARAMS = "PARAMS";
    public static final String BASE_URL = "http://clubapi.meitu.com/";
    public static final String BASE_URL_TEXT ="http://preclubapi.meitu.com/" ;
    public static boolean IGNORE_UPDATE = false;
    public static boolean UPDATE_DIALOG_SHOWING = false;
    public static boolean USER_LOGINED = false;
    
    /*getall for first time to get data,it will init view
     * getmore for get next page data
     * */
    public static int GETDATATYPE_GETALL = 1;
    public static int GETDATATYPE_GETMORE = 2;
    
    public static final int SERVERCENTER_GET_BY_CITY =1 ;
    public static final int SERVERCENTER_GET_BY_DISTANCE =2 ;
    
    public static final int NUMBER_FOR_PAGE = 5;
    
    public static final int SERVERCENTER_GETTYPE_MAINTENANCE =1 ;
    public static final int SERVERCENTER_GETTYPE_EXPERIENCE =2 ;
    
    public static final String BAIDU_MAP_KEY = "lfhWzFBkPX4LYhtPLXdtEMqlkKGMjDMr";
    public static final String BAIDU_MAP_CITY_API = "http://api.map.baidu.com/geocoder/v2/?ak="
            + BAIDU_MAP_KEY
            + "&output=json&pois=0&location=%s,%s";
    public static final String BAIDU_MAP_LOCATE_API = "http://api.map.baidu.com/geocoder/v2/?address=%s&output=json&ak="
            + BAIDU_MAP_KEY;
    
    public static final int AREA_REQUESTCODE = 0x999;
    
    public static final String PREF_HAS_NEW_NOTIFICATION = "has_new_notification";
    
    public static final String KEY_JUMP_PAGEID = "key_jump_pageid";

    
    public static HashMap<Integer, Class> sPages = new HashMap<Integer, Class>();

    public static  boolean DEBUG = false;

    
    
    public static final int TAB_HOME_SELECTED = 0;
    public static final int TAB_DISCOVERY_SELECTED = 1;
    public static final int TAB_ACCOUNTCENTER_SELECTED = 2;
    // public static final int TAB_ACCOUNTLOGIN_SELECTED = 3;
    
    public static final String KEY_PAGER_CURRENT_ITEAM = "current_iteam";
    
    public static final String KEY_TAB_CURRENT_ITEAM = "tab_current_item";
    
    public static final int NOTIFICATION_PAGEID =1 ;
    public static final int DISCOVERY_PAGEID =2 ;
    public static final int SELFIE_PAGEID =3 ;//course list
    public static final int SERVERCENTER_MAINTENANCE_PAGEID =4 ;
    public static final int SERVERCENTER_EXPERIENCE_PAGEID =5 ;
    public static final int MEITUACCOUNTCENTER_PAGEID =6 ;
    public static final int ADDRESS_PAGEID =7 ;
    public static final int VOUCHER_PAGEID =8 ;
    public static final int TABMAIN_PAGEID =9 ;//the activity list 
    public static final int EXPRESS_PAGEID =10 ;
    public static final int MEITUDETAIL_PAGEID =11 ;//activity detail

    //Add end
    public static boolean RELEASE_DEBUG = true;           // control client_url
    public static APP_ENVIRO enviro = APP_ENVIRO.RELEASE; // control client_secret
    
    public static enum APP_ENVIRO {
        RELEASE, DEBUG
    }
    
    public static final String CLIENT_SECRET_LOGIN = "znviFP9#aNq";
    public static final String CLIENT_SECRET = "Rhhz59GiCUF4Wwn9dI7XuTKgTa";
    public static final String CLIENT_SECRET_TEST = "bbbbb";

    public static final String URL_SHOWROOM_LIST_UPDATE = "activity/list.json";
    public static final String URL_SHOWROOM_LIST_UPDATE_TEST = "http://preclubapi.meitu.com/activity/list.json";

    public static final String URL_TOKEN_UPDATE = "common/get_upload_token.json";
    public static final String URL_TOKEN_UPDATE_TEST = "http://preclubapi.meitu.com/common/get_upload_token.json";

    public static final String URL_DETAIL_DATA = "activity/show.json";
    public static final String URL_DETAIL_DATA_TEST = "http://preclubapi.meitu.com/activity/show.json";

    public static final String URL_ACCEPT_DATA = "express/show.json";
    public static final String URL_ACCEPT_DATA_TEST = "http://preclubapi.meitu.com/express/show.json";

    public static final String URL_CHECK_UPDATE = "common/version.json";
    public static final String URL_CHECK_UPDATE_TEST = "http://preclubapi.meitu.com/common/version.json";

    public static final String URL_GET_ADRESS_DATA = "delivery/list.json";
    public static final String URL_GET_ADRESS_DATA_TEST = "http://preclubapi.meitu.com/delivery/list.json";
    public static final String URL_CREATE_ADDRESS = "delivery/create.json";
    public static final String URL_CREATE_ADDRESS_TEST = "http://preclubapi.meitu.com/delivery/create.json";
    public static final String URL_DELETE_ADDRESS = "delivery/delete.json";
    public static final String URL_DELETE_ADDRESS_TEST = "http://preclubapi.meitu.com/delivery/delete.json";
    public static final String URL_UPDATE_ADDRESS = "delivery/update.json";
    public static final String URL_UPDATE_ADDRESS_TEST = "http://preclubapi.meitu.com/delivery/update.json";

    public static final String URL_SUBMIT_DATA = "activity/submit.json";
    public static final String URL_SUBMIT_DATA_TEST = "http://preclubapi.meitu.com/activity/submit.json";

    public static final String URL_PHOTO_CHECK = "activity/upload_check.json";
    public static final String URL_PHOTO_CHECK_TEST = "http://preclubapi.meitu.com/activity/upload_check.json";
    public static final String URL_UPDALOG_CALLBACK = "activity/upload_callback.json";
    public static final String URL_UPDALOG_CALLBACK_TEST = "http://preclubapi.meitu.com/activity/upload_callback.json";

    public static final String URL_GET_VERIFY_CODE = "https://id.api.meitu.com/v2/users/send_verify_code_to_phone.json";
    public static final String URL_GET_VERIFY_CODE_TEST = "http://preid.api.meitu.com/v2/users/send_verify_code_to_phone.json";
    public static final String URL_USER_REGISTER = "https://id.api.meitu.com/v2/oauth/access_token.json";
    public static final String URL_USER_REGISTER_TEST = "http://preid.api.meitu.com/v2/oauth/access_token.json";
    public static final String URL_CREATE_INITIAL_LOGIN = "https://id.api.meitu.com/v2/users/create_in_initial_login.json";
    public static final String URL_CREATE_INITIAL_LOGIN_TEST = "http://preid.api.meitu.com/v2/users/create_in_initial_login.json";
    public static final String URL_RESET_PASSWORD = "http://id.api.meitu.com/v2/users/reset_password_by_phone_verify_code.json";
    public static final String URL_RESET_PASSWORD_TEST = "http://preid.api.meitu.com/v2/users/reset_password_by_phone_verify_code.json";

    public static final String LOGIN_URL = "https://id.api.meitu.com/v2/oauth/access_token.json";
    public static final String LOGIN_TEST_URL = "http://preid.api.meitu.com/v2/oauth/access_token.json";
    public static final String GET_CAPTHCHA_VERIFY = "http://id.api.meitu.com/v2/common/appcaptcha";
    public static final String GET_CAPTHCHA_VERIFY_TEST = "http://preid.api.meitu.com/v2/common/appcaptcha";

    public static final String GET_JOIN_ACTIVITIES = "user/activity/list.json";
    public static final String GET_JOIN_ACTIVITIES_TEST = "http://preclubapi.meitu.com/user/activity/list.json";

    public static final String URL_FEEDBACK = "feedback/submit.json";
    public static final String URL_FEEDBACK_TEST = "http://preclubapi.meitu.com/feedback/submit.json";
    
    //Add begin by meitu.yijiabin
    public static final String URL_DRAW = "activity/draw.json";
    public static final String URL_DRAW_TEST = "http://preclubapi.meitu.com/activity/draw.json";
    public static final String URL_GETSELFIE = "selfie/list.json";
    public static final String URL_GETSELFIE_TEST = "http://preclubapi.meitu.com/selfie/list.json";
    public static final String URL_SERVER_CENTER = "service/nearby.json";
    public static final String URL_SERVER_CENTER_TEST = "http://preclubapi.meitu.com/service/nearby.json";
    public static final String URL_SERVER_CENTER_BY_CITY = "service/list.json";
    public static final String URL_SERVER_CENTER_BY_CITY_TEST = "http://preclubapi.meitu.com/service/list.json";
    public static final String URL_GETNOTIFICATION = "inform/list.json";
    public static final String URL_GETNOTIFICATION_TEST = "http://preclubapi.meitu.com/inform/list.json";
    //Add end

    //Add begin by meitu.yangyoujun
    public static final String GET_MY_SIGN_UP_INFO = "signup/show.json";
    public static final String GET_MY_SIGN_UP_INFO_TEST = "http://preclubapi.meitu.com/signup/show.json";

    public static final String GET_MONTHLY_SIGN_UP_LIST = "signup/list.json";
    public static final String GET_MONTHLY_SIGN_UP_LIST_TEST = "http://preclubapi.meitu.com/signup/list.json";

    public static final String URL_SIGN_UP = "signup/add.json";
    public static final String URL_SIGN_UP_TEST = "http://preclubapi.meitu.com/signup/add.json";
    //Add end

    //Add begin by senfa.chen
    public static final String URL_COUPON = "user/coupon/list.json";
    public static final String URL_REBIND_IMEI = "user/imei/rebind.json";
    //Add end
    //Add begin by meitu.yijiabin
    public static final String URL_COUPON_TEST = "http://preclubapi.meitu.com/user/coupon/list.json";
    public static final String URL_REBIND_TEST = "http://preclubapi.meitu.com/user/imei/rebind.json";
    //Add end
    
    //is open analytics android log
    public static final boolean IS_OPEN_ANALYTICS_ANDROID_LOG = false;
    //is open analytics toast
    public static final boolean IS_OPEN_ANALYTICS_TOAST = false;
    //is open analytics local log
    public static final boolean IS_OPEN_ANALYTICS_LOCAL_LOG = false;


}
