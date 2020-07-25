package com.fed.concurrency;

public class CounterDemo {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100;
        Counter counter = new Counter("Fed");
        Thread[] threads = new Thread[threadCount];

        for (int i=0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < threadCount; j++) {
                    counter.increment();
                }
            });

            threads[i].start();
        }

        for (int i=0; i < threadCount; i++) {
            threads[i].join();
        }

        System.out.println("Counter " + counter.getName() + ": " + counter.getCount());
    }
}
