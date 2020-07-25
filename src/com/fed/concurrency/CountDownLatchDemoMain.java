package com.fed.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemoMain {

    public static void main(String[] args) {

        //Created CountDownLatch for 2 threads
        CountDownLatch countDownLatch = new CountDownLatch(2);

        //Created and started two threads
        CountDownLatchDemoWorker A = new CountDownLatchDemoWorker(countDownLatch, "A");
        CountDownLatchDemoWorker B = new CountDownLatchDemoWorker(countDownLatch, "B");
        CountDownLatchDemoMaster M = new CountDownLatchDemoMaster(countDownLatch, "M");

        A.start();
        B.start();
        M.start();

        //When two threads(A and B)complete their tasks, they are returned (counter reached 0).
        //countDownLatch.await();
    }
}