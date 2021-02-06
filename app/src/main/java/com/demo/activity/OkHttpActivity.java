package com.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends BaseActivity implements View.OnClickListener {

    private Button bt_OkHttp_SendRequest;
    private TextView tv_OkHttp_Response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);

        tv_OkHttp_Response = (TextView)findViewById(R.id.tv_okHttp_response);
        bt_OkHttp_SendRequest = (Button)findViewById(R.id.bt_okHttp_sendRequest);
        bt_OkHttp_SendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_okHttp_sendRequest){
            sendRequestWithOkHtttp();
        }
    }

    private void sendRequestWithOkHtttp() {
        //开启线程来发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://www.baidu.com")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showRespone(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showRespone(String response) {
        //android中不允许在子线程中操作UI
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //在这里进行UI操作，将结果显示到界面上
                tv_OkHttp_Response.setText(response);
            }
        });
    }
}