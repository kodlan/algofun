package com.sbardyuk.algofun.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripleSumZero {

    public static List<List<Integer>> searchTriplets(int arr[]) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i ++) {

            int x = - arr[i];

            int pointerStart = 0;
            int pointerEnd = arr.length - 1;

            while (pointerStart <= pointerEnd) {
                int sum = arr[pointerStart] + arr[pointerEnd];

                if (sum == x) {
                    if (i != pointerStart && i != pointerEnd) {
                        // TODO remove duplicates
                        res.add(Arrays.asList(arr[i], arr[pointerStart], arr[pointerEnd]));
                    }
                    pointerStart ++;
                    pointerEnd --;
                }

                if (sum > x) {
                    pointerEnd --;
                } else if (sum < x) {
                    pointerStart ++;
                }
            }

        }

        return res;
    }

    private static void print (List<List<Integer>> list) {
        for (List<Integer> l : list) {
            System.out.print("\n[ ");
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println(" ]");
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = searchTriplets(new int[] {-3, 0, 1, 2, -1, 1, -2});
        print(res);
    }
}
