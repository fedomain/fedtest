package com.fed.concurrency;

import java.util.concurrent.Executors;

public class UnsafeCounterDemo {

    public static void main(String[] args) throws Exception {

        UnsafeCounter usc = new UnsafeCounter();
        Thread[] tasks = new Thread[100];

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 100; j++)
                    usc.increment();
            });
            tasks[i] = t;
            t.start();
        }

        for (int i = 0; i < 100; i++) {
            tasks[i].join();
        }

        System.out.println(usc.counter);
    }
}

class UnsafeCounter {

    // Instance variable
    int counter = 0;
    //ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    synchronized void increment() {
        counter = counter + 1;
        //counter.set(counter.get() + 1);
    }
}