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

    static boolean canBottomUp(int [] nums, int sum) {
        int n = nums.length;

        boolean [][] table = new boolean [n][sum + 1];

        // populate the sum=0 columns, as we can always form '0' sum with an empty set
        for (int i = 0; i < n; i ++) {
            table[i][0] = true;
        }

        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int s = 1; s <= sum; s++) {
            table[0][s] = nums[0] == s;
        }

        // process all subsets for all sums
        for (int i = 1; i < n; i++) {

            for (int s = 1; s <= sum; s++) {

                // if we can get the sum 's' without the number at index 'i'
                if (table[i - 1][s]) {
                    table[i][s] = table[i - 1][s];
                } else if (s >= nums[i]) {
                    // else include the number and see if we can find a subset to get the remaining sum
                    table[i][s] = table[i - 1][s - nums[i]];
                }

            }
        }

        // the bottom-right corner will have our answer.
        return table[n - 1][sum];
    }


    public static void main(String[] args) {
        System.out.println(sum(new int [] {1, 2, 3, 7}, 6));
        System.out.println();
        System.out.println(sum(new int [] {1, 2, 7, 1, 5}, 10));
        System.out.println();
        System.out.println(sum(new int [] {1, 3, 4, 8}, 6));

        System.out.println();
        System.out.println();

        System.out.println(canBottomUp(new int [] {1, 2, 3, 7}, 6));
        System.out.println();
        System.out.println(canBottomUp(new int [] {1, 2, 7, 1, 5}, 10));
        System.out.println();
        System.out.println(canBottomUp(new int [] {1, 3, 4, 8}, 6));
    }
}
