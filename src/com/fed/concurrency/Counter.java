package com.fed.concurrency;

public class Counter {

    //private ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);
    private int count = 0;
    private final String name;

    public Counter(String name) {
        this.name = name;
    }

    public void increment() {
        //this.count.set(count.get() + 1);
        synchronized (this) {
            this.count++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        //return this.count.get();
        return this.count;
    }
}
