package com.example.synchronization.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

    private static int counter;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public int readValue() {
        System.out.println("READER STARTS");
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " is reading  the counter: " + counter);
            System.out.println("READER ENDS");
            return counter;
        } finally {
            lock.readLock().unlock();
        }

    }

    public void writeValue(int newValue) {
        try {
            System.out.println("WRITER STARTS");
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " is increasing the counter value");
            counter++;
            System.out.println("Current Value of counter  after writing -->" + counter);
            System.out.println("WRITER STARTS");

        } finally {
            lock.writeLock().unlock();
        }
    }
}
