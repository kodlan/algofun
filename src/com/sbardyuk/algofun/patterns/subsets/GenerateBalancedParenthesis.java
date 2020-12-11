package com.sbardyuk.algofun.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParenthesis {

    static List<String> generate(int n) {
        List<String> res = new ArrayList<>();

        generateRecursive(res, "", n, 0, 0);

        return res;
    }

    static void generateRecursive(List<String> lists, String current, int n, int nOpen, int nClose) {

        if (nOpen > n || nClose > n) {
            return;
        }

        if (nOpen == n && nClose == n) {
            lists.add(current);
        }

        if (nOpen < n)      generateRecursive(lists, current + "(", n, nOpen + 1, nClose);
        if (nOpen > nClose) generateRecursive(lists, current + ")", n, nOpen, nClose + 1);
    }

    public static void main(String[] args) {

        List<String> res = generate(3);
        System.out.println(res);

    }

}
