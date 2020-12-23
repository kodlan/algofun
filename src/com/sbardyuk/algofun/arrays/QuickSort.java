package com.sbardyuk.algofun.arrays;

import java.util.Arrays;

public class QuickSort {

    static int [] quicksort(int [] array) {

        q(array, 0, array.length - 1);

        return array;
    }

    static void q(int [] array, int start, int end) {

        if (end - start <= 1) return;

        int curr = start;
        int originalEnd = end;

        int next = start + 1;

        while (next <= end) {
            if (array[next] < array[curr]) {
                swap(array, next, curr);
                curr = next;
                next ++;
            } else {
                swap(array, next, end);
                end --;
            }
        }

        q(array, start, curr - 1);
        q(array, curr + 1, originalEnd);
    }

    static void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int [] res = quicksort(new int [] {55, 23, 26, 2, 18, 78, 23, 8, 2, 3});
        System.out.println(Arrays.toString(res));
    }
}
