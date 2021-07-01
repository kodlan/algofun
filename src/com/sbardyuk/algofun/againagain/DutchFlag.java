package com.sbardyuk.algofun.againagain;


/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 *
 * The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
 *
 * Example 1:
 *
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * Example 2:
 *
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0 0 1 2 2 2 ]
 */
public class DutchFlag {

    public static void sort(int [] arr) {
        int zeroPointer = 0;
        int twoPointer = arr.length - 1;
        int index = 0;

        while (index <= twoPointer) {

            int current = arr[index];

            if (current == 2) {
                swap(arr, index, twoPointer);
                twoPointer --;
            } else if (current == 0) {
                swap(arr, index, zeroPointer);
                zeroPointer ++;
                index ++;
            } else if (current == 1) {
                index ++;
            }
        }
    }

    private static void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}
