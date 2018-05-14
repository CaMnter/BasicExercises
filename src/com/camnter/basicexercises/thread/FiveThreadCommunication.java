package com.camnter.basicexercises.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 五个线程，先一起打印 hello，后一起打印 world
 *
 * @author CaMnter
 */
public class FiveThreadCommunication {

    private static final int MAX_THREAD = 5;

    private static final class PrintRunnable implements Runnable {

        private final CountDownLatch countDownLatch;

        public PrintRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("Thread-" + Thread.currentThread().getId() + " Hello");
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-" + Thread.currentThread().getId() + " World");
        }

    }


    public static void main(String args[]) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(MAX_THREAD);
        for (int i = 0; i < MAX_THREAD; i++) {
            new Thread(new PrintRunnable(countDownLatch)).start();
        }
    }


}
