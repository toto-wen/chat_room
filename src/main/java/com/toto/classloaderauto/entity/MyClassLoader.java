package com.toto.classloaderauto.entity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName: MyClassLoader
 * @Description: 自定义的java热加载类，它通过继承了java的ClassLoader类
 * @Author: wenpandong
 * @date: 2017/12/19 22:57
 */
public class MyClassLoader extends ClassLoader {

    /**
     * java要加载的类的class路径
     */
    private String classPath;

    /**
     * @Title: MyClassLoader
     * @Description: 重写无参构造方法
     * @Author: wenpandong
     * @date: 2017/12/19 23:04
     */
    public MyClassLoader(){}

    /**
     * @Title: MyClassLoader
     * @Description: 重写有参构造方法
     * @Author: wenpandong
     * @date: 2017/12/19 23:04
     */
    public MyClassLoader(String classPath){
        super(ClassLoader.getSystemClassLoader());
        this.classPath=classPath;
    }

    /**
     * Finds the class with the specified <a href="#name">binary name</a>.
     * This method should be overridden by class loader implementations that
     * follow the delegation model for loading classes, and will be invoked by
     * the {@link #loadClass <tt>loadClass</tt>} method after checking the
     * parent class loader for the requested class.  The default implementation
     * throws a <tt>ClassNotFoundException</tt>.
     *
     * @param name The <a href="#name">binary name</a> of the class
     * @return The resulting <tt>Class</tt> object
     * @throws ClassNotFoundException If the class could not be found
     * @since 1.2
     */
    /**
     * @Title: findClass
     * @Description: 重写findClass方法，这是主要方法,不使用父类的super.findClass(String name);
     *  我们自己重新构造,
     * @Author: wenpandong
     * @date: 2017/12/19 23:01
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data=this.loadClassData(name);
        /**
         * defineClass(String,byte[],on,off)
         * 第一个参数为传入的name值，也就是类名称，第二个参数为一个byte数据，第三数组起始位置，第四个，数组结束位置
         */
        return this.defineClass(name,data,0,data.length);
    }

    /**
     * @Title: loadClassData
     * @Description: 加载文件中的内容
     * @Author: wenpandong
     * @date: 2017/12/19 23:11
     */
    private byte[] loadClassData(String name){
        //定义文件输入流并赋值为null
        FileInputStream is=null;
        //定义byte数组文件输出流并赋值为null
        ByteArrayOutputStream bot=null;
        try{
            //将所传入的class路径分隔符转换为/
            name = name.replace(".", "/");
            //初始化文件输入流
            is=new FileInputStream(new File(classPath+name+".class"));
            //初始化文件输出流
            bot=new ByteArrayOutputStream();
            //定义接收参数
            int b = 0;
            //读取数据
            while((b=is.read())!=-1){
                //写入数据
                bot.write(b);
            }
            //返回结果
            return bot.toByteArray();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(bot!=null){
                    bot.close();
                }
                if(is!=null){
                    is.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        //如果发生错误返回null
        return null;
    }
}
