package com.sbardyuk.algofun.patterns.knapsack;


import java.util.ArrayList;
import java.util.List;

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

    static class KnapRes {
        List<Integer> items;
        int weight;
        int profit;

        @Override
        public String toString() {
            return items.toString() + ", weight = " + weight + ", profit = " + profit;
        }
    }

    static KnapRes knapItems(List<Integer> items, int [] weights, int [] profits, int capacity, int index) {
        if (index >= weights.length || capacity <= 0) {
            return null;
        }

        KnapRes res1 = knapItems(new ArrayList<>(items), weights, profits, capacity, index + 1);

        KnapRes res2 = null;
        if (weights[index] <= capacity) {
            List<Integer> itemsWithCurrent = new ArrayList<>(items);
            itemsWithCurrent.add(weights[index]);

            res2 = knapItems(itemsWithCurrent, weights, profits, capacity - weights[index], index + 1);
            if (res2 == null) {
                res2 = new KnapRes();
                res2.items = new ArrayList<>(itemsWithCurrent);
                for (int i : itemsWithCurrent) {
                    res2.weight += i;
                }
                res2.profit += profits[index];
            } else {
                res2.profit = res2.profit + profits[index];
            }
        }

        if (res1 == null && res2 == null) return null;
        if (res1 == null) return res2;
        if (res2 == null) return res1;

        if (res1.profit > res2.profit) {
            return res1;
        } else {
            return res2;
        }

    }


    public static void main(String[] args) {

        System.out.println((knap(new int [] {2, 3, 1, 4}, new int [] {4, 5, 3, 7}, 5, 0)));
        System.out.println((knap(new int [] {1, 6, 10, 16}, new int [] {1, 2, 3, 5}, 6, 0)));

        System.out.println((knapItems(new ArrayList<>(), new int [] {2, 3, 1, 4}, new int [] {4, 5, 3, 7}, 5, 0)));
        System.out.println((knapItems(new ArrayList<>(), new int [] {1, 6, 10, 16}, new int [] {1, 2, 3, 5}, 6, 0)));

    }
}
