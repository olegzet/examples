package com.olegzet;

/**
 * Created by oleg.zorin on 23.02.2017.
 */
public class B {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        long launchTime = System.currentTimeMillis();
        Thread t = new Thread(
                () -> {
                    try {
                        a.slow(launchTime, "a");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        t.start();
        Thread.sleep(1_000);
        a.fast(launchTime, "b");
        t.join();
        System.out.println(new String("qwsxz") == new String("qwsxz"));
        System.out.println(new String("qwsxz").intern() == new String("qwsxz").intern());
    }
}
