package com.sbardyuk.algofun.patterns.cyclicsort;


/**
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
 * The array has only one duplicate but it can be repeated multiple times.
 * Find that duplicate number without using any extra space.
 * You are, however, allowed to modify the input array.
 */
public class FindDuplicate {

    private static int findDuplicate(int[] arr) {

        int  i = 0;
        while (i < arr.length) {

            if (arr[i] != i + 1) {
                if (arr[i] == arr[arr[i] - 1]) {
                    return arr[i];
                }
                swap(arr, i, arr[i] - 1);
            } else {
                i ++;
            }

        }

        return -1;
    }

    private static void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int d = findDuplicate(new int [] { 1, 4, 4, 3, 2 });
        System.out.println(d);

        d = findDuplicate(new int [] { 2, 1, 3, 3, 5, 4 });
        System.out.println(d);

        d = findDuplicate(new int [] { 2, 4, 1, 4, 4 });
        System.out.println(d);

    }

}
