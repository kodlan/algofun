package com.sbardyuk.algofun.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetsAndPermut {

    private static int [] nums = new int[] {1, 5, 3};

    private static void sets() {
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<>());

        for (int i : nums) {
            List<List<Integer>> newList = new ArrayList<>();

            for (List<Integer> list: sets) {

                List<Integer> copy = new ArrayList<>(list);
                copy.add(i);

                newList.add(copy);
            }

            sets.addAll(newList);
        }

        printLists(sets);

    }

    private static void permuts() {
        List<List<Integer>> permuts = new ArrayList<>();
        permuts.add(new ArrayList<>());

        for (int i : nums) {
            List<List<Integer>> newList = new ArrayList<>();

            for (List<Integer> list : permuts) {

                List<Integer> copy = new ArrayList<>(list);
                copy.add(i);

                list.add(0, i);

                newList.add(copy);
                newList.add(list);
            }

            permuts.clear();
            permuts.addAll(newList);
        }

        printLists(permuts);
    }

    private static void printLists(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void main(String[] args) {
        sets();
        System.out.println("and now permuts");
        permuts();
    }
}
