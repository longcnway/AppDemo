package com.demo.service;

/**
 * 线程基本用法
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        //处理具体的逻辑
    }
    //使用此线程

    class MyThreadTwo implements Runnable{

        @Override
        public void run() {
            //处理具体的逻辑
        }
    }

    /**
     * 线程启动的三种方式
     */
    public void useThread(){
        //开启线程方法一：继承Thread，重写run()方法
        new MyThread().start();
        //开启线程方法二：实现Runnable
        MyThreadTwo myThreadTwo = new MyThreadTwo();
        new Thread(myThreadTwo).start();
        //开启线程方法三：匿名类启动线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //处理具体的逻辑
            }
        }).start();
    }
}
