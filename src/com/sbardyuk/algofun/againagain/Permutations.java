package com.sbardyuk.algofun.againagain;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct numbers, find all of its permutations.
 *
 * Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3}
 * has the following six permutations:
 *
 * {1, 2, 3}
 * {1, 3, 2}
 * {2, 1, 3}
 * {2, 3, 1}
 * {3, 1, 2}
 * {3, 2, 1}
 * If a set has ‘n’ distinct elements it will have n!n! permutations.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 */
public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (int num : nums) {

            List<List<Integer>> newRes = new ArrayList<>();

            for (List<Integer> list : result) {

                for (int i = 0; i < list.size() + 1; i ++) {
                    List<Integer> copy = new ArrayList<>(list);
                    copy.add(i, num);
                    newRes.add(copy);
                }

            }

            result = newRes;
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }

}
