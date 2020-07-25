package com.fed.concurrency;

public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        final BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    queue.enqueue(i);
                    System.out.println("enqueued " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 2 dequeued: " + queue.dequeue());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 3 dequeued: " + queue.dequeue());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();

        Thread.sleep(4000);

        t2.start();
        t2.join();

        t3.start();

        t1.join();
        t3.join();
    }

}
