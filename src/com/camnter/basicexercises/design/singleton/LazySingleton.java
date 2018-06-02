package com.camnter.basicexercises.design.singleton;

/**
 * 懒汉式单例
 * <p/>
 * 懒汉式单例在第一次调用 getInstance() 方法时实例化，在类加载时并不自行实例化
 * 这种技术又称为延迟加载 (Lazy Load) 技术，即需要的时候再加载实例，为了避免多
 * 个线程同时调用 getInstance() 方法
 *
 * @author CaMnter
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
