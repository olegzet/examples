package com.olegzet;

/**
 * Created by oleg.zorin on 23.02.2017.
 */
public class A {
    public synchronized void slow(long startTime, String message) throws InterruptedException {
        Thread.sleep(2_000);
        doWork(startTime, message);
    }

    public synchronized void fast(long startTime, String message) throws InterruptedException {
        doWork(startTime, message);
    }

    private void doWork(long startTime, String message) {
        System.out.print(String.format("Seconds: %d\n Message: %s\n", getSeconds(startTime, System.currentTimeMillis()), message));
    }

    private long getSeconds(long t1, long t2) {
        return Math.abs(t1 - t2) / 1000;
    }
}
