package com.demo.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Intent intent;
    private Button bt_BottomTabLayout, bt_RecyclerView, bt_Intent, bt_Out_Login,
            bt_BroadcastReceiver, bt_Notification, bt_WebView, bt_HttpURLConnection,
            bt_OkHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_BottomTabLayout = (Button) findViewById(R.id.bt_bottom_tab_layout);
        bt_RecyclerView = (Button) findViewById(R.id.bt_recycler_view);
        bt_Intent = (Button) findViewById(R.id.bt_intent);
        bt_BroadcastReceiver = (Button) findViewById(R.id.bt_broadcastReceiver);
        bt_Out_Login = (Button) findViewById(R.id.bt_out_login);
        bt_Notification = (Button) findViewById(R.id.bt_notification);
        bt_WebView = (Button) findViewById(R.id.bt_webView);
        bt_HttpURLConnection = (Button) findViewById(R.id.bt_httpURLConnection);
        bt_OkHttp = (Button) findViewById(R.id.bt_okHttp);

        bt_BottomTabLayout.setOnClickListener(this);
        bt_RecyclerView.setOnClickListener(this);
        bt_Intent.setOnClickListener(this);
        bt_BroadcastReceiver.setOnClickListener(this);
        bt_Out_Login.setOnClickListener(this);
        bt_Notification.setOnClickListener(this);
        bt_WebView.setOnClickListener(this);
        bt_HttpURLConnection.setOnClickListener(this);
        bt_OkHttp.setOnClickListener(this);
    }

    /**
     * 监听事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_bottom_tab_layout :
                //TabLayout学习
                intent = new Intent(MainActivity.this, BottomTabLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_recycler_view :
                //滚动控件recyclerView学习
                intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_intent :
                intent = new Intent(MainActivity.this, IntentActivity.class);
                //要启动的activity可以返回数据，使用onActivityResult()接收返回来的数据
                startActivityForResult(intent, 1);
                break;
            case R.id.bt_broadcastReceiver :
                //广播接收器BroadcastReceiver学习
                intent = new Intent(MainActivity.this, BroadcastReceiverActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_out_login :
                //使用广播实现强制下线功能，发送广播
                intent = new Intent("com.demo.FORCE_OFFLINE");
                sendBroadcast(intent);
                break;
            case R.id.bt_notification :
                //发送通知notification，学习
                Log.d("TAG", "onClick: ----------bt_notification-----------");
                intent = new Intent(MainActivity.this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(getApplicationContext())
                        .setContentTitle("通知标题")
                        .setContentText("通知内容####################################！")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.fruit_imge1))
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1, notification);
                break;
            case R.id.bt_webView :
                //WebView学习
                intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_httpURLConnection :
                //HttpURLConnection学习
                intent = new Intent(MainActivity.this, HttpURLConnectionActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_okHttp :
                //OkHttp学习
                intent = new Intent(MainActivity.this, OkHttpActivity.class);
                startActivity(intent);
                break;

            default:break;
        }
    }

    /**
     * anctivity中使用menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * anctivity中menu响应事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(MainActivity.this, "你点击了添加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this, "你点击了删除", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    /**
     * 接收别的activity返回来的数据
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Toast.makeText(MainActivity.this, returnData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    // 用来计算返回键的点击间隔时间
    private long exitTime = 0;

    /**
     * 按两次返回键退出程序
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                //弹出提示，可以有多种方式
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}