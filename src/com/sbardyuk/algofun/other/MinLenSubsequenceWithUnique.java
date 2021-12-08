package com.sbardyuk.algofun.other;

import java.util.*;

/**
 * Given a sequence such as S = {1,8,2,1,4,1,2,9,1,8,4}, I need to find the minimal-length subsequence that contains
 * all element of S (no duplicates, order does not matter). How do find this subsequence in an efficient way?
 *
 * Note: There are 5 distinct elements in S: {1,2,4,8,9}. The minimum-length subsequence must contain all these 5 elements.
 */
public class MinLenSubsequenceWithUnique {

    private static int minLen(int [] nums) {
        int uNum = uniqe(nums);

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            int next = nums[i];
            freq.put(next, freq.getOrDefault(next, 0) + 1);

            if (freq.size() == uNum) {
                return i;
            }
        }

        return 0;
    }

    private static int uniqe(int [] nums) {
        Set<Integer> u = new HashSet<>();
        for (int i : nums) {
            u.add(i);
        }

        return u.size();
    }

    public static void main(String[] args) {
        int [] nums = new int [] {1,8,2,1,4,1,2,9,1,8,4};
        int minLen = minLen(nums);
        System.out.println(minLen);

        for (int i = 0; i <= minLen; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
