package com.sbardyuk.algofun.patterns.mod_binary_search;

/**
 * Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
 * The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
 * Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
 */
public class NumberCeil {

    static int findCeil(int [] arr, int num) {

        if (num > arr[arr.length - 1]) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (end + start) / 2;

            if (arr[mid] < num) {
                start = mid + 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            } else {
                return arr[mid];
            }
        }

        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array, so the next big number will be arr[start]
        return arr[start];
    }

    public static void main(String[] args) {

        int res = findCeil(new int [] {1, 3, 8, 10, 15}, 12);
        System.out.println(res);

        res = findCeil(new int [] {0, 1, 3, 8, 10, 15, 18, 20}, 12);
        System.out.println(res);

        res = findCeil(new int [] {1, 3, 8, 10, 15}, -12);
        System.out.println(res);

        res = findCeil(new int [] {1, 3, 8, 10, 15}, 0);
        System.out.println(res);

    }
}
