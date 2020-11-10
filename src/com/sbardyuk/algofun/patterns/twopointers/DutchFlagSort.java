package com.sbardyuk.algofun.patterns.twopointers;

import java.util.Arrays;

public class DutchFlagSort {

    public static void dutchSort(int [] array) {

        int i = 0;
        int pointerLeft = 0;
        int pointerRight = array.length - 1;

        while (i <= pointerRight) {
            if (array[i] == 0) {
                swap(array, i, pointerLeft);
                pointerLeft ++;
                i ++;
            } else if (array[i] == 2) {
                swap(array, i, pointerRight);
                pointerRight --;
            } else if (array[i] == 1) {
                i ++;
            }
        }

    }

    private static void swap(int [] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int [] arr1 = new int[] {1, 0, 2, 1, 0};
        dutchSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int [] arr2 = new int[] {2, 2, 0, 1, 2, 0};
        dutchSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
