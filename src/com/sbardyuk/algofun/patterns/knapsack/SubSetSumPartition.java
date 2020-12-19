package com.sbardyuk.algofun.patterns.knapsack;

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

    public static void main(String[] args) {
        System.out.println(canPartition(new int [] { 1, 2, 3, 4 }));
        System.out.println(canPartition(new int [] { 1, 1, 3, 4, 7 }));
        System.out.println(canPartition(new int [] { 2, 3, 4, 6 }));
    }

}
