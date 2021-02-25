package com.demo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class EventDispatchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_dispatch);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean result = false; //super.dispatchTouchEvent(event);
        Log.d("ED_TAG", "EventDispatchActivity--->dispatchTouchEvent()==="+result);
        return super.dispatchTouchEvent(event) ;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = false; //super.onTouchEvent(event);
        Log.d("ED_TAG", "EventDispatchActivity--->onTouchEvent()==="+result);
        return super.onTouchEvent(event) ;
    }
}