package com.olegzet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Oleg on 24/02/2017.
 */
public class Exercises {
    private static final char L_F = "{".charAt(0);
    private static final char L_K = "[".charAt(0);
    private static final char L_R = "(".charAt(0);
    private static final List<Character> L_CHARS = Arrays.asList(L_F, L_K,L_R);
    private static final char R_F = "}".charAt(0);
    private static final char R_K = "]".charAt(0);
    private static final char R_R = ")".charAt(0);

    public int maxBlock(String str) {
        int maxBlock = 0;
        if (str.isEmpty()) {
            return maxBlock;
        }
        char currentChar = str.charAt(0);
        int currentBlock = 1;
        for (int i = 1; i < str.length(); i++) {
            char testChar = str.charAt(i);
            if (currentChar == testChar) {
                currentBlock++;
            }
            if (currentBlock > maxBlock) {
                maxBlock = currentBlock;
            }
            if (currentChar != testChar) {

                currentChar = testChar;
                currentBlock = 1;
            }
        }
        return maxBlock;
    }

    public boolean valid(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (open(str[i])) {
                s.push(str[i]);
            } else {
                if (reverse(str[i], s.peel())) s.pop()
                else {
                    break;
                }
            }
        }
    }

    private boolean leftChar(char leftCh){
        return L_CHARS.stream().anyMatch((Character ch) -> ch.equals(leftCh));


    }

    public static void main(String[] args) {

    }
}
