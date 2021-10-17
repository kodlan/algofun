package com.sbardyuk.algofun.practice;

import java.util.*;

public class PairWithTargetSum {

    private static List<Integer> pair(List<Integer> nums, int targetSum) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.size(); index ++) {
            map.put(nums.get(index), index);
        }

        for (int index = 0; index < nums.size(); index ++) {
            int currentVal = nums.get(index);
            int complementary = targetSum - currentVal;

            if (map.containsKey(complementary) && index != map.get(complementary) ) {
                return Arrays.asList(currentVal, complementary);
            }
        }

        return Collections.emptyList();
    }

    private static List<Integer> pairInline(List<Integer> nums, int targetSum) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.size(); index ++) {

            int current = nums.get(index);
            int complimentary = targetSum - current;

            if (map.containsKey(complimentary) && index != map.get(complimentary)) {
                return Arrays.asList(current, complimentary);
            } else {
                map.put(current, index);
            }
        }

        return Collections.emptyList();
    }

    private static List<Integer> pairSorted(List<Integer> nums, int targetSum) {

        int start = 0;
        int end = nums.size() - 1;

        while (end > start) {

            int sum = nums.get(start) + nums.get(end);

            if (sum == targetSum) {
                return Arrays.asList(nums.get(start), nums.get(end));
            } else if (sum < targetSum) {
                start ++;
            } else {
                end --;
            }
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {
        System.out.println(pair(Arrays.asList(1, 2, 3, 4, 5), 5));
        System.out.println(pairInline(Arrays.asList(1, 2, 3, 4, 5), 5));
        System.out.println(pairSorted(Arrays.asList(1, 2, 3, 4, 5), 5));

    }
}
