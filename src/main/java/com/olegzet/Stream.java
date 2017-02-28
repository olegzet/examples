package com.olegzet;

import java.util.concurrent.RecursiveAction;

/**
 * Created by oleg.zorin on 14.02.2017.
 */
public class Stream extends RecursiveAction {
    final int countProcessors = Runtime.getRuntime().availableProcessors();
    final int countLimit = 5000;
    int start;
    int end;
    int forSplit;

    Stream(int componentValue, int startNumber, int endNumber) {
        forSplit = componentValue;
        start = startNumber;
        end = endNumber;
    }

    protected void compute() {
        if (countProcessors == 1 || end - start <= countLimit) {
            System.out.println("=run=");
            for (int i = start; i <= end; i++) {
                new Calc().go(i);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new Stream(forSplit, 0, middle),
                    new Stream(forSplit, middle + 1, end));
        }
    }
}
