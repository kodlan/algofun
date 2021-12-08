package com.sbardyuk.algofun.other;

import java.util.HashMap;
import java.util.Map;

public class CollatzSequence {


    private static int collatzMax(int n) {

        Map<Integer, Integer> cache = new HashMap<>();

        int maxCount = 0;
        for (int i = 1; i <= n; i ++){
            int count = collatz_cached(i, cache);
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }


    private static int collatz_cached(int n, Map<Integer, Integer> cache) {

        int num = n;
        int count = 0;

        while (num > 1) {

            if (cache.containsKey(num)) {
                System.out.println("map heat " + num);
                int finalCount = cache.get(num) + count;
                cache.put(n, finalCount);

                return finalCount;
            }

            num = next(num);
            count ++;
        }

        cache.put(n, count);
        System.out.println("map put " + n + "  = "  + count);

        return count;
    }

    private static int next(int n) {
        if (n % 2 == 1) {
            return 3 * n + 1;
        } else {
            return n / 2;
        }
    }

    private static int collatz_full(int n) {
        int count = 0;

        System.out.println();
        System.out.print(n);

        while (n > 1) {
            if (n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
            System.out.print(" " + n);
            count ++;
        }

        System.out.println();
        return count;
    }


    public static void main(String[] args) {

        System.out.println("---");
        System.out.println(1);
        int count = collatz_full(1);
        System.out.println(count);

        System.out.println("---");
        System.out.println(2);
        count = collatz_full(2);
        System.out.println(count);

        System.out.println("---");
        System.out.println(3);
        count = collatz_full(3);
        System.out.println(count);

        System.out.println("---");
        System.out.println(4);
        count = collatz_full(4);
        System.out.println(count);

        System.out.println("---");
        System.out.println(5);
        count = collatz_full(5);
        System.out.println(count);


        int max = collatzMax(5);
        System.out.println("max = " + max);
    }


}
