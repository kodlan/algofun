package com.sbardyuk.algofun.other;

/**
 * Problem Statement: Given a set of strings, find the longest common prefix.
 * Examples:
 *
 *
 * Input: {"geeksforgeeks", "geeks", "geek", "geezer"}
 * Output: "gee"
 *
 * Input: {"apple", "ape", "april"}
 * Output: "ap"
 */
public class LongestCommonPrefix {

    private static String commonPrefix(String [] input) {

        int min = minLen(input);

        for (int charIndex = 0; charIndex < min; charIndex ++) {
            char current = input[0].charAt(charIndex);

            for (int word = 1; word < input.length; word ++) {
                if (input[word].charAt(charIndex) != current) {
                    return input[0].substring(0, charIndex);
                }
            }
        }

        return "";
    }

    private static int minLen(String [] input) {
        int min = Integer.MAX_VALUE;
        for (String str : input) {
            if (str.length() < min) {
                min = str.length();
            }
        }
        return min;
    }

    public static void main(String[] args) {

        String pref = commonPrefix(new String[] {"geeksforgeeks", "geeks", "geek", "geezer"});
        System.out.println(pref);

        pref = commonPrefix(new String [] {"apple", "ape", "april"});
        System.out.println(pref);
    }
}
