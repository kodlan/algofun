package com.sbardyuk.algofun.google3_warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private static List<List<Integer>> searchTriplets(int [] array) {

        List<List<Integer>> list = new ArrayList<> ();

        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i ++) {
            if (i > 0 && array[i] != array[i - 1] || i == 0) {
                findPairWithSum(array, -array[i], i + 1, list);
            }
        }

        return list;
    }

    private static void findPairWithSum(int [] array, int targetSum, int leftIndex, List<List<Integer>> triplets) {
        int start = leftIndex;
        int end = array.length - 1;

        while (start < end) {
            int currentSum = array[start] + array[end];

            if (currentSum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, array[start], array[end]));

                start ++;
                end --;

                while (start < end && array[start] == array[start - 1]) start ++;
                while (start < end && array[end] == array[end + 1]) end --;

            } else if (currentSum > targetSum) {
                end --;
            } else {
                start ++;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
