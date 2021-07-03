package com.sbardyuk.algofun.againagain;

/**
 * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
 *
 * Example 1:
 *
 * Input: [4, 0, 3, 1]
 * Output: 2
 * Example 2:
 *
 * Input: [8, 3, 5, 2, 4, 6, 0, 1]
 * Output: 7
 */
public class FindMissingNumber {

    public static int findMissingNumber(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            if (nums[i] != i && nums[i] != nums.length) {
                swap(nums, i, nums[i]);
            } else {
                i ++;
            }
        }

        for (i = 0; i < nums.length; i ++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

    private static void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }

}
