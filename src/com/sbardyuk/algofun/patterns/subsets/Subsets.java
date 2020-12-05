package com.sbardyuk.algofun.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        subsetsInternal(subsets, nums, 0);

        return subsets;
    }

    static void subsetsInternal(List<List<Integer>> lists, int [] nums, int currentNum) {
        List<List<Integer>> listsToAdd = new ArrayList<>();

        for (List<Integer> list : lists) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[currentNum]);
            listsToAdd.add(newList);
        }

        lists.addAll(listsToAdd);

        if (currentNum + 1 < nums.length) {
            subsetsInternal(lists, nums, currentNum + 1);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> result = findSubsets(new int[] { 1, 3 });
        System.out.println(result);

        result = findSubsets(new int[] { 1, 5, 3 });
        System.out.println(result);
    }
}
