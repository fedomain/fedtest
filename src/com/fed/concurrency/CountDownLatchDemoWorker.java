package com.fed.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemoWorker extends Thread {

    private final CountDownLatch countDownLatch;

    public CountDownLatchDemoWorker(CountDownLatch countDownLatch, String name) {
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run()
    {
        System.out.println("Worker " + Thread.currentThread().getName() + " started");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Worker  " + Thread.currentThread().getName() + " finished");

        //Each thread calls countDown() method on task completion.
        countDownLatch.countDown();
    }
}

