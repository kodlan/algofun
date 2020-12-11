package com.sbardyuk.algofun.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    static List<List<Integer>> permut(int [] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {

            List<List<Integer>> newRes = new ArrayList<>();

            for (List<Integer> list : res) {
                for (int i = 0; i < list.size() + 1; i ++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i, num);

                    newRes.add(newList);
                }
            }

            res = newRes;
        }

        return res;
    }

    public static void main(String[] args) {

        List<List<Integer>> res = permut(new int[] {1, 3, 5});
        System.out.println(res);

    }

}
