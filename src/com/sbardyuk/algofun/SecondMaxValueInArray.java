package com.sbardyuk.algofun;

import java.util.Arrays;

/**
 * Find Second Maximum Value in an Array
 * Assumption: Array should contain at least two unique elements.
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

        throw new IllegalStateException("This should not happen");
    }

    private static int findSecondMaximumOnePass(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val > max) {
                secondMax = max;
                max = val;
            } else if (val > secondMax && val != max) {
                secondMax = val;

            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        int res = findSecondMaximum(new int[] {9, 2, 3, 2, 6, 6});
        System.out.println(res);

        res = findSecondMaximum(new int[] {4, 5, 1, 2, 0, 4});
        System.out.println(res);

        res = findSecondMaximum(new int[] {1, 1, 2, 2, 3, 3});
        System.out.println(res);

        res = findSecondMaximumOnePass(new int[] {9, 2, 3, 2, 6, 6});
        System.out.println(res);

        res = findSecondMaximumOnePass(new int[] {4, 5, 1, 2, 0, 4});
        System.out.println(res);

        res = findSecondMaximumOnePass(new int[] {1, 1, 2, 2, 3, 3});
        System.out.println(res);
    }
}
