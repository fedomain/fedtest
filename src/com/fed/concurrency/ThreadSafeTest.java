package com.fed.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeTest {

    private int count = 5;

    private int add(int val) {

        count += val;

        return count;
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadSafeTest threadSafeTest = new ThreadSafeTest();

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + threadSafeTest.add(23));
        });

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + threadSafeTest.add(12));
        });

        System.out.println("Program start");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Program end");

    }

}
