package com.sbardyuk.algofun.google3_warmup;

public class Knapsack {

    /////
    ///// Recursive
    private static int knap(int [] profits, int [] weights, int maxWeight) {
        return knapRec(0, profits, weights, maxWeight);
    }

    private static int knapRec(int index, int [] profits, int [] weights, int weightLeft) {
        if (index >= profits.length || weightLeft <= 0) {
            return 0;
        }

        int p1 = 0;
        if(weights[index] <= weightLeft) {
            p1 = profits[index] + knapRec(index + 1, profits, weights, weightLeft - weights[index]);
        }
        int p2 = knapRec(index + 1, profits, weights, weightLeft);

        return Math.max(p1, p2);
    }

    //////
    ////// Memoization
    private static int knapMemo(int [] profits, int [] weights, int maxWeight) {
        int [][] dp = new int [profits.length][maxWeight + 1];
        return knapMemRec(0, profits, weights, maxWeight, dp);
    }

    private static int knapMemRec(int index, int [] profits, int [] weights, int weightLeft, int [][] dp) {
        if (index >= profits.length || weightLeft <= 0) {
            return 0;
        }

        if (dp[index][weightLeft] != 0) {
            return dp[index][weightLeft];
        }

        int p1 = 0;
        if(weights[index] <= weightLeft) {
            p1 = profits[index] + knapMemRec(index + 1, profits, weights, weightLeft - weights[index], dp);
        }
        int p2 = knapMemRec(index + 1, profits, weights, weightLeft, dp);

        dp[index][weightLeft] = Math.max(p1, p2);

        return dp[index][weightLeft];
    }

    //////
    ////// Tabulation
    private static int knapTabulation(int [] profits, int [] weights, int maxWeight) {
        int [][] tab = new int [weights.length][maxWeight + 1];

        int minWeight = weights[0];
        for (int i = 0; i <= maxWeight; i ++) {
            if (minWeight <= i) {
                tab[0][i] = profits[0];
            }
        }

        for (int index = 1; index < profits.length; index ++) {
            for (int targetW = 1; targetW <= maxWeight; targetW ++) {
                int profit1 = 0;
                int profit2 = 0;

                // include the item, if it is not more than the capacity
                if(weights[index] <= targetW)
                    profit1 = profits[index] + tab[index-1][targetW-weights[index]];

                // exclude the item
                profit2 = tab[index-1][targetW];

                // take maximum
                tab[index][targetW] = Math.max(profit1, profit2);
            }
        }

        return tab[profits.length - 1][maxWeight];
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
        maxProfit = knapMemo(profits, weights, 6);
        System.out.println("Total knapsack profit = " + maxProfit);

        maxProfit = knapTabulation(profits, weights, 7);
        System.out.println("Total knapsack profit = " + maxProfit);
        maxProfit = knapTabulation(profits, weights, 6);
        System.out.println("Total knapsack profit = " + maxProfit);
    }
}
