package com.sbardyuk.algofun;

import java.util.Arrays;

/**
 * Find Second Maximum Value in an Array
 */
public class SecondMaxValueInArray {

    // O(nlogn)
    private static int findSecondMaximum(int[] arr) {
        Arrays.sort(arr);

        for (int i = arr.length - 2; i > 0; i --) {
            if (arr[arr.length - 1] != arr[i]) {
                return arr[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int res = findSecondMaximum(new int[] {9, 2, 3, 2, 6, 6});
        System.out.println(res);

        res = findSecondMaximum(new int[] {4, 5, 1, 2, 0, 4});
        System.out.println(res);

        res = findSecondMaximum(new int[] {1, 1, 2, 2, 3, 3});
        System.out.println(res);

        res = findSecondMaximum(new int[] {3, 3, 3, 3, 3});
        System.out.println(res);
    }
}
