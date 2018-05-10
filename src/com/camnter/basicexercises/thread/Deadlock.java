package com.camnter.basicexercises.thread;

/**
 * 死锁
 *
 * @author CaMnter
 */
public class Deadlock {

    private static final byte[] lock1 = new byte[0];
    private static final byte[] lock2 = new byte[0];

    public void func1() throws InterruptedException {
        synchronized (lock1) {
            Thread.sleep(2222);
            System.out.println("func1 尝试 lock2 锁");
            synchronized (lock2) {
                System.out.println("func1 获得 lock2 锁");
            }
        }

    }

    public void func2() throws InterruptedException {
        synchronized (lock2) {
            Thread.sleep(3333);
            System.out.println("func2 尝试 lock1 锁");
            synchronized (lock1) {
                System.out.println("func2 获得 lock1 锁");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        final Deadlock d = new Deadlock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    d.func1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    d.func2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
