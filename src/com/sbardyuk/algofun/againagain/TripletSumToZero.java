package com.sbardyuk.algofun.againagain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Example 1:
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * Example 2:
 *
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            pairWithSum(arr, -arr[i], i + 1, res);
        }

        return res;
    }

    private static void pairWithSum(int [] arr, int targetSum, int left, List<List<Integer>> res) {
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (targetSum == sum) {
                res.add(Arrays.asList(arr[left], arr[right], -targetSum));
                left ++;
                right --;

                while (left < right && arr[left] == arr[left - 1]) {
                    left++; // skip same element to avoid duplicate triplets
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--; // skip same element to avoid duplicate triplets
                }

            } else if (targetSum > sum) {
                left ++;
            } else {
                right --;
            }
        }

    }


    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }

}
