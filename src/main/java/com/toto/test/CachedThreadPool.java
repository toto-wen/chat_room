package com.toto.test;

import com.toto.testtools.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CachedThreadPool
 * @Description: 使用CachedThreadPool线程池来管理线程
 * @Author: wenpandong
 * @date: 2017/11/23 21:50
 */
public class CachedThreadPool {

    /**
     * @Title: main
     * @Description: 程序执行的main方法
     * @Author: wenpandong
     * @date: 2017/11/23 22:13
     */
    public static void main(String[] args){
        //获取Executor服务
        ExecutorService exec= Executors.newCachedThreadPool();
        //循环执行线程
        for(int i =0; i<5; i++){
            //通过Executor服务的execute方法来执行线程
            exec.execute(new LiftOff());
        }
        //关闭线程池服务
        exec.shutdown();

    }
}
