package com.demo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class MyButton extends Button {

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean result = false; //super.dispatchTouchEvent(event);
        Log.d("ED_TAG", "MyButton--->dispatchTouchEvent()===");
        return super.dispatchTouchEvent(event) ;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = false; //super.onTouchEvent(event);
        Log.d("ED_TAG", "MyButton--->onTouchEvent()===");

        return super.onTouchEvent(event) ;
    }
}
