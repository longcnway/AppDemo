package com.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class MyViewGroup extends ViewGroup {

    private View myView;
    private int mWidth, mHeigth;
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        // 拿到子类
        myView = getChildAt(0);
    }

    /**
     * 负责对当前View的尺寸进行测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeigth = MeasureSpec.getSize(heightMeasureSpec);
        Log.d("TAG", "MyViewGroup-->onMeasure-->mWidth="+mWidth+"; mHeigth="+mHeigth);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        myView.layout(10, 10,500,500);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 负责把当前这个View绘制出来
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Paint paint = new Paint();
//        paint.setColor(Color.BLUE);
//        //开始绘制
//        canvas.drawRect(100,100,500,500, paint);
    }

    /**
     * 是事件分发机制中的核心，所有的事件调度都归它管
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean result = super.dispatchTouchEvent(event);
        Log.d("TAG", "MyViewGroup--->dispatchTouchEvent()==="+result);
        return result ;
    }

    /**
     * 拦截事件
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = super.onInterceptTouchEvent(ev);
        Log.d("TAG", "MyViewGroup--->onInterceptTouchEvent()==="+result);
        return result ;
    }

    /**
     * View自身处理
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        Log.d("TAG", "MyViewGroup--->onTouchEvent()==="+result);
        return result ;
    }

}

