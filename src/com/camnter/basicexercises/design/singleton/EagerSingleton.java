package com.camnter.basicexercises.design.singleton;

/**
 * 饿汉式单例
 * <p/>
 * 就是直接实例化 static instance
 * 这样，就能在类加载的时候，创建 instance
 * <p/>
 * 由于在定义静态变量的时候实例化单例类，因此在类加载的时候就已经创建了单例对象
 * 当类被加载时，静态变量 instance 会被初始化，此时类的私有构造函数会被调用，单例类的唯一实例将被创建
 * <p/>
 * 饿汉式单例类在类被加载时就将自己实例化，它的优点在于无须考虑多线程访问问题，可以确保实例的唯一性；从
 * 调用速度和反应时间角度来讲，由于单例对象一开始就得以创建，因此要优于懒汉式单例。但是无论系统在运行时
 * 是否需要使用该单例对象，由于在类加载时该对象就需要创建，因此从资源利用效率角度来讲，饿汉式单例不及懒
 * 汉式单例，而且在系统加载时由于需要创建饿汉式单例对象，加载时间可能会比较长
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
