package xj.networklibrary;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import xj.network.HttpException;
import xj.network.IResponseListener;
import xj.network.LogUtil;
import xj.network.NetManger;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    String url = "http://route.showapi.com/109-34";
    private Button mBtnGet;
    private Button mBtnPush;
    private TextView mTv;
    private HashMap<String, String> mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        NetManger.init(this);
        LogUtil.init(this);
        mMap = new HashMap<>();
        mMap.put("showapi_appid","29571");
        mMap.put("showapi_sign","5bf00910e04a46998f6979f6da400f1e");
    }

    private void initView() {
        mBtnGet = (Button) findViewById(R.id.btn_get);
        mBtnPush = (Button) findViewById(R.id.btn_push);
        mTv = (TextView) findViewById(R.id.tv);
        mBtnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetManger.getInstance().doGet(url, mMap, new IResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        mTv.setText("GET 请求\n"+response);
                        boolean b = Looper.getMainLooper() == Looper.myLooper();
                        LogUtil.i(TAG,"onResponse:   b="+b);
                        LogUtil.i(TAG,"onResponse:  response ="+response);
                    }

                    @Override
                    public void onFail(HttpException httpException) {
                        Log.i(TAG, "onFail: httpException=" +httpException.toString());
                    }
                });
            }
        });
        mBtnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetManger.getInstance().doPost(url, mMap, new IResponseListener() {
                    @Override
                    public void onResponse(String response) {
                        mTv.setText("post 请求\n"+response);
                        LogUtil.i(TAG,"onResponse:  response ="+response);
                    }

                    @Override
                    public void onFail(HttpException httpException) {
                        Log.i(TAG, "onFail: httpException=" +httpException.toString());
                    }
                });
            }
        });

    }
}
