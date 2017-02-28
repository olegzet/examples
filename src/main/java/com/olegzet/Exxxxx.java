package com.olegzet;

/**
 * Created by oleg.zorin on 10.02.2017.
 */
public interface Exxxxx {
    void user(String s);
    void print();
    default void print(String s){
        System.out.println(s);
    }

}
