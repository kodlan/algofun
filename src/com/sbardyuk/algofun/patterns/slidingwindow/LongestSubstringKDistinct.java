package com.sbardyuk.algofun.patterns.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {

        Map<Character, Integer> chars = new HashMap<>();

        int windowStart = 0;
        int longestArray = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd ++) {

            addChar(str, chars, windowEnd);

            while (chars.size() > k) {
                removeChar(str, chars, windowStart);
                windowStart ++;
            }
            longestArray = Math.max(longestArray, windowEnd - windowStart + 1);
        }

        return longestArray;
    }

    private static void addChar(String str, Map<Character, Integer> chars, int windowEnd) {
        char ch = str.charAt(windowEnd);
        int count = chars.getOrDefault(ch, 0);
        chars.put(ch, count + 1);
    }

    private static void removeChar(String str, Map<Character, Integer> chars, int windowStart) {
        char ch = str.charAt(windowStart);
        int count = chars.get(ch) - 1;
        if (count > 0) {
            chars.put(ch, count);
        } else {
            chars.remove(ch);
        }
    }


    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
    }
}
