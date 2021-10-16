package com.sbardyuk.algofun.other;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    private static char firstNonRepeatingCharLinkedHashMap(String str) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            int count = freqMap.getOrDefault(ch, 0) + 1;
            freqMap.put(ch, count);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                return  entry.getKey();
            }
        }

        return ' ';
    }

    private static char firstNonRepeatingChar(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                return ch;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharLinkedHashMap("GeeksforGeeks"));
        System.out.println(firstNonRepeatingCharLinkedHashMap("GeeksQuiz"));

        System.out.println(firstNonRepeatingChar("GeeksforGeeks"));
        System.out.println(firstNonRepeatingChar("GeeksQuiz"));
    }
}
