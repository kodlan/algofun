package com.sbardyuk.algofun.patterns.twopointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the
 * sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never
 * reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
 */
public class HappyNumber {

    public static boolean isHappyNumber(int n) {
        List<Integer> results = new LinkedList<>();

        int square = n;
        while (true) {
            System.out.print("digits = " + square);
            List<Integer> digits = getDigits(square);
            square = getSquare(digits);
            System.out.print(" square = " + square);
            System.out.println();

            if (square == 1) {
                return true;
            } else if (detectCycle(results, square)) {
                return false;
            }

            results.add(square);
        }
    }

    private static boolean detectCycle(List<Integer> results, int square) {
        for (int x : results) {
            if (x == square) {
                return true;
            }
        }

        return false;
    }

    private static int getSquare(List<Integer> digits) {
        int res = 0;
        for (int i : digits) {
            res = i*i + res;
        }
        return res;
    }

    private static List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<>();

        String str = Integer.toString(n);
        for (char ch : str.toCharArray()) {
            digits.add(ch - '0');
        }

        return digits;
    }

    public static boolean findUsingSlowAndFastPointers(int n) {

        int slow = n;
        int fast = n;

        do {
            // todo this can be optimized, but not today :)
            slow = getSquare(getDigits(slow));
            fast = getSquare(getDigits(getSquare(getDigits(fast))));
        } while (slow != fast);

        return slow == 1;

    }


    public static void main(String[] args) {
        System.out.println(isHappyNumber(23));
        System.out.println();
        System.out.println(isHappyNumber(12));

        System.out.println();
        System.out.println();

        System.out.println(findUsingSlowAndFastPointers(23));
        System.out.println();
        System.out.println(findUsingSlowAndFastPointers(12));
    }
}
