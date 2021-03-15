package com.sbardyuk.algofun.dynamicprogramming;

public class Fibonacci {

    private static int fibRec(int n) {
        if (n < 2) {
            return n;
        }

        return fibRec(n - 1) + fibRec(n - 2);
    }

    private static int fibMemo(int n) {

        int [] memo = new int [n+1];

        return fibMemoRec(memo, n);
    }

    private static int fibMemoRec(int [] memo, int n) {
        if (n < 2) {
            return n;
        }

        if (memo[n] != 0) {
            System.out.println("\tBingo - memo[" + n + "] = " + memo[n]);
            return memo[n];
        }

        int fib = fibMemoRec(memo, n - 1) + fibMemoRec(memo, n - 2);
        memo[n] = fib;
        return fib;
    }

    private static int fibTabulation(int n) {
        int [] tab = new int [n+1];

        tab [0] = 0;
        tab [1] = 1;

        for (int i = 2; i <= n; i ++) {
            tab [i] = tab[i - 1] + tab[i - 2];
        }

        return tab [n];
    }

    private static int fibTabulationMinMemory(int n) {
        int [] tab = new int [3];

        tab [0] = 0;
        tab [1] = 1;

        int next = 1;

        for (int i = 2; i <= n; i ++) {
            next ++;
            if (next > 2) next = 0;

            tab[next] = 0;
            if (next != 0) tab [next] += tab[0];
            if (next != 1) tab [next] += tab[1];
            if (next != 2) tab [next] += tab[2];
        }

        return tab [next];
    }


    public static void main(String[] args) {

        System.out.println(fibRec(3));
        System.out.println(fibRec(4));
        System.out.println(fibRec(5));
        System.out.println(fibRec(10));

        System.out.println("--------");

        System.out.println(fibMemo(3));
        System.out.println(fibMemo(4));
        System.out.println(fibMemo(5));
        System.out.println(fibMemo(10));

        System.out.println("--------");

        System.out.println(fibTabulation(3));
        System.out.println(fibTabulation(4));
        System.out.println(fibTabulation(5));
        System.out.println(fibTabulation(10));

        System.out.println("--------");

        System.out.println(fibTabulationMinMemory(3));
        System.out.println(fibTabulationMinMemory(4));
        System.out.println(fibTabulationMinMemory(5));
        System.out.println(fibTabulationMinMemory(10));
    }
}
