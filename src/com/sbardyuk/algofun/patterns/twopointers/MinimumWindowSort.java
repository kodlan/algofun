package com.sbardyuk.algofun.patterns.twopointers;

public class MinimumWindowSort {

    private static int getUnsortedWindow(int [] array) {
        int start = 0;

        // find the item that is not sorted
        while (start < array.length - 1 && array[start] <= array[start + 1]) start ++;

        if (start == array.length - 1) return 0;

        // find the last item that is not sorted
        int end = array.length - 1;
        while (end > 0 && array[end] >= array[end - 1]) end --;


        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (start > 0 && array[start - 1] > min) start --;

        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while (end < array.length - 1 && array[end + 1] < max) end ++;

        return end - start;
    }

    public static void main(String[] args) {

        System.out.println(getUnsortedWindow(new int [] {1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(getUnsortedWindow(new int [] {1, 3, 2, 0, -1, 7, 10}));
        System.out.println(getUnsortedWindow(new int [] {1, 2, 3}));
        System.out.println(getUnsortedWindow(new int [] {3, 2, 1}));

    }
}
