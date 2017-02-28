package com.olegzet;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Oleg on 24/02/2017.
 */
public class Exercises {
    private static final char L_F = '{';
    private static final char L_K = '[';
    private static final char L_R = '(';
    private static final List<Character> L_CHARS = Arrays.asList(L_F, L_K, L_R);
    private static final char R_F = '}';
    private static final char R_K = ']';
    private static final char R_R = ')';

    // http://codingbat.com/prob/p179479
    public static int maxBlock(final String str) {
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

    // http://codingbat.com/prob/p196409
    public static int maxMirror(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                int count = 0;
                int pI = i;
                int pJ = j;
                while (pI < nums.length && pJ >= 0 && nums[pI] == nums[pJ]) {
                    count++;
                    pI++;
                    pJ--;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public static boolean bracketsValidation(final String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (isLeftChar(currentChar)) {
                stack.push(currentChar);
            } else {
                if (isPairChar(stack.peek(), currentChar)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isLeftChar(final char leftCh) {
        return L_CHARS.stream().anyMatch(ch -> ch.equals(leftCh));
    }

    private static boolean isPairChar(final char leftCh, final char rightCh) {
        /*switch (leftCh) {
            case L_F:
                if (rightCh == R_F) {
                    return true;
                }
            case L_K:
                if (rightCh == R_K) {
                    return true;
                }
            case L_R:
                if (rightCh == R_R) {
                    return true;
                }
            default:
                return false;
        }*/
        return ((leftCh == L_F && rightCh == R_F) || (leftCh == L_K && rightCh == R_K) || (leftCh == L_R && rightCh == R_R));
    }

    public static void main(final String[] args) {
/*        Scanner input = new Scanner(System.in);
        System.out.println("Input validating string: ");
        String validatingString = input.next();
        System.out.print("Result of validation: ");
        System.out.println(bracketsValidation(validatingString));*/

    }
}
