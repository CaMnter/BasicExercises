package com.camnter.basicexercises.design.singleton;

/**
 * 饿汉式单例
 * <p/>
 * 就是直接实例化 static instance
 * 这样，就能在类加载的时候，创建 instance
 * <p/>
 * 由于在定义静态变量的时候实例化单例类，因此在类加载的时候就已经创建了单例对象
 * 当类被加载时，静态变量 instance 会被初始化，此时类的私有构造函数会被调用，单例类的唯一实例将被创建
 *
 * @author CaMnter
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

}
