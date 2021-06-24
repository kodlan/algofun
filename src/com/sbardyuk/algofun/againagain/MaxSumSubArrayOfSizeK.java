package com.sbardyuk.algofun.againagain;

public class MaxSumSubArrayOfSizeK {

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
