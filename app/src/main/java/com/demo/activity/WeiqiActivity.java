package com.demo.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.view.WeiqiView;

public class WeiqiActivity extends AppCompatActivity {

    private WeiqiView weiqi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weiqi);
        weiqi = (WeiqiView) findViewById(R.id.weiqi);
        weiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weiqi.startAnimation();
            }
        });
    }
}