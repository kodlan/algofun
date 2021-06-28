package com.sbardyuk.algofun.againagain;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 * Example 1:
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 *
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {

        int p1 = 0;
        int p2 = arr.length - 1;

        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];

            if (sum == targetSum) {
                return new int [] {p1, p2};
            } else if (sum < targetSum) {
                p1 ++;
            } else {
                p2 --;
            }
        }

        return new int[] { -1, -1 };
    }

    public static int [] searchMap(int [] arr, int targetSum) {
        Map<Integer, Integer> complMap = new HashMap<>();

        for (int i = 0; i < arr.length; i ++) {
            int compl = targetSum - arr[i];

            if (complMap.containsKey(compl)) {
                return new int [] {i, complMap.get(compl)};
            } else {
                complMap.put(arr[i], i);
            }
        }

        return new int [] {-1, 1};
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = PairWithTargetSum.searchMap(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = PairWithTargetSum.searchMap(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
