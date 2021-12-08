package com.sbardyuk.algofun.google3_warmup;

public class MaxSumOfSubArray {

    private static int findMaxSumSubArray(int k, int [] array) {
        int start = 0;
        int end = 0;
        int maxSum = 0;
        int currentSum = 0;

        while (end < array.length) {
            if (end - start == k) {

                maxSum = Math.max(currentSum, maxSum);

                currentSum -= array[start];
                start ++;
            }

            currentSum += array[end];
            end ++;
        }

        return maxSum;
    }


    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }

}
