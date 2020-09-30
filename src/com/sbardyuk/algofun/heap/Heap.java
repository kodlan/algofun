package com.sbardyuk.algofun.heap;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Heap {

    private static void swap(int [] array, int i, int j) {
        int tmp = array [j];
        array [j] = array [i];
        array [i] = tmp;
    }

    private void maxHeapify(int [] heapArray, int index, int heapSize) {

        int largestIndex = index;

        while (largestIndex < heapSize / 2) {

            int leftIndex = (2 * index) + 1;
            int rightIndex = (2 * index) + 2;

            if (leftIndex < heapSize && heapArray[leftIndex] > heapArray[index]) {
                largestIndex = leftIndex;
            }

            if (rightIndex < heapSize && heapArray[rightIndex] > heapArray[largestIndex]) {
                largestIndex = rightIndex;
            }

            if (largestIndex != index) {
                swap(heapArray, index, largestIndex);
                index = largestIndex;
            } else {
                break;
            }
        }


    }

    public void maxHeapifyArray(int [] heapArray) {
        for (int i = (heapArray.length - 1) / 2; i >=0; i--) {
            maxHeapify(heapArray, i, heapArray.length);
        }
    }

    public static void main(String[] args) {

        int [] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16};

        System.out.println(Arrays.toString(heapArray));

        Heap heap = new Heap();
        heap.maxHeapifyArray(heapArray);

        System.out.println(Arrays.toString(heapArray));



    }


}
