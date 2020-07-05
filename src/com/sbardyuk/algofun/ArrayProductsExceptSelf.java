package com.sbardyuk.algofun;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayProductsExceptSelf {

    private static int[] findProduct(int[] arr) {
        int all = 1;
        int count0 = 0; // count of 0 values in array
        // if count > 1 all the result values are 0
        // if count == 1 all the result values are 0 except the one where 0 is located
        // 4 2 1 5 0 -> 0 0 0 0 40

        for (int val : arr) {
            if (val != 0) {
                all *= val;
            } else {
                count0++;
            }
        }

        if (count0 > 1) {
            // arrays of zeros
            return IntStream.generate(() -> 0).limit(arr.length).toArray();
        }

        if (count0 == 1) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] == 0 ? all : 0;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = all / arr[i];
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] res = findProduct(new int[] {1, 2, 3, 4});
        System.out.println(Arrays.toString(res));

        res = findProduct(new int[] {4, 2, 1, 5, 0});
        System.out.println(Arrays.toString(res));

        res = findProduct(new int[] {4, 2, 0, 5, 0});
        System.out.println(Arrays.toString(res));

        res = findProduct(new int[] {-1, 2, -3, 4, -5});
        System.out.println(Arrays.toString(res));
    }
}
