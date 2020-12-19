package com.sbardyuk.algofun.patterns.knapsack;

import java.util.HashMap;
import java.util.Map;

public class SubSetSumPartition {

    static boolean canPartition(int [] nums) {
        return can(nums, 0, 0, 0);
    }

    static boolean can(int [] nums, int sum1, int sum2, int index) {

        if (index >= nums.length) {
            return sum1 == sum2;
        }

        boolean can1 = can(nums, sum1 + nums[index], sum2, index + 1);
        boolean can2 = can(nums, sum1, sum2 + nums[index], index + 1);

        return can1 || can2;
    }

    static boolean canPartitionMemo(int [] nums) {
        Map<String, Boolean> map = new HashMap<>();
        boolean can = canmemo(map, nums, 0, 0, 0);
        System.out.println(map);
        return can;
    }

    static boolean canmemo(Map<String, Boolean> memo, int [] nums, int sum1, int sum2, int index) {
        if (index >= nums.length) {
            return sum1 == sum2;
        }

        Boolean canmemo = memo.get(key(sum1, sum2, index));
        if (canmemo != null) {
            System.out.println("memo = " + key(sum1, sum2, index));
            return canmemo;
        }

        boolean can1 = canmemo(memo, nums, sum1 + nums[index], sum2, index + 1);
        boolean can2 = canmemo(memo, nums, sum1, sum2 + nums[index], index + 1);

        memo.put(key(sum1, sum2, index), can1 | can2);

        return can1 | can2;
    }

    private static String key(int sum1, int sum2, int index) {
        return sum1 + ":" + sum2 + ":" + index;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int [] { 1, 2, 3, 4 }));
        System.out.println(canPartition(new int [] { 1, 1, 3, 4, 7 }));
        System.out.println(canPartition(new int [] { 2, 3, 4, 6 }));
        System.out.println(canPartition(new int [] { 2, 3, 4, 6, 4, 5, 10, -1, 0, 2, 9, 10, 5, 3, 7, 8 }));

        System.out.println(canPartitionMemo(new int [] { 1, 2, 3, 4 }));
        System.out.println();
        System.out.println(canPartitionMemo(new int [] { 1, 1, 3, 4, 7 }));
        System.out.println();
        System.out.println(canPartitionMemo(new int [] { 2, 3, 4, 6 }));
        System.out.println();
        System.out.println(canPartitionMemo(new int [] { 2, 3, 4, 6, 4, 5, 10, -1, 0, 2, 9, 10, 5, 3, 7, 8 }));
    }

}
