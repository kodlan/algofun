package com.sbardyuk.algofun.arrays;

import java.util.Arrays;

public class RearengeSortedArray {

    // Re-arrange Sorted Array in Max/Min Form

    private static int[] maxMin(int[] arr) {
        int[] tmp = new int [arr.length];

        int i = 0;
        int j = arr.length - 1;
        int c = 0;

        while (i <= j && i < arr.length && j >= 0) {
            if (c % 2 != 0) {
                tmp[c] = arr[i];
                i ++;
            } else {
                tmp[c] = arr[j];
                j --;
            }
            c ++;
        }
        return tmp;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxMin(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(maxMin(new int[] {-1, 2, 4, 7, 9})));
        System.out.println(Arrays.toString(maxMin(new int[] {1, 1, 1, 2, 3})));
    }
}
