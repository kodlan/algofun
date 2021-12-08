package com.sbardyuk.algofun.google3_warmup;

public class SmallestSubarrayWithSum {

    public  static int findMinSubArray(int sum, int [] array) {

        int start = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < array.length; end ++) {

            currentSum += array[end];

            while (currentSum > sum && start < end) {
                currentSum -= array[start];
                start ++;
            }

            if (currentSum >= sum) {
                minLength = Math.min(minLength, end - start + 1);
            }
        }

        return minLength;
    }


    public static void main(String[] args) {
        int result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
