package com.demo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.demo.service.MyIntentService;
import com.demo.service.MyService;
import com.demo.service.MyStartForegroundService;

public class ServiceTestActivity extends BaseActivity implements View.OnClickListener {

    private Intent intent;
    private Button bt_StartService, bt_StopService, bt_BindService, bt_UnbindService,
            bt_StartForegroundService, bt_StartIntentService;
    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder)service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        bt_StartService = (Button) findViewById(R.id.bt_startService);
        bt_StopService = (Button) findViewById(R.id.bt_stopService);
        bt_BindService = (Button) findViewById(R.id.bt_bindService);
        bt_UnbindService = (Button) findViewById(R.id.bt_unbindService);
        bt_StartForegroundService = (Button) findViewById(R.id.bt_startForegroundService);
        bt_StartIntentService = (Button) findViewById(R.id.bt_startIntentService);

        bt_StartService.setOnClickListener(this);
        bt_StopService.setOnClickListener(this);
        bt_BindService.setOnClickListener(this);
        bt_UnbindService.setOnClickListener(this);
        bt_StartForegroundService.setOnClickListener(this);
        bt_StartIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_startService :
                intent = new Intent(this, MyService.class);
                startService(intent);//启动服务
                break;
            case R.id.bt_stopService :
                intent = new Intent(this, MyService.class);
                stopService(intent);//停止服务
                break;
            case R.id.bt_bindService :
                intent = new Intent(this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);//绑定服务
                break;
            case R.id.bt_unbindService :
                unbindService(connection);//解绑服务
                break;
            case R.id.bt_startForegroundService :
                intent = new Intent(this, MyStartForegroundService.class);
                startService(intent);//启动前台服务
                break;
            case R.id.bt_startIntentService :
                intent = new Intent(this, MyIntentService.class);
                startService(intent);//启动IntentService（集开启线程和自动停止于一身，运行在子线程，可以做耗时任务处理）
                break;
            default:break;
        }
    }
}