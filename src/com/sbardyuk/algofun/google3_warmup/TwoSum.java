package com.sbardyuk.algofun.google3_warmup;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int [] searchSorted(int [] array, int targetSum) {
        if (targetSum > array[0] + array[array.length - 1]) {
            return new int [] {};
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end) {

            int currentSum = array[start] + array[end];

            if (currentSum == targetSum) {
                return new int [] { start , end };
            } else if (currentSum > targetSum) {
                end --;
            } else {
                start ++;
            }
        }

        return new int [] {};
    }

    private static int [] searchMap(int [] array, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            int complementary = targetSum - array[i];
            if (map.containsKey(complementary)) {
                return new int[] {i, map.get(complementary)};
            } else {
                map.put(array[i], i);
            }
        }

        return new int [] {};
    }

    public static void main(String[] args) {
        int[] result = searchSorted(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = searchSorted(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = searchMap(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = searchMap(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
