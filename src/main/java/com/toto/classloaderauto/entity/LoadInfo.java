package com.toto.classloaderauto.entity;

import com.toto.classloaderauto.inter.BaseManager;

/**
 * @ClassName: LoadInfo
 * @Description: 封装加载类的信息
 * @Author: wenpandong
 * @date: 2017/12/19 23:31
 */
public class LoadInfo {

    /**
     * 自定义类加载器
     */
    private MyClassLoader myClassLoader;

    /**
     * 记录要加载的类的时间戳-->加载的时间
     */
    private long loadTime;

    /**
     * 加载类的实例变量
     */
    private BaseManager baseManager;

    public LoadInfo(MyClassLoader myClassLoader,long loadTime){
        super();
        this.myClassLoader=myClassLoader;
        this.loadTime=loadTime;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public void setMyClassLoader(MyClassLoader myClassLoader) {
        this.myClassLoader = myClassLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getBaseManager() {
        return baseManager;
    }

    public void setBaseManager(BaseManager baseManager) {
        this.baseManager = baseManager;
    }
}
