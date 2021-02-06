package com.demo.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BroadcastReceiverActivity extends BaseActivity {

    private IntentFilter intentFilter;
    private NetWorkChangeReceiver netWorkChangeReceiver;
    private Button bt_SendBroadcast;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        //动态监听网络变化（动态注册广播）
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkChangeReceiver = new NetWorkChangeReceiver();
        registerReceiver(netWorkChangeReceiver, intentFilter);

        //发送自定义广播（静态注册广播）
        bt_SendBroadcast = (Button) findViewById(R.id.bt_sendBroadcast);
        bt_SendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.demo.broadcastReceiver.MY_BroadcastReceiver");
                // Android 7.0及以下版本不是必须的，但是Android 8.0或者更高版本，
                // 发送广播的条件更加严苛，必须添加这一行内容。
                // 创建的ComponentName实例化对象有两个参数，
                // 第1个参数是指发广播类的包名，第2个参数是指接收广播类的完整类名
                intent.setComponent(new ComponentName(getPackageName(),"com.demo.broadcastReceiver.MyBroadcastReceiver"));
                sendBroadcast(intent);
            }
        });

    }

    class NetWorkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "网络发生变化", Toast.LENGTH_SHORT).show();
        }
    }

}