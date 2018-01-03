package com.toto.test;

import com.toto.testtools.LiftOff;

/**
 * @ClassName: TestMain
 * @Description: 测试主类
 * @Author: wenpandong
 * @date: 2017/11/15 22:49
 */
public class TestMain {

    /**
     * @Title: main
     * @Description: 测试用的主方法（main）
     * @Author: wenpandong
     * @date: 2017/11/15 22:50
     * @param args 程序参数
     */
    public static void main(String[] args){
       for(int i=0; i < 5; i ++){
           new Thread(new LiftOff()).start();
       }

    }
}
