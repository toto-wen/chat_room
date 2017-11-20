package com.toto.testtools;

/**
 * @ClassName: LiftOff
 * @Description: 线程类
 * @Author: wenpandong
 * @date: 2017/11/15 22:51
 */
public class LiftOff implements Runnable {

    /**
     *
     */
    protected int countDown = 10;

    /**
     *
     */
    private static int taskCount=0;

    /**
     *
     */
    private final int id=taskCount++;

    /**
     * @Title: LiftOff
     * @Description: 类描述
     * @Author: wenpandong
     * @date: 2017/11/15 22:55
     */
    public LiftOff(){}

    /**
     * @Title: LiftOff
     * @Description: 类描述
     * @Author: wenpandong
     * @date: 2017/11/15 22:54
     * @param countDown 传入的线程数量
     */
    public LiftOff(int countDown){
        this.countDown=countDown;
    }

    public String status(){

        return "#"+id+"("+(countDown>0?countDown:"Liftoff!")+"),";
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
        while(countDown-- > 0){
            System.out.print(status());
            Thread.yield();//本地函数
        }
        System.out.println();
    }
}
