package com.camnter.basicexercises.thread;

/**
 * 生产者和消费者
 *
 * @author CaMnter
 */

public class ProducerAndCustomer {

    private static int count = 0;
    private static final int FULL = 10;
    private static final Object LOCK = new Object();

    static class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("[Thread name] = " + Thread.currentThread().getName() + "  [Class name] = " + this.getClass().getSimpleName() + "  [count] = " + count);
                    LOCK.notifyAll();
                }
            }
        }

    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println("[Thread name] = " + Thread.currentThread().getName() + "  [Class name] = " + this.getClass().getSimpleName() + "  [count] = " + count);
                    LOCK.notifyAll();
                }
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
    }

}
