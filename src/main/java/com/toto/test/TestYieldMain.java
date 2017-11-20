package com.toto.test;

import com.toto.testtools.testYield;

/**
 * @ClassName: TestYieldMain
 * @Description: 测试testYield类
 * @Author: wenpandong
 * @date: 2017/11/20 23:12
 */
public class TestYieldMain {
    public static void main(String[] args){

        for(int i=0; i<10; i++){
            new Thread(new testYield()).start();
        }

    }
}
