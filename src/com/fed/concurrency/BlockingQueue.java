package com.fed.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

    private final T[] array;
    private int size = 0;
    private final int capacity;
    private int head = 0;
    private int tail = 0;
    private final ReentrantLock lock = new ReentrantLock();

    @SuppressWarnings("unchecked")
    public BlockingQueue(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(T item) throws InterruptedException {
        lock.lock();

        try {
            // wait for queue to have space
            while (size == capacity) {
                wait();
            }

            // reset tail to the beginning if the tail is already
            // at the end of the backing array
            if (tail == capacity) {
                tail = 0;
            }

            // place the item in the array
            array[tail] = item;
            size++;
            tail++;

            // don't forget to notify any other threads waiting on
            // a change in value of size. There might be consumers
            // waiting for the queue to have at least one element
            notifyAll();
        } finally {
            lock.unlock();
        }
    }

    public T dequeue() throws InterruptedException {
        lock.lock();
        T item = null;

        try {
            // wait for atleast one item to be enqueued
            while (size == 0) {
                wait();
            }

            // reset head to start of array if its past the array
            if (head == capacity) {
                head = 0;
            }

            // store the reference to the object being dequeued
            // and overwrite with null
            item = array[head];
            array[head] = null;
            head++;
            size--;

            // don't forget to call notify, there might be another thread
            // blocked in the enqueue method.
            notifyAll();
        } finally {
            lock.unlock();
        }

        return item;
    }

    public void printLockInfo() {
        System.out.println(lock.getHoldCount() + " " + lock.isLocked());
    }
}
