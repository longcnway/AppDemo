package com.demo.view;

import android.animation.TypeEvaluator;

/**
 * 自定义该接口实例来控制动画的更新计算表达式
 */
public class XYEvaluator implements TypeEvaluator {
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        XYHolder startXY = (XYHolder) startValue;
        XYHolder endXY = (XYHolder) endValue;
        return new XYHolder(startXY.getX() + fraction * (endXY.getX() - startXY.getX()),
                startXY.getY() + fraction * (endXY.getY() - startXY.getY()));
    }
}
