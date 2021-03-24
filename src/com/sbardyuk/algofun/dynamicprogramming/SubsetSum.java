package com.sbardyuk.algofun.dynamicprogramming;

public class SubsetSum {

    private static boolean canPartition(int [] arr, int sum) {
        Boolean [][] memo = new Boolean[arr.length][sum + 1];
        return canRec(memo, arr, sum, 0);
    }

    private static boolean canRec(Boolean [][] memo, int [] arr, int sumLeft, int index) {
        if (sumLeft == 0) {
            return true;
        }

        if (sumLeft < 0 || index < 0 || index >= arr.length) {
            return false;
        }

        if (memo[index][sumLeft] == null) {
            memo[index][sumLeft] = canRec(memo, arr, sumLeft - arr[index], index + 1) ||
                    canRec(memo, arr, sumLeft, index + 1);
        }

        return memo[index][sumLeft];
    }

    private static boolean canTable(int [] arr, int sum) {
        int n = arr.length;
        Boolean [][] t = new Boolean [n][sum + 1];

        for (int i = 0; i < n; i++) t[i][0] = true;

        for (int s = 1; s <= sum; s++) t[0][s] = arr[0] == s;

        for (int s = 1; s <= sum; s++) {
            for (int i = 1; i < n; i++) {

                if (t[i - 1][s]) {
                    t[i][s] = t[i - 1][s];
                } else if (s >= arr[i]) {
                    t[i][s] = t[i - 1][s - arr[i]];
                }
            }
        }

        return t[n - 1][sum];
    }


    public static void main(String[] args) {
        int[] num = { 1, 2, 3, 7 };
        System.out.println(canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(canPartition(num, 6));

        System.out.println();

        num = new int [] { 1, 2, 3, 7 };
        System.out.println(canTable(num, 6));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(canPartition(num, 6));    }
}
