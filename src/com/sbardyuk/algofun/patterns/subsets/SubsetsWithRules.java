package com.sbardyuk.algofun.patterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithRules {

    private static List<Integer> digitsList = Arrays.asList(0, 1, 6, 8, 9);

    private static boolean isRotateble(int num) {

        while (num > 1) {
            int digit = num % 10;
            num = num / 10;

            if (!digitsList.contains(digit)) {
                return false;
            }
        }

        return true;

    }

    static List<Integer> getNumsBrutforce(int maxNum) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= maxNum; i ++) {

            if (isRotateble(i)) {
                res.add(i);
            }

        }

        return res;
    }

    static List<Integer> getNums(int maxNum) {
        List<Integer> res = new ArrayList<>(digitsList);
        List<Integer> prev = new ArrayList<>(digitsList);

        int newNum = 0;

        while (newNum < maxNum) {

            List<Integer> newList = new ArrayList<>();

            for (Integer i : prev) {

                for (Integer d : digitsList) {

                    if (i == 0) {
                        break;
                    }

                    newNum = i * 10 + d;

                    if (newNum != 0 && newNum <= maxNum) {
                        newList.add(newNum);
                    }

                    if (newNum > maxNum) {
                        res.addAll(newList);
                        return res;
                    }
                }
            }

            res.addAll(newList);
            prev = newList;
        }

        return res;
    }


    public static void main(String[] args) {

        List<Integer> res = getNumsBrutforce(200);
        System.out.println(res);

        res = getNums(200);
        System.out.println(res);

    }
}
