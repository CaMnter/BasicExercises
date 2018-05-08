package com.camnter.basicexercises.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个数组 0 - 19
 * <p/>
 * 三个线程 Thread0 Thread1 Thread2
 * <p/>
 * 严格要求 Thread0 Thread1 Thread2 的顺序打印数组
 * <p/>
 * 期望
 * <p/>
 * Thread-0  0
 * Thread-1  1
 * Thread-2  2
 * Thread-1  3
 * Thread-2  4
 * Thread-1  5
 * Thread-2  6
 * Thread-1  7
 * Thread-2  8
 * Thread-1  9
 * Thread-2  10
 * Thread-1  11
 * Thread-2  12
 * Thread-1  13
 * Thread-2  14
 * Thread-1  15
 * Thread-2  16
 * Thread-1  17
 * Thread-2  18
 * Thread-1  19
 *
 * @author CaMnter
 */
public class ThreeThreadCommunication {

    public static final ReentrantLock lock = new ReentrantLock();
    public static final Condition c0 = lock.newCondition();
    public static final Condition c1 = lock.newCondition();
    public static final Condition c3 = lock.newCondition();

    public static volatile int index = 0;

    public static class VRunnable implements Runnable {

        private final Condition current;
        private final Condition next;

        private final int value;

        public VRunnable(final int value) {
            this.value = value;
            switch (value) {
                default:
                case 0:
                    this.current = c0;
                    this.next = c1;
                    break;
                case 1:
                    this.current = c1;
                    this.next = c3;
                    break;
                case 2:
                    this.current = c3;
                    this.next = c1;
                    break;
            }
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (; index < 20; ) {
                    System.out.println("Thread-" + value + "  " + index + " ");
                    index++;
                    next.signal();
                    current.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new VRunnable(i)).start();
        }
    }

}
