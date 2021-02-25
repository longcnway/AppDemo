package com.demo.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.demo.activity.R;

public class WeiqiView extends View implements ValueAnimator.AnimatorUpdateListener {
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private int useWidth, minwidth;
    private int leftcolor;
    private int rightcolor;
    private int qipancolor;
    private int animaltime;
    //画一个圆（棋子）
    ValueAnimator bounceAnim, bounceAnim1 = null;
    ShapeHolder ball, ball1 = null;
    QiziXYHolder ballHolder, ballHolder1 = null;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WeiqiView(Context context) {
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WeiqiView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WeiqiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
        initCustomAttrs(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WeiqiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        initPaint();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    /**
     * 获取自定义属性
     */
    private void initCustomAttrs(Context context, AttributeSet attrs) {
        //获取自定义属性。
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.WeiqiView);
        //获取颜色
        leftcolor = ta.getColor(R.styleable.WeiqiView_leftscolor, Color.BLACK);
        rightcolor = ta.getColor(R.styleable.WeiqiView_rightscolor, Color.WHITE);
        qipancolor = ta.getColor(R.styleable.WeiqiView_qipancolor, Color.BLACK);
        animaltime = ta.getInt(R.styleable.WeiqiView_animalstime, 2000);
        //回收
        ta.recycle();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint = new Paint();        //创建画笔对象
        mPaint.setColor(Color.BLACK);    //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL); //设置画笔模式为填充
        mPaint.setStrokeWidth(4f);     //设置画笔宽度为10px
        mPaint.setAntiAlias(true);     //设置抗锯齿
        mPaint.setAlpha(255);        //设置画笔透明度
    }

    /**
     * 控件大小发生改变时调用
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        useWidth = mWidth;
        if (mWidth > mHeight) {
            useWidth = mHeight;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
        minwidth = useWidth / 10;
        mPaint.setColor(qipancolor);
        if (ball == null) {
            ball = createBall(3 * minwidth, 3 * minwidth, leftcolor);
            ballHolder = new QiziXYHolder(ball);
        }
        if (ball1 == null) {
            ball1 = createBall(7 * minwidth, 7 * minwidth, rightcolor);
            ballHolder1 = new QiziXYHolder(ball1);
        }
        //细的X轴
        canvas.drawLine(minwidth, 3 * minwidth, 9 * minwidth, 3 * minwidth, mPaint);// 斜线
        canvas.drawLine(minwidth, 5 * minwidth, 9 * minwidth, 5 * minwidth, mPaint);// 斜线
        canvas.drawLine(minwidth, 7 * minwidth, 9 * minwidth, 7 * minwidth, mPaint);// 斜线
        //细的y轴
        canvas.drawLine(3 * minwidth, minwidth, 3 * minwidth, 9 * minwidth, mPaint);// 斜线
        canvas.drawLine(5 * minwidth, minwidth, 5 * minwidth, 9 * minwidth, mPaint);// 斜线
        canvas.drawLine(7 * minwidth, minwidth, 7 * minwidth, 9 * minwidth, mPaint);// 斜线
        mPaint.setStrokeWidth(8f);
        //粗的X轴（边框）
        canvas.drawLine(minwidth, minwidth, 9 * minwidth, minwidth, mPaint);// 斜线
        canvas.drawLine(minwidth, 9 * minwidth, 9 * minwidth, 9 * minwidth, mPaint);// 斜线
        //粗的y轴（边框）
        canvas.drawLine(minwidth, minwidth, minwidth, 9 * minwidth, mPaint);// 斜线
        canvas.drawLine(9 * minwidth, minwidth, 9 * minwidth, 9 * minwidth, mPaint);// 斜线
        //补瑕疵
        canvas.drawPoint(minwidth, minwidth, mPaint);
        canvas.drawPoint(9 * minwidth, minwidth, mPaint);
        canvas.drawPoint(minwidth, 9 * minwidth, mPaint);
        canvas.drawPoint(9 * minwidth, 9 * minwidth, mPaint);
//        //画围棋
//        canvas.drawCircle(3*minwidth, 3*minwidth, useWidth/16, mPaint);
//        canvas.drawCircle(3*minwidth, 7*minwidth, useWidth/16, mPaint);
//        canvas.drawCircle(5*minwidth, 5*minwidth, useWidth/16, mPaint);
//        canvas.drawCircle(7*minwidth, 3*minwidth, useWidth/16, mPaint);
//        canvas.drawCircle(7*minwidth, 7*minwidth, useWidth/16, mPaint);
//        mPaint.setColor(rightcolor);
//        canvas.drawCircle(3*minwidth, 5*minwidth, useWidth/16, mPaint);
//        canvas.drawCircle(5*minwidth, 3*minwidth, useWidth/16, mPaint);
//        canvas.drawCircle(5*minwidth, 7*minwidth, useWidth/16, mPaint);
//        canvas.drawCircle(7*minwidth, 5*minwidth, useWidth/16, mPaint);

        canvas.save();
        canvas.translate(ball.getX(), ball.getY());
        ball.getShape().draw(canvas);
        canvas.restore();

        canvas.save();
        canvas.translate(ball1.getX(), ball1.getY());
        ball1.getShape().draw(canvas);
        canvas.restore();
    }

    /**
     * 创建棋子
     * @param x
     * @param y
     * @param color
     * @return
     */
    private ShapeHolder createBall(float x, float y, int color) {
        OvalShape circle = new OvalShape();
        circle.resize(useWidth / 8f, useWidth / 8f);
        ShapeDrawable drawable = new ShapeDrawable(circle);
        ShapeHolder shapeHolder = new ShapeHolder(drawable);
        shapeHolder.setX(x - useWidth / 16f);
        shapeHolder.setY(y - useWidth / 16f);
        Paint paint = drawable.getPaint();
        paint.setColor(color);
        RadialGradient gradient = new RadialGradient(useWidth / 16f, useWidth / 16f,
                useWidth / 8f, color, Color.GRAY, Shader.TileMode.CLAMP);
        paint.setShader(gradient);
        shapeHolder.setPaint(paint);
        return shapeHolder;
    }

    private void createAnimation() {
        if (bounceAnim == null) {
            XYHolder lstartXY = new XYHolder(3 * minwidth - useWidth / 16f, 3 * minwidth - useWidth / 16f);
            XYHolder processXY = new XYHolder(7 * minwidth - useWidth / 16f, 3 * minwidth - useWidth / 16f);
            XYHolder lendXY = new XYHolder(7 * minwidth - useWidth / 16f, 7 * minwidth - useWidth / 16f);
            bounceAnim = ObjectAnimator.ofObject(ballHolder, "xY",
                    new XYEvaluator(), lstartXY, processXY, lendXY, lstartXY);
            bounceAnim.setDuration(animaltime);
            bounceAnim.setRepeatCount(ObjectAnimator.INFINITE);
            bounceAnim.setRepeatMode(ObjectAnimator.RESTART);
            bounceAnim.addUpdateListener(this);
        }
        if (bounceAnim1 == null) {
            XYHolder lstartXY = new XYHolder(7 * minwidth - useWidth / 16f, 7 * minwidth - useWidth / 16f);
            XYHolder processXY = new XYHolder(3 * minwidth - useWidth / 16f, 7 * minwidth - useWidth / 16f);
            XYHolder lendXY = new XYHolder(3 * minwidth - useWidth / 16f, 3 * minwidth - useWidth / 16f);
            bounceAnim1 = ObjectAnimator.ofObject(ballHolder1, "xY",
                    new XYEvaluator(), lstartXY, processXY, lendXY, lstartXY);
            bounceAnim1.setDuration(animaltime);
            bounceAnim1.setRepeatCount(ObjectAnimator.INFINITE);
            bounceAnim1.setRepeatMode(ObjectAnimator.RESTART);
            bounceAnim1.addUpdateListener(this);
        }
    }

    public void startAnimation() {
        createAnimation();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(bounceAnim).with(bounceAnim1);
        animatorSet.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        invalidate();
    }
}

