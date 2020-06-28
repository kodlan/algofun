package com.sbardyuk.algofun;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] res = findSum(new int[] {2, 4, 5, 7, 8}, 9);
        System.out.println(Arrays.toString(res));

        res = findSum(new int[] {2, 4, 5, 7, 8}, 19);
        System.out.println(Arrays.toString(res));

        res = findSum(new int[] {2, 4, 5, 7, 8}, 6);
        System.out.println(Arrays.toString(res));
    }

}
