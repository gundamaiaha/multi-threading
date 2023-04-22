package com.example.synchronization.reentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        ReadThread readThread1 = new ReadThread(sharedResource);
        ReadThread readThread2 = new ReadThread(sharedResource);
        WriteThread writeThread = new WriteThread(sharedResource);

        readThread1.start();
        readThread2.start();
        writeThread.start();
    }
}
