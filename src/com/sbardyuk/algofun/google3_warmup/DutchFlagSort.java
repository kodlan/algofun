package com.sbardyuk.algofun.google3_warmup;

public class DutchFlagSort {

    private static void sort(int [] array) {

        int p0 = 0;
        int p2 = array.length - 1;
        int index = 0;

        while (index <= p2) {

            if (array[index] == 0) {
                swap(array, index, p0);
                p0 ++;
                index ++;
            } else if (array[index] == 2) {
                swap(array, index, p2);
                p2 --;
            } else {
                index ++;
            }

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }


}
