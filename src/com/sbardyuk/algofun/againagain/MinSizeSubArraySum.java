package com.sbardyuk.algofun.againagain;

public class MinSizeSubArraySum {

    /**
     * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
     *
     * Example 1:
     *
     * Input: [2, 1, 5, 2, 3, 2], S=7
     * Output: 2
     * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
     * Example 2:
     *
     * Input: [2, 1, 5, 2, 8], S=7
     * Output: 1
     * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
     * Example 3:
     *
     * Input: [3, 4, 1, 1, 6], S=8
     * Output: 3
     * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
     */
    public static int findMinSubArray(int S, int[] arr) {

        int windowStart = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd ++) {

            sum += arr[windowEnd];

            while (sum > S && windowStart < windowEnd) {
                sum -= arr[windowStart];
                windowStart ++;
            }

            if (sum >= S) {
                minLen = Math.min(minLen, windowEnd - windowStart + 1);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
