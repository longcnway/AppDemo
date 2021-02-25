package com.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyLinearLayout extends LinearLayout {


    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = false;//super.onInterceptTouchEvent(ev);
        Log.d("ED_TAG", "MyLinearLayout--->onInterceptTouchEvent()==="+result);
        return super.onInterceptTouchEvent(ev) ;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean result = false;//super.dispatchTouchEvent(event);
        Log.d("ED_TAG", "MyLinearLayout--->dispatchTouchEvent()==="+result);
        return super.dispatchTouchEvent(event) ;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = false;//super.onTouchEvent(event);
        Log.d("ED_TAG", "MyLinearLayout--->onTouchEvent()==="+result);
        return super.onTouchEvent(event) ;
    }
}
