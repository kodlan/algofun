package com.sbardyuk.algofun.again;

import java.util.ArrayList;
import java.util.List;

public class BalancedParanthesis {

    private static List<String> par(int n) {
        List<String> list = new ArrayList<>();

        parRec(list,"", n, 0);

        return list;
    }

    private static void parRec(List<String> list, String current, int nToOpen, int nToClose) {
        if (nToOpen == 0 && nToClose == 0) {
            list.add(current);
            return;
        }

        if (nToOpen > 0) parRec(list, current + "(", nToOpen - 1, nToClose + 1);
        if (nToClose > 0) parRec(list, current + ")", nToOpen, nToClose - 1);
    }

    private static void printPar(List<String> list) {
        list.forEach(System.out::println);
    }


    public static void main(String[] args) {
        printPar(par(2));
        System.out.println();
        printPar(par(3));
        System.out.println();
        printPar(par(5));
        System.out.println();
    }
}
