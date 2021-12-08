package com.sbardyuk.algofun.google3_warmup;

import java.util.HashMap;
import java.util.Map;

public class StringPermutations {

    private static boolean findPermutation(String str, String perm) {
        Map<Character, Integer> freq = getFreq(perm);

        int start = 0;

        for (int end = 0; end < str.length(); end ++) {

            if (end - start == perm.length()) {
                addAndRemove(freq, str.charAt(start));
                start ++;
            }

            decAndRemove(freq, str.charAt(end));

            if (freq.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    private static void decAndRemove(Map<Character, Integer> map, Character ch) {
        int count = map.getOrDefault(ch, 0) - 1;
        if (count == 0) {
            map.remove(ch);
        } else {
            map.put(ch, count);
        }
    }

    private static void addAndRemove(Map<Character, Integer> map, Character ch) {
        int count = map.getOrDefault(ch, 0) + 1;
        if (count == 0) {
            map.remove(ch);
        } else {
            map.put(ch, count);
        }
    }

    private static Map<Character, Integer> getFreq(String str) {
        Map<Character, Integer> f = new HashMap<>();
        for (char ch : str.toCharArray()) {
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
