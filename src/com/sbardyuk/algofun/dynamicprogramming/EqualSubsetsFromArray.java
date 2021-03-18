package com.sbardyuk.algofun.dynamicprogramming;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EqualSubsetsFromArray {

    private static boolean canPart(int [] arr) {
        int sum = sum(arr);

        if (sum % 2 != 0) {
            return false;
        }

        return canPartRec(arr, sum / 2, 0);
    }


    private static boolean canPartRec(int[] arr, int sumLeft, int index) {
        if (sumLeft == 0) {
            return true;
        }

        if (index >= arr.length) {
            return false;
        }

        if (arr[index] <= sumLeft) {
            if (canPartRec(arr, sumLeft - arr[index], index + 1)) {
                return true;
            }
        }

        return canPartRec(arr, sumLeft, index + 1);
    }

    private static boolean canPartMemo(int [] arr) {
        int sum = sum(arr);

        if (sum % 2 != 0) {
            return false;
        }

        boolean [][] memo = new boolean [sum / 2 + 1][ arr.length];

        return canPartRecMemo(memo, arr, sum / 2, 0);
    }


    private static boolean canPartRecMemo(boolean [][] memo,int[] arr, int sumLeft, int index) {
        if (sumLeft == 0) {
            return true;
        }

        if (index >= arr.length) {
            return false;
        }

        int newSum = sumLeft - arr[index];
        if (memo[newSum][index + 1]) {
            return true;
        }

        if (arr[index] <= sumLeft) {
            if (canPartRec(arr, sumLeft - arr[index], index + 1)) {
                memo[newSum][index + 1] = true;
                return true;
            }
        }

        boolean res = canPartRec(arr, sumLeft, index + 1);
        memo[sumLeft][index + 1] = res;
        return res;
    }

    private static int sum (int [] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {

        System.out.println(canPart(new int [] {1, 2, 3, 4}));
        System.out.println(canPart(new int [] {1, 1, 3, 4, 7}));
        System.out.println(canPart(new int [] {2, 3, 4, 6}));

        System.out.println(canPartMemo(new int [] {1, 2, 3, 4}));
        System.out.println(canPartMemo(new int [] {1, 1, 3, 4, 7}));
        System.out.println(canPartMemo(new int [] {2, 3, 4, 6}));

    }

}
