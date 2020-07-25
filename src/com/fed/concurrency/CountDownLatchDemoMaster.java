package com.fed.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemoMaster extends Thread {

    private final CountDownLatch countDownLatch;

    public CountDownLatchDemoMaster(CountDownLatch countDownLatch, String name) {
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Master " + Thread.currentThread().getName() + " executed.");
    }
}
