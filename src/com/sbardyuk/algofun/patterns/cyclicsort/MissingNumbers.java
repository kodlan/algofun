package com.sbardyuk.algofun.patterns.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an unsorted array containing numbers taken from the range 1 to ‘n’.
 * The array can have duplicates, which means that some numbers will be missing. Find all the missing numbers.
 */
public class MissingNumbers {

    public static List<Integer> findMissingNumber(int [] arr) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i ++) {
            swap(arr, i, arr[i] - 1);
        }

        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] != i + 1) {
                res.add(i + 1);
            }
        }

        return res;
    }

    private static void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int [] a = new int [] { 5, 5, 1, 2, 2, 6};

        List<Integer> res = findMissingNumber(a);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
