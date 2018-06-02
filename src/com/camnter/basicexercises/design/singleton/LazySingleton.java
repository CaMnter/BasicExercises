package com.camnter.basicexercises.design.singleton;

/**
 * 懒汉式单例
 * 双重检查锁定
 * <p/>
 * 懒汉式单例在第一次调用 getInstance() 方法时实例化，在类加载时并不自行实例化
 * 这种技术又称为延迟加载 (Lazy Load) 技术，即需要的时候再加载实例，为了避免多
 * 个线程同时调用 getInstance() 方法
 * <p/>
 * 懒汉式单例类在第一次使用时创建，无须一直占用系统资源，实现了延迟加载，但是必须处
 * 理好多个线程同时访问的问题，特别是当单例类作为资源控制器，在实例化时必然涉及资源
 * 初始化，而资源初始化很有可能耗费大量时间，这意味着出现多线程同时首次引用此类的机
 * 率变得较大，需要通过双重检查锁定等机制进行控制，这将导致系统性能受到一定影响
 *
 * @author CaMnter
 */
public class LazySingleton {

    private static volatile LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        // 减少不必要的同步，volatile 能拿到最新的（第一检查）
        if (instance == null) {
            // 锁 class
            synchronized (LazySingleton.class) {
                // 单个线程 初始化（第二检查）
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
