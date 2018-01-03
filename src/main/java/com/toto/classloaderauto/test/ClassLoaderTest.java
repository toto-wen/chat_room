package com.toto.classloaderauto.test;

import com.toto.classloaderauto.threadtest.MsgHandler;

/**
 * @ClassName: ClassLoaderTest
 * @Description: 测试java类的热加载
 * @Author: wenpandong
 * @date: 2018/1/3 21:54
 */
public class ClassLoaderTest {
    public static void main(String[] args){
        new Thread(new MsgHandler()).start();
    }
}
