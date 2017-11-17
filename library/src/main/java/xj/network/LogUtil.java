package xj.network;

import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author meitu.xujun on 2017/9/6 9:56
 * @version 0.1
 */
public class LogUtil {

    private static final String TAG = "MEITU_SVIP";

    //    public static String cacheDir = "";
    public static String cacheDir = "/sdcard";
    public static String PATH = cacheDir + "/Log";
    public static final String LOG_FILE_NAME = "log.txt";

    /**
     * 是否写入日志文件
     */
    public static final boolean LOG_WRITE_TO_FILE = false;

    public static final boolean isIShow = true;
    public static final boolean isDShow = true;
    public static final boolean isWShow = true;
    public static final boolean isEShow = true;
    public static final boolean isJSONShow = true;

    public static void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext.getExternalCacheDir() != null && isExistSDCard()) {
            cacheDir = applicationContext.getExternalCacheDir().toString();

        } else {
            cacheDir = applicationContext.getCacheDir().toString();
        }
        PATH = cacheDir + "/Log";
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(4)         // (Optional) How many method line to show. Default 2
                .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
                 // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(TAG)   // (Optional) Global mTag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter());

    }

    public static final void json(String msg) {
       json(TAG,msg);
    }

    /**
     * 错误信息
     *
     * @param TAG
     * @param msg
     */
    public final static void e(String TAG, String msg) {
        if (isEShow) {
            Logger.t(generateTag(TAG)).e(msg);

        }
        if (LOG_WRITE_TO_FILE) writeLogtoFile("e", generateTag(TAG), msg);

    }

    public final static void e(String msg) {
        e(TAG, msg);


    }

    /**
     * 警告信息
     *
     * @param TAG
     * @param msg
     */
    public final static void w(String TAG, String msg) {
        if (isWShow) {
            Logger.t(generateTag(TAG)).w(msg);
        }

        if (LOG_WRITE_TO_FILE) writeLogtoFile("w", generateTag(TAG), msg);
    }

    public final static void w(String msg) {
        w(TAG, msg);
    }

    /**
     * 调试信息
     *
     * @param TAG
     * @param msg
     */
    public final static void d(String TAG, String msg) {
        if (isDShow) {
            Logger.t(generateTag(TAG)).d(msg);
        }

        if (LOG_WRITE_TO_FILE) writeLogtoFile("d", TAG, msg);
    }

    public final static void d(String msg) {
        d(TAG, msg);
    }

    /**
     * 提示信息
     *
     * @param TAG
     * @param msg
     */
    public final static void i(String TAG, String msg) {


        if (isIShow) {
            Logger.t(generateTag(TAG)).i(msg);
        }


        if (LOG_WRITE_TO_FILE) writeLogtoFile("i", TAG, msg);
    }



    public final static void json(String TAG, String msg) {


        if (isJSONShow) {
            Logger.t(generateTag(TAG)).json(msg);
        }


        if (LOG_WRITE_TO_FILE) writeLogtoFile("json", TAG, msg);
    }

    public final static void i(String msg) {
        i(TAG, msg);
    }

    /**
     * 写入日志到文件中
     *
     * @param logType
     * @param tag
     * @param msg
     */
    private static void writeLogtoFile(String logType, String tag, String msg) {
        isExist(PATH);
        //isDel();
        String needWriteMessage = "\r\n" + getNowYMDHMSTime() + "\r\n" + logType + "    "
                + generateTag(tag) + "\r\n" + msg;
        File parent = new File(PATH);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        File file = new File(PATH, LOG_FILE_NAME);
        try {
            FileWriter filerWriter = new FileWriter(file, true);
            BufferedWriter bufWriter = new BufferedWriter(filerWriter);
            bufWriter.write(needWriteMessage);
            bufWriter.newLine();
            bufWriter.close();
            filerWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除日志文件
     */
    public static void delFile() {

        File file = new File(PATH, LOG_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 判断文件夹是否存在,如果不存在则创建文件夹
     *
     * @param path
     */
    public static void isExist(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

    }

    private static boolean isExistSDCard() {
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment
                .MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getNowYMDHMSTime(){
        SimpleDateFormat mDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH");
        String date = mDateFormat.format(new Date());
        return date;
    }

    public static String generateTag(String tag){
        if(TAG.equals(tag)){
            return TAG;
        }
        return TAG+"_"+tag;
    }

}
