package com.example.synchronization.reentrantReadWriteLock;

public class WriteThread extends Thread {
    private SharedResource sharedResource;

    public WriteThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Writer");
        while (true) {
            int newValue = (int) (Math.random() * 1000);
            sharedResource.writeValue(newValue);
            //Do something after writing the value
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
