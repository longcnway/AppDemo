package com.demo.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.demo.service.DownloadService;

public class DownloadActivity extends BaseActivity implements View.OnClickListener {

    private String url = "https://dldir1.qq.com/weixin/Windows/WeChatSetup.exe";
    private Button bt_Start_Download, bt_Puase_Download, bt_Cancel_Download;
    private DownloadService.DownloadBilder downloadBilder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBilder = (DownloadService.DownloadBilder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        bt_Start_Download = (Button) findViewById(R.id.bt_start_download);
        bt_Puase_Download = (Button) findViewById(R.id.bt_pause_download);
        bt_Cancel_Download = (Button) findViewById(R.id.bt_cancel_download);

        bt_Start_Download.setOnClickListener(this);
        bt_Puase_Download.setOnClickListener(this);
        bt_Cancel_Download.setOnClickListener(this);

        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);//启动服务
        bindService(intent, connection, BIND_AUTO_CREATE);//绑定服务
        if(ContextCompat.checkSelfPermission(DownloadActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(DownloadActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
    }

    @Override
    public void onClick(View v) {
        if(downloadBilder == null){
            return;
        }
        switch (v.getId()){
            case R.id.bt_start_download :
                downloadBilder.startDownload(url);
                break;
            case R.id.bt_pause_download :
                downloadBilder.pauseDownload();
                break;
            case R.id.bt_cancel_download :
                downloadBilder.cancelDownload();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1 :
                if(grantResults.length>0 && grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}