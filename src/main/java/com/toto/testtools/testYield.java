package com.toto.testtools;

/**
 * @ClassName: testYield
 * @Description: 测试线程静态方法yield(),该线程的实现是基于实现Runnable接口
 * @Author: wenpandong
 * @date: 2017/11/20 23:05
 */
public class testYield implements Runnable {

    //重写构造方法
    public testYield(){
        System.out.println("this is testYield");
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        //输出一条信息
        System.out.println("yield method 1");
        //调用yield方法，该方法的作用是通知系统该线程已经完成了重要的程序，现在是把资源交给其他程序的好时机
//        Thread.yield();
        //输出一条信息
        System.out.println("yield method 2");
        //调用yield方法，该方法的作用是通知系统该线程已经完成了重要的程序，现在是把资源交给其他程序的好时机
//        Thread.yield();
        //输出一条信息
        System.out.println("yield method 3");
        //调用yield方法，该方法的作用是通知系统该线程已经完成了重要的程序，现在是把资源交给其他程序的好时机
//        Thread.yield();
        return;
    }
}
