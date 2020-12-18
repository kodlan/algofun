package com.sbardyuk.algofun.patterns.knapsack;


public class ProfitKnapsack {

    static int knap(int [] weights, int [] profits, int capacity, int index) {
        if (index >= weights.length || capacity <= 0) {
            return 0;
        }

        int profit1 = knap(weights, profits, capacity, index + 1);

        int profit2 = 0;
        if (weights[index] <= capacity) {
            profit2 = profits[index] + knap(weights, profits, capacity - weights[index], index + 1);
        }

        return Math.max(profit1, profit2);

    }

    public static void main(String[] args) {

        System.out.println((knap(new int [] {2, 3, 1, 4}, new int [] {4, 5, 3, 7}, 5, 0)));
        System.out.println((knap(new int [] {1, 6, 10, 16}, new int [] {1, 2, 3, 5}, 6, 0)));

    }
}
