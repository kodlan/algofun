package com.sbardyuk.algofun.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer, return all possible sum combinations for this number using positive integers.
 */
public class AllPossibleNumsWithSum {

    static List<List<Integer>> allSums(int num) {

        List<List<Integer>> res = new ArrayList<>();

        s(res, new ArrayList<>(), num, num);

        return res;
    }

    static void s(List<List<Integer>> allRes, List<Integer> list, int sum, int num) {

        if (sum == 0) {
            allRes.add(list);
        } else if (sum < 0) {
            return;
        }

        for (int j = 1; j<=num - 1; j ++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(j);
            s(allRes, newList, sum - j, num);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = allSums(4);

        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }
}
