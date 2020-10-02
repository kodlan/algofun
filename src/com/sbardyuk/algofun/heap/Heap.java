package com.sbardyuk.algofun.heap;

import java.util.Arrays;

public class Heap {

    private static void swap(int [] array, int i, int j) {
        int tmp = array [j];
        array [j] = array [i];
        array [i] = tmp;
    }

    private void maxHeapifyRecursive(int [] heapArray, int index, int heapSize) {
        if (index >= heapSize / 2) {
            return;
        }

        int leftIndex = (2 * index) + 1;
        int rightIndex = (2 * index) + 2;

        int largestIndex = getIndexOfMaxElement(heapArray, index, heapSize, leftIndex, rightIndex);
        if (largestIndex != index) {
            swap(heapArray, index, largestIndex);
            maxHeapifyRecursive(heapArray, largestIndex, heapSize);
        }
    }

    private void maxHeapify(int [] heapArray, int index, int heapSize) {
        while (index < heapSize / 2) {
            int leftIndex = (2 * index) + 1;
            int rightIndex = (2 * index) + 2;

            int largestIndex = getIndexOfMaxElement(heapArray, index, heapSize, leftIndex, rightIndex);
            if (largestIndex != index) {
                swap(heapArray, index, largestIndex);
                index = largestIndex;
            } else {
                break;
            }
        }
    }

    private int getIndexOfMaxElement(int[] heapArray, int index, int heapSize, int leftIndex, int rightIndex) {
        int largestIndex = index;
        if (leftIndex < heapSize && heapArray[leftIndex] > heapArray[index]) {
            largestIndex = leftIndex;
        }
        if (rightIndex < heapSize && heapArray[rightIndex] > heapArray[largestIndex]) {
            largestIndex = rightIndex;
        }
        return largestIndex;
    }

    public void maxHeapifyArray(int [] heapArray) {
        for (int i = (heapArray.length - 1) / 2; i >=0; i--) {
            maxHeapify(heapArray, i, heapArray.length);
        }
    }

    public void maxHeapifyArrayRecursive(int [] heapArray) {
        for (int i = (heapArray.length - 1) / 2; i >=0; i--) {
            maxHeapifyRecursive(heapArray, i, heapArray.length);
        }
    }

    private void minHeapifyRecursive(int [] heapArray, int index, int heapSize) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        int smallestChildIndex = index;
        if (rightIndex < heapSize && heapArray[index] > heapArray[rightIndex]) {
            smallestChildIndex = rightIndex;
        }
        if (leftIndex < heapSize &&  heapArray[smallestChildIndex] > heapArray[leftIndex]) {
            smallestChildIndex = leftIndex;
        }

        if (index != smallestChildIndex) {
            swap(heapArray, smallestChildIndex, index);
            minHeapifyRecursive(heapArray, smallestChildIndex, heapSize);
        }
    }

    public void minHeapifyArrayRecursive(int [] heapArray) {
        for (int i = (heapArray.length - 1) / 2; i >= 0; i --) {
            minHeapifyRecursive(heapArray, i, heapArray.length);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        int [] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
        System.out.println(Arrays.toString(heapArray));
        heap.maxHeapifyArray(heapArray);
        System.out.println(Arrays.toString(heapArray));

        int [] heapArrayRec = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
        System.out.println(Arrays.toString(heapArrayRec));
        heap.maxHeapifyArrayRecursive(heapArrayRec);
        System.out.println(Arrays.toString(heapArrayRec));

        System.out.println("Min heap:");
        int [] heapArrayRecMin = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
        System.out.println(Arrays.toString(heapArrayRecMin));
        heap.minHeapifyArrayRecursive(heapArrayRecMin);
        System.out.println(Arrays.toString(heapArrayRecMin));
    }
}
