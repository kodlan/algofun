package com.sbardyuk.algofun.patterns.slidingwindow;

public class SmallestSubarrayWithSum {

    // Smallest Subarray with a given sum

    public static int findMinSubarraySize(int sum, int [] arr) {

        int windowSum = 0;
        int minLength = arr.length;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= sum) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubarraySize(7, new int []{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubarraySize(7, new int []{2, 1, 5, 2, 8}));
        System.out.println(findMinSubarraySize(8, new int []{3, 4, 1, 1, 6}));

    }
}
