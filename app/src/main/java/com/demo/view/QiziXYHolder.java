package com.demo.view;

public class QiziXYHolder {

    private ShapeHolder mBall;

    public QiziXYHolder(ShapeHolder ball) {
        mBall = ball;
    }

    public void setXY(XYHolder xyHolder) {
        mBall.setX(xyHolder.getX());
        mBall.setY(xyHolder.getY());
    }

    public XYHolder getXY() {
        return new XYHolder(mBall.getX(), mBall.getY());
    }
}

