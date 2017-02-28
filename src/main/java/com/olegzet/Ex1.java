package com.olegzet;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by oleg.zorin on 10.02.2017.
 */
public class Ex1 implements Exxxxx {
    static final int THREAD_COUNT = 3;

    static final CyclicBarrier barrier =
            new CyclicBarrier(THREAD_COUNT);
    static final Object mutex = new Object();
    static final AtomicInteger counter = new AtomicInteger(0);

    static volatile boolean exitCondition = false;

    public static void repeatText(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();

    }

    public static void show() {

        System.out.println("Static method called");
    }

    public static Runnable run(String name) {
        return () -> {
            try {
                barrier.await();

                synchronized (mutex) {
                    System.out.println(name + ": monitor acquired");

                    if (counter.getAndIncrement() < THREAD_COUNT - 2) {
                        System.out.println(name + ": invoking wait");

                        while (!exitCondition)
                            mutex.wait();
                        exitCondition = false;

                        System.out.println(name + ": woken up");
                    }

                    exitCondition = true;
                    System.out.println(name + ": invoking notify");
                    mutex.notify();
                }
                System.out.println(name + ": monitor released");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(run("Thread-" + i)).start();
        }*/
        final int componentValue = 10000;
        Long beginT = System.nanoTime();
        ForkJoinPool fjp = new ForkJoinPool();
        Stream test = new Stream(componentValue, 0, componentValue);
        fjp.invoke(test);
        Long endT = System.nanoTime();
        Long timebetweenStartEnd = endT - beginT;
        System.out.println("=====time========" + timebetweenStartEnd);
    }

    @Override
    public void user(String s) {

    }

    @Override
    public void print() {

    }
}
