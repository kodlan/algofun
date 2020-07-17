package com.sbardyuk.algofun.arrays;

import java.util.Arrays;

public class RearrangePositiveNegative {

    // Re-arrange Positive & Negative Values
    // Given an array, can you re-arrange its elements in such a way that the negative elements appear at one side and positive elements appear at the other?

    private static void reArrange(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j && i < arr.length && j > 0) {
            if (arr[i] < 0) {
                i ++;
            } else if (arr[j] >= 0) {
                j --;
            }

            if (arr[i] >= 0 && arr[j] < 0){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i ++;
                j --;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-9, 2, -3, 2, -6, 6};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {-4, -5, -1, -2, 0, -4};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {1, 1, 2, 2, 3, 3};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {-1, -1, 2, 2, 3, 3};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {1, 1, 1, 1, 1, 1};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {-1, -1, -1, -1, -1, -1};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {1, 1, 2, -2, -3, -3};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));
    }
}
