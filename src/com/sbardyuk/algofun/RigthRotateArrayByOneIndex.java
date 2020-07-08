package com.sbardyuk.algofun;

import java.util.Arrays;

public class RigthRotateArrayByOneIndex {
    // In this problem, you have to implement the void rotateArray(int[] arr) method, which takes an arr
    // and rotate it right by 1. This means that the right-most elements will appear at the left-most position in the array.

    private static void rotateArray(int[] arr) {
        int tmp = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i --) {
            arr[i] = arr[i - 1];
        }

        arr[0] = tmp;

    }


    public static void main(String[] args) {
        int[] arr = new int[] {9, 2, 3, 2, 6, 6};
        rotateArray(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {4, 5, 1, 2, 0, 4};
        rotateArray(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {1, 1, 2, 2, 3, 3};
        rotateArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
