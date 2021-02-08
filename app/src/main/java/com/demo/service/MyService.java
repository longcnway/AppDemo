package com.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    public class DownloadBinder extends Binder {
        public void startDownload() {

        }
        public int getProgress() {
            return 0;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(MyService.this, "onBind()绑定服务", Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(MyService.this, "onUnbind()解绑服务", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(MyService.this, "onCreate()创建服务", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MyService.this, "onStartCommand()启动服务", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(MyService.this, "onDestory()销毁服务", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

}