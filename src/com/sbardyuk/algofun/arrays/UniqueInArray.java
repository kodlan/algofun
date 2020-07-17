package com.sbardyuk.algofun.arrays;

import java.util.HashMap;
import java.util.Map;

public class UniqueInArray {

    private static int findFirstUnique(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int x : arr) {
            if (countMap.containsKey(x)) {
                int newCount = countMap.get(x) + 1;
                countMap.put(x, newCount);
            } else {
                countMap.put(x, 1);
            }
        }

        for (int x : arr) {
            if (countMap.get(x) == 1) {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int res = findFirstUnique(new int[] {9, 2, 3, 2, 6, 6});
        System.out.println(res);

        res = findFirstUnique(new int[] {4, 5, 1, 2, 0, 4});
        System.out.println(res);

        res = findFirstUnique(new int[] {1, 1, 2, 2, 3, 3});
        System.out.println(res);
    }
}
