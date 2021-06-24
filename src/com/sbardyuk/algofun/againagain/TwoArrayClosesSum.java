package com.sbardyuk.algofun.againagain;

import java.util.Arrays;

public class TwoArrayClosesSum {

    private static void closest(int [] a, int [] b, int targetSum) {

        Arrays.sort(a);
        Arrays.sort(b);

        int i = a.length - 1;
        int j = 0;

        while (i > 0 && j < b.length) {

            int sum = a[i] + b[j];

            System.out.println(sum);

            if (sum > targetSum) {
                i--;
            } else if (sum < targetSum) {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        closest(new int [] {7, 4, 1, 10}, new int [] {4, 5, 8, 7}, 13);
    }

}
