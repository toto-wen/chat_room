package com.toto.classloaderauto.factory;

import com.toto.classloaderauto.entity.LoadInfo;
import com.toto.classloaderauto.entity.MyClassLoader;
import com.toto.classloaderauto.inter.BaseManager;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ManagerFactory
 * @Description: 加载manager的工厂
 * @Author: wenpandong
 * @date: 2017/12/25 22:23
 */
public class ManagerFactory {

    /**
     * 记录热加载类的加载信息
     */
    private static final Map<String,LoadInfo> loadTimeMap=new HashMap<String, LoadInfo>();

    /**
     * 要加载的类的classPath
     */
    public static final String CLASS_PATH="E:/ideaWorkContent/chat_room/out/production/chat_room";

    /**
     * 实现热加载的类的全名称(包名+类名)
     */
    public static final String MY_MANAGER="com.toto.classloaderauto.inter.MyManager";

    public static BaseManager getManager(String className){
        //加载类路径文件
        File loadFile=new File(CLASS_PATH+className.replaceAll("\\.","/")+".class");
        // 获取最后修改时间
        Long lastModified=loadFile.lastModified();
        /**
         * loadTimeMap不包含className为key的loadInfo信息，证明这个类没有被加载，那么需要加载这个类到JVM
         */
        if(loadTimeMap.get(className) == null){
            load(className, lastModified);
        }else if(loadTimeMap.get(className).getLoadTime()!=lastModified) {//加载类的时间戳变化了，我们同样重新加载这个类到JVM
            load(className,lastModified);
        }
        return loadTimeMap.get(className).getBaseManager();
    }

    private static void load(String className, Long lastModified) {
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass=null;
        try {
            loadClass = myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo=new LoadInfo(myClassLoader,lastModified);
        loadInfo.setBaseManager(manager);

        loadTimeMap.put(className,loadInfo);
    }

    private static BaseManager newInstance(Class<?> loadClass) {

        try {
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
