package com.sbardyuk.algofun.againagain;

import java.util.HashMap;
import java.util.Map;

public class StringContainsAnyPermut {
    /**
     * Given a string and a pattern, find out if the string contains any permutation of the pattern.
     *
     * Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
     *
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * If a string has ‘n’ distinct characters it will have n!n! permutations.
     *
     * Example 1:
     *
     * Input: String="oidbcaf", Pattern="abc"
     * Output: true
     * Explanation: The string contains "bca" which is a permutation of the given pattern.
     * Example 2:
     *
     * Input: String="odicf", Pattern="dc"
     * Output: false
     * Explanation: No permutation of the pattern is present in the given string as a substring.
     * Example 3:
     *
     * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
     * Output: true
     * Explanation: Both the string and the pattern are a permutation of each other.
     * Example 4:
     *
     * Input: String="aaacb", Pattern="abc"
     * Output: true
     * Explanation: The string contains "acb" which is a permutation of the given pattern.
     */

    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> freq = freq(pattern);

        int windowStart = 0;
        int windowEnd = 0;

        for (; windowEnd < pattern.length(); windowEnd ++) {
            decrementAndRemove(freq, str.charAt(windowEnd));
        }

        if (freq.isEmpty()) {
            return true;
        }

        while (windowEnd < str.length()) {
            decrementAndRemove(freq, str.charAt(windowEnd));
            windowEnd++;

            incrementAndRemove(freq, str.charAt(windowStart));
            windowStart++;

            if (freq.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static void incrementAndRemove(Map<Character, Integer> map, Character ch) {
        addAndRemove(map, ch, +1);
    }

    private static void decrementAndRemove(Map<Character, Integer> map, Character ch) {
        addAndRemove(map, ch, -1);
    }

    private static void addAndRemove(Map<Character, Integer> map, Character ch, int whatToAdd) {
        int count = map.getOrDefault(ch, 0) + whatToAdd;
        if (count == 0) {
            map.remove(ch);
        } else {
            map.put(ch, count);
        }
    }

    private static Map<Character, Integer> freq (String pattern) {
        Map<Character, Integer> f = new HashMap<>();

        for (char ch : pattern.toCharArray()) {
            f.put(ch, f.getOrDefault(ch, 0) + 1);
        }

        return f;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + findPermutation("aaacb", "abc"));
    }
}
