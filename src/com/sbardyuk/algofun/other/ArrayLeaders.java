package com.sbardyuk.algofun.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to print all the LEADERS in the array.
 * An element is leader if it is greater than all the elements to its right side.
 * And the rightmost element is always a leader.
 *
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 */
public class ArrayLeaders {

    private static List<Integer> leaders(int [] nums) {
        List<Integer> res = new ArrayList<>();

        int max = nums[nums.length - 1];
        res.add(max);

        for (int i = nums.length - 2; i >= 0; i --) {
            int current = nums[i];

            if (max < current) {
                max = current;
                res.add(max);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> leaders = leaders(new int[] {16, 17, 4, 3, 5, 2});

        System.out.println(leaders);

    }
}
