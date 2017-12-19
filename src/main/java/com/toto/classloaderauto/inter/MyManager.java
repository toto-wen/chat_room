package com.toto.classloaderauto.inter;

/**
 * @ClassName: MyManager
 * @Description: 实现了BaseManager接口的类,此类需要实现java类的热加载功能
 * @Author: wenpandong
 * @date: 2017/12/19 23:24
 */
public class MyManager implements BaseManager {
    /**
     * @Title: logic
     * @Description: 实现父类方法
     * @Author: wenpandong
     * @date: 2017/12/19 23:24
     */
    @Override
    public void logic() {
        System.out.println("我在家里学习了如何实现java的热加载案例");
        System.out.println("在网上学习的资源很多，我很喜欢");
    }
}
