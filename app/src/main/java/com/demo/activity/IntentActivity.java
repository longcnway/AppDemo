package com.demo.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntentActivity extends BaseActivity {

    private Intent intent;
    private Button bt_Intent_show, bt_Intent_hide, bt_back_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        bt_Intent_show = (Button) findViewById(R.id.bt_intent_show);
        bt_Intent_hide = (Button) findViewById(R.id.bt_intent_hide);
        bt_back_result = (Button) findViewById(R.id.bt_back_result);

        bt_Intent_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用显示Intent
                Toast.makeText(IntentActivity.this, "使用显示Intent", Toast.LENGTH_SHORT).show();
                intent = new Intent(IntentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bt_Intent_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用隐式Intent
                Toast.makeText(IntentActivity.this, "使用隐式Intent", Toast.LENGTH_SHORT).show();
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        bt_back_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回数据给上一个activity
                intent = new Intent();
                intent.putExtra("data_return", "这是IntentActivity返回的数据");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        //返回数据给上一个activity
        intent = new Intent();
        intent.putExtra("data_return", "这是IntentActivity返回的数据");
        setResult(RESULT_OK, intent);
        finish();
    }
}