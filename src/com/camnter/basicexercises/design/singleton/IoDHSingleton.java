package com.camnter.basicexercises.design.singleton;

/**
 * IoDH 单例
 * <p/>
 * 1. 和饿汉的区别，在于 IoDHSingleton 自身被加载的时候没实例化单例
 * 2. 和懒汉的区别，在于 不需要锁。控制一个内部类，在 getInstance 的时候让内部类加载，实例化单例
 * -  由 Java 虚拟机来保证其线程安全性，确保该成员变量只能初始化一次
 * <p/>
 * 通过使用 IoDH，既可以实现延迟加载，又可以保证线程安全，不影响系统性能，不失为一种最好的 Java
 * 语言单例模式实现方式（ 其缺点是与编程语言本身的特性相关，很多面向对象语言不支持 IoDH ）
 *
 * @author CaMnter
 */
public class IoDHSingleton {

    /**
     * IoDHSingleton 自身被加载的时候没实例化单例
     */

    private IoDHSingleton() {

    }

    /**
     * 控制一个内部类，在 getInstance 的时候让内部类加载，实例化单例
     * 由 Java 虚拟机来保证其线程安全性，确保该成员变量只能初始化一次
     */
    public static class HolderClass {
        private static final IoDHSingleton instance = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance() {
        return HolderClass.instance;
    }

}
