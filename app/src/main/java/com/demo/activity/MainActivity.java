package com.demo.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
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
            bt_OkHttp, bt_ServcieTest, bt_Download, bt_UI_MaterialDesign, bt_My_View,
            bt_Weiqi, bt_Event_Dispatch;

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
        bt_ServcieTest = (Button) findViewById(R.id.bt_serviceTest);
        bt_Download = (Button) findViewById(R.id.bt_download);
        bt_UI_MaterialDesign = (Button) findViewById(R.id.bt_UI_MaterialDesign);
        bt_My_View = (Button) findViewById(R.id.bt_my_view);
        bt_Weiqi = (Button) findViewById(R.id.bt_weiqi);
        bt_Event_Dispatch = (Button) findViewById(R.id.bt_event_dispatch);

        bt_BottomTabLayout.setOnClickListener(this);
        bt_RecyclerView.setOnClickListener(this);
        bt_Intent.setOnClickListener(this);
        bt_BroadcastReceiver.setOnClickListener(this);
        bt_Out_Login.setOnClickListener(this);
        bt_Notification.setOnClickListener(this);
        bt_WebView.setOnClickListener(this);
        bt_HttpURLConnection.setOnClickListener(this);
        bt_OkHttp.setOnClickListener(this);
        bt_ServcieTest.setOnClickListener(this);
        bt_Download.setOnClickListener(this);
        bt_UI_MaterialDesign.setOnClickListener(this);
        bt_My_View.setOnClickListener(this);
        bt_Weiqi.setOnClickListener(this);
        bt_Event_Dispatch.setOnClickListener(this);
        Log.d("TAG", "MainActivity-->onCreate()");
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
                /**使用Notification通知再Android8.0以上的的通知要设置渠道，否则就无法显示**/
                String ID = "com.demo.activity";	//这里的id里面输入自己的项目的包的路径
                String NAME = "Channel One";
                intent = new Intent(MainActivity.this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                NotificationCompat.Builder notificationBuilder; //创建服务对象
                NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(ID, NAME, manager.IMPORTANCE_HIGH);
                    channel.enableLights(true);
                    channel.setShowBadge(true);
                    channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                    manager.createNotificationChannel(channel);
                    notificationBuilder = new NotificationCompat.Builder(this).setChannelId(ID);
                } else {
                    notificationBuilder = new NotificationCompat.Builder(this);
                }
                notificationBuilder.setContentTitle("通知标题")
                        .setContentText("通知内容##################通知内容")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.fruit_imge1))
                        .setContentIntent(pi)
                        .setAutoCancel(true)//取消通知
                        .build();
                Notification notification = notificationBuilder.build();
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
            case R.id.bt_serviceTest :
                //Service服务学习
                intent = new Intent(MainActivity.this, ServiceTestActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_download :
                //下载综合示例
                intent = new Intent(MainActivity.this, DownloadActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_UI_MaterialDesign :
                //UI体验--MaterialDesign实战
                intent = new Intent(MainActivity.this, UIMaterialDesignActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_my_view :
                //自定义view画圆
                intent = new Intent(MainActivity.this, MyViewActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_weiqi :
                //围棋
                intent = new Intent(MainActivity.this, WeiqiActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_event_dispatch :
                //事件分发
                intent = new Intent(MainActivity.this, EventDispatchActivity.class);
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "MainActivity-->onStart()");
    }

    /**
     * 获得焦点
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "MainActivity-->onResume()");
    }

    /**
     * 失去焦点
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "MainActivity-->onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "MainActivity-->onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "MainActivity-->onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "MainActivity-->onRestart()");
    }
}