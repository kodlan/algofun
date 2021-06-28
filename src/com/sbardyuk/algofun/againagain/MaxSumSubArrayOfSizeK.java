package com.sbardyuk.algofun.againagain;

public class MaxSumSubArrayOfSizeK {

    /**
     * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
     *
     * Example 1:
     *
     * Input: [2, 1, 5, 1, 3, 2], k=3
     * Output: 9
     * Explanation: Subarray with maximum sum is [5, 1, 3].
     * Example 2:
     *
     * Input: [2, 3, 4, 1, 5], k=2
     * Output: 7
     * Explanation: Subarray with maximum sum is [3, 4].
     *
     */

    public static int findMaxSumSubArray(int k, int[] arr) {

        int maxSum = 0;
        int sum = 0;

        int windowStart = 0;
        int windowEnd = 0;

        while (windowEnd < arr.length) {

            if (windowEnd - windowStart >= k) {

                if (maxSum < sum) {
                    maxSum = sum;
                }

                sum -= arr[windowStart];
                windowStart ++;
            }

            sum += arr[windowEnd];

            windowEnd ++;
        }

        return maxSum;

    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
