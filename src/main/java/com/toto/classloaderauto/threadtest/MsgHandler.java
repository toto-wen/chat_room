package com.toto.classloaderauto.threadtest;

import com.toto.classloaderauto.factory.ManagerFactory;
import com.toto.classloaderauto.inter.BaseManager;

/**
 * @ClassName: MsgHardler
 * @Description: 后台线程检测类,后台启动一条线程，不断刷新重新加载实现了热加载的类
 * @Author: wenpandong
 * @date: 2018/1/3 21:49
 */
public class MsgHandler implements Runnable {
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
        while (true){
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
