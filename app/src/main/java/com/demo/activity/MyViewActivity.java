package com.demo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MyViewActivity extends BaseActivity implements View.OnClickListener {

    private ViewGroup my_view_group;
    private View my_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);

        my_view_group = (ViewGroup) findViewById(R.id.my_view_group);
        my_view = (View) findViewById(R.id.my_view);

        my_view_group.setOnClickListener(this);
        my_view.setOnClickListener(this);
    }

    /**
     * 是事件分发机制中的核心，所有的事件调度都归它管
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean result = super.dispatchTouchEvent(event);
        Log.d("TAG", "MyViewActivity--->dispatchTouchEvent()==="+result);
        return result;
    }

    /**
     * View自身处理
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        Log.d("TAG", "MyViewActivity--->onTouchEvent()==="+result);
        return result;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_view_group :
                Toast.makeText(MyViewActivity.this, "ViewGroup被点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_view :
                Toast.makeText(MyViewActivity.this, "View被点击了", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}