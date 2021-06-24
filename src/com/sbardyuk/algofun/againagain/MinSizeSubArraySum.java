package com.sbardyuk.algofun.againagain;

public class MinSizeSubArraySum {

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
