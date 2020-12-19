package com.sbardyuk.algofun.patterns.knapsack;

public class SubsetSum {

    static boolean sum(int [] nums, int sum) {

        Boolean [][] memo = new Boolean [sum + 1][nums.length];

        boolean res = sumrec(memo, nums, sum, 0);

        return res;
    }

    static boolean sumrec(Boolean [][] memo, int [] nums, int sum, int index) {

        if (index >= nums.length) {
            return sum == 0;
        }

        if (sum == 0) {
            return true;
        } else if (sum < 0) {
            return false;
        }

        if (memo[sum][index] == null) {
            boolean b1 = sumrec(memo, nums, sum, index + 1);
            boolean b2 = sumrec(memo, nums, sum - nums[index], index + 1);

            memo[sum][index] = b1 | b2;
        }

        return memo[sum][index];
    }

    public static void main(String[] args) {
        System.out.println(sum(new int [] {1, 2, 3, 7}, 6));
        System.out.println();
        System.out.println(sum(new int [] {1, 2, 7, 1, 5}, 10));
        System.out.println();
        System.out.println(sum(new int [] {1, 3, 4, 8}, 6));
    }
}
