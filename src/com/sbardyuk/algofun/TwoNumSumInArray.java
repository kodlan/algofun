package com.sbardyuk.algofun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumSumInArray {

    private static int[] findSum(int[] arr, int n) {
        Arrays.sort(arr);

        int i1 = 0;
        int i2 = arr.length - 1;

        while (i1 != i2) {
            int sum = arr[i1] + arr[i2];

            if (sum == n) {
                return new int[] {arr[i1], arr[i2]};
            } else if (sum > n) {
                i2 --;
            } else {
                i1++;
            }
        }

        return arr;
    }

    private static int[] findSumWithMap(int[] arr, int n) {
        Map<Integer, Integer> complementaryMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            complementaryMap.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int complement = n - arr[i];

            if (complementaryMap.containsKey(complement) && complementaryMap.get(complement) != i) {
                return new int[] {arr[i], arr[complementaryMap.get(complement)]};
            }
        }

        return arr;
    }

    private static int[] findSumWithMapOnePass(int[] arr, int n) {
        Map<Integer, Integer> complementaryMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = n - arr[i];

            if (complementaryMap.containsKey(complement) && complementaryMap.get(complement) != i) {
                return new int[] {arr[i], arr[complementaryMap.get(complement)]};
            }

            complementaryMap.put(arr[i], i);
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] res = findSum(new int[] {2, 4, 5, 7, 8}, 9);
        System.out.println(Arrays.toString(res));

        res = findSum(new int[] {2, 4, 5, 7, 8}, 19);
        System.out.println(Arrays.toString(res));

        res = findSum(new int[] {2, 4, 5, 7, 8}, 6);
        System.out.println(Arrays.toString(res));

        // with map
        res = findSumWithMap(new int[] {2, 4, 5, 7, 8}, 9);
        System.out.println(Arrays.toString(res));

        res = findSumWithMap(new int[] {2, 4, 5, 7, 8}, 19);
        System.out.println(Arrays.toString(res));

        res = findSumWithMap(new int[] {2, 4, 5, 7, 8}, 6);
        System.out.println(Arrays.toString(res));

        // with map one pass only
        res = findSumWithMapOnePass(new int[] {2, 4, 5, 7, 8}, 9);
        System.out.println(Arrays.toString(res));

        res = findSumWithMapOnePass(new int[] {2, 4, 5, 7, 8}, 19);
        System.out.println(Arrays.toString(res));

        res = findSumWithMapOnePass(new int[] {2, 4, 5, 7, 8}, 6);
        System.out.println(Arrays.toString(res));
    }

}
