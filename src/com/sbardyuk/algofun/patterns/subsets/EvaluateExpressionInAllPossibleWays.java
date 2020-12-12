package com.sbardyuk.algofun.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpressionInAllPossibleWays {

    static List<StringBuilder> getAllFormulas(String expression) {
        List<StringBuilder> res = new ArrayList<>();

        allFormulasRecursive(res, 0, 0, new StringBuilder(expression), 0);

        return res;
    }

    static void allFormulasRecursive(List<StringBuilder> list, int nOpen, int nClose, StringBuilder expr, int index) {

        int len = expr.length() - 1;

        if (index > len) {
            list.add(expr);
            return;
        }

        int nextIndex = index + 1;



        if (index == 0 || Character.isDigit(expr.charAt(index))) {

            if (index == len && nClose != nOpen) {
                allFormulasRecursive(list, nOpen, nClose + 1, expr.insert(index, ')'), index + 2);
            } else if (index != len && nClose < nOpen) {
                allFormulasRecursive(list, nOpen, nClose, expr, index + 1);
                allFormulasRecursive(list, nOpen, nClose + 1, expr.insert(index, ')'), index + 2);
            }

        } else if (nextIndex < len && Character.isDigit(expr.charAt(nextIndex))) {

            allFormulasRecursive(list, nOpen, nClose, expr, index + 1);
            allFormulasRecursive(list, nOpen + 1, nClose, expr.insert(index, '('), index + 2);

        }

    }

    public static void main(String[] args) {
        List<StringBuilder> res = getAllFormulas("1+2*3");
        System.out.println(res);
    }
}
