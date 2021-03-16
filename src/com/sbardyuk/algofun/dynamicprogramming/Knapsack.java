package com.sbardyuk.algofun.dynamicprogramming;

public class Knapsack {

    private static int knap(int [] profits, int [] weights, int maxWeight) {
        return knapRec(profits, weights, maxWeight, 0);
    }

    private static int knapRec(int [] profits, int [] weights, int weightLeft, int index) {
        if (weightLeft <= 0 || index >= profits.length) {
            return 0;
        }

        int profit1 = 0;

        if (weights[index] <= weightLeft) {
            profit1 = profits[index] + knapRec(profits, weights, weightLeft - weights[index], index + 1);
        }

        int profit2 = knapRec(profits, weights, weightLeft, index + 1);

        return Math.max(profit1, profit2);
    }

    private static int knapMemo(int [] profits, int [] weights, int weightLeft) {
        int [][] memo = new int [weightLeft + 1][profits.length + 1];
        return knapMemoRec(memo, profits, weights, weightLeft, 0);
    }

    private static int knapMemoRec(int memo[][], int [] profits, int [] weights, int weightLeft, int index) {
        if (weightLeft <= 0 || index >= profits.length) {
            return 0;
        }

        if (memo[weightLeft][index] != 0) {
            return memo[weightLeft][index];
        }

        int profit1 = 0;
        if (weights[index] <= weightLeft) {
            profit1 = profits[index] + knapMemoRec(memo, profits, weights, weightLeft - weights[index], index + 1);
        }

        int profit2 = knapMemoRec(memo, profits, weights, weightLeft, index + 1);

        int res = Math.max(profit1, profit2);
        memo[weightLeft][index] = res;

        return res;
    }

    private static int knapTabulation(int [] profits, int [] weights, int weightLeft) {
        int n = profits.length;
        int [][] table = new int [n][weightLeft + 1];

        for (int i = 0; i < n; i ++) {
            table[i][0] = 0;
        }

        for (int w = 0; w <= weightLeft; w ++) {
            if (weights[0] <= w) {
                table [0][w] = profits[0];
            }
        }

        for(int i = 1; i < n; i ++) {
            for(int w = 1; w <= weightLeft; w ++) {
                int profit1= 0, profit2 = 0;

                // include the item, if it is not more than the capacity
                if(weights[i] <= w)
                    profit1 = profits[i] + table[i-1][w-weights[i]];

                // exclude the item
                profit2 = table[i-1][w];

                // take maximum
                table[i][w] = Math.max(profit1, profit2);
            }
        }

        // maximum profit will be at the bottom-right corner.
        return table[n - 1][weightLeft];

    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};


        int maxProfit = knap(profits, weights, 7);
        System.out.println("Total knapsack profit = " + maxProfit);
        maxProfit = knap(profits, weights, 6);
        System.out.println("Total knapsack profit = " + maxProfit);


        maxProfit = knapMemo(profits, weights, 7);
        System.out.println("Total knapsack profit = " + maxProfit);
        maxProfit = knap(profits, weights, 6);
        System.out.println("Total knapsack profit = " + maxProfit);

        maxProfit = knapTabulation(profits, weights, 7);
        System.out.println("Total knapsack profit = " + maxProfit);
        maxProfit = knapTabulation(profits, weights, 6);
        System.out.println("Total knapsack profit = " + maxProfit);
    }
}
