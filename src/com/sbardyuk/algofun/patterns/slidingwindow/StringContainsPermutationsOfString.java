package com.sbardyuk.algofun.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringContainsPermutationsOfString {

    public static boolean detectPermutation(String str, String pattern) {
        int patternSize = pattern.length();
        Map<Character, Integer> patternMap = getFrequencyMap(pattern, 0, patternSize);
        Map<Character, Integer> windowMap = getFrequencyMap(str, 0, patternSize);

        for (int windowStart = 0; windowStart <= str.length() - pattern.length();) {
            System.out.println(str.substring(windowStart, windowStart + patternSize));

            if (compareMaps(patternMap, windowMap)) {
                System.out.println("res = " + str.substring(windowStart, windowStart + patternSize));
                return true;
            }

            decFreq(windowMap, str.charAt(windowStart));
            windowStart ++;
            if (windowStart + patternSize - 1 < str.length()) {
                incFreq(windowMap, str.charAt(windowStart + patternSize - 1));
            }
        }

        return false;
    }

    private static void decFreq(Map<Character, Integer> map, char ch) {
        map.put(ch, map.getOrDefault(ch, 0) - 1);
        if (map.get(ch) <= 0) {
            map.remove(ch);
        }
    }

    private static void incFreq(Map<Character, Integer> map, char ch) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    private static boolean compareMaps(Map<Character, Integer> patterMap, Map<Character, Integer> windowMap) {
        Set<Character> patternSet = patterMap.keySet();
        Set<Character> windowSet = windowMap.keySet();
        if (patternSet.containsAll(windowSet) && windowSet.containsAll(patternSet)) {
            for (char ch : windowSet) {
                int fr1 = windowMap.get(ch);
                int fr2 = patterMap.get(ch);
                if (fr1 != fr2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static Map<Character, Integer> getFrequencyMap(String str, int start, int end) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = start; i < end; i ++) {
            char ch = str.charAt(i);
            incFreq(map, ch);
        }

        return map;
    }

    public static void main(String[] args) {
        System.out.println("\noidbcaf  abc - >");
        System.out.println("Permutation exist: " + detectPermutation("oidbcaf", "abc"));

        System.out.println("\nodicf  dc - >");
        System.out.println("Permutation exist: " + detectPermutation("odicf", "dc"));

        System.out.println("\nbcdxabcdy  bcdyabcdx - >");
        System.out.println("Permutation exist: " + detectPermutation("bcdxabcdy", "bcdyabcdx"));

        System.out.println("\naaacb   abc - >");
        System.out.println("Permutation exist: " + detectPermutation("aaacb", "abc"));
    }
}
