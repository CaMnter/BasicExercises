package com.camnter.basicexercises.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程运行，一个 打印 1 一个 打印 0
 * <p/>
 * 要求 1010101010 输出
 * <p/>
 * @author CaMnter
 */
public class TwoThreadCommunication {

    private static final class PrintRunnable<T> implements Runnable {

        private T t;
        private static final int MAX_COUNT = 10;
        private static final Object LOCK = new Object();

        public PrintRunnable(T t) {
            this.t = t;
        }

        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = 0; i < MAX_COUNT; i++) {
                    System.out.print(t.toString() + " ");
                    try {
                        LOCK.notifyAll();
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private static final class PrintRunnableByLock<T> implements Runnable {

        private T t;
        private static final int MAX_COUNT = 10;

        private static final ReentrantLock LOCK = new ReentrantLock();
        private static final Condition FIRST_CONDITION = LOCK.newCondition();
        private static final Condition SECOND_CONDITION = LOCK.newCondition();

        private final boolean first;

        public PrintRunnableByLock(T t, boolean first) {
            this.t = t;
            this.first = first;
        }

        @Override
        public void run() {
            LOCK.lock();
            try {
                for (int i = 0; i < MAX_COUNT; i++) {
                    System.out.print(t.toString() + " ");
                    if (this.first) {
                        this.notifySecond();
                    } else {
                        this.notifyFirst();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }

        private void notifySecond() throws InterruptedException {
            SECOND_CONDITION.signal();
            FIRST_CONDITION.await();
        }

        private void notifyFirst() throws InterruptedException {
            FIRST_CONDITION.signal();
            SECOND_CONDITION.await();
        }

    }

    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(new PrintRunnable<Integer>(1));
        Thread t2 = new Thread(new PrintRunnable<Integer>(2));
        t1.start();
        t2.start();

        System.out.println(" ");

        Thread.sleep(200);

        Thread t3 = new Thread(new PrintRunnableByLock<Integer>(3, true));
        Thread t4 = new Thread(new PrintRunnableByLock<Integer>(4, false));
        t3.start();
        t4.start();
    }


}
