package com.olegzet;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by oleg.zorin on 23.02.2017.
 */
public class WorkerInterfaceTest {
    public static void execute(WorkerInterface worker) {
        worker.doSomeWork();
    }

    public static void main(String[] args) {
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
                System.out.println("Worker вызван через анонимный класс");
            }
        });

        execute(() -> System.out.println("Worker вызван через Lambda"));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);
        list.stream().map(x -> x*x).forEach(System.out::println);

        int sum = list.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
        System.out.println(sum);
    }

}
