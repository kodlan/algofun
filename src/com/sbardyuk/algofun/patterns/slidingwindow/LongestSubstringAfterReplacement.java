package com.sbardyuk.algofun.patterns.slidingwindow;

public class LongestSubstringAfterReplacement {

    public static int findLength(String str, int k) {

        int windowStart = 0;
        int windowEnd = 0;
        int wrongCharCount = 0;
        int roolbackPointer = 0;
        char currentChar = str.charAt(0);
        int maxLength = 0;

        while (windowStart < str.length() - 1 && windowEnd < str.length() - 1) {

            if (currentChar == str.charAt(windowEnd) || (wrongCharCount != 0 && wrongCharCount < k)) {
                if (windowEnd < str.length() - 1) {
                    windowEnd ++;
                }
            } else {
                if (wrongCharCount == 0) {
                    roolbackPointer = windowEnd;
                }

                if (wrongCharCount < k) {
                    wrongCharCount ++;
                    windowEnd ++;
                } else {
                    maxLength = Math.max(maxLength, windowEnd - windowStart);

                    // reset
                    windowStart = roolbackPointer;
                    windowEnd = roolbackPointer;
                    currentChar = str.charAt(windowStart);
                    wrongCharCount = 0;

                }
            }
         }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }
}
