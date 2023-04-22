package com.example.synchronization.reentrantReadWriteLock;

public class ReadThread extends Thread {
    private SharedResource sharedResource;

    public ReadThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Reader");
        while (true) {
            int value = sharedResource.readValue();
            // Do something with value
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
