package com.sbardyuk.algofun.other;

import java.util.*;

/**
 * Given a list of words with lower cases. Implement a function to find all Words that have the same unique character set .
 *
 * Input: words[] = { "may", "student", "students", "dog",
 *                  "studentssess", "god", "cat", "act",
 *                  "tab", "bat", "flow", "wolf", "lambs",
 *                  "amy", "yam", "balms", "looped",
 *                  "poodle"};
 * Output :
 * looped, poodle,
 * lambs, balms,
 * flow, wolf,
 * tab, bat,
 * may, amy, yam,
 * student, students, studentssess,
 * dog, god,
 * cat, act,
 *
 */
public class GroupAllWordsWithSameCharacterSet {

    private static Map<String, List<String>> words(String [] words) {

        Map<String, List<String>> keyToWord = new HashMap<>();

        for (String word : words) {
            String key = getWordHash(word);

            if (!keyToWord.containsKey(key)) {
                keyToWord.put(key, new ArrayList<>());
            }
            keyToWord.get(key).add(word);
        }

        return keyToWord;
    }

    private static String getWordHash(String word) {
        Set<Character> characters = new TreeSet<>();
        for (char ch : word.toCharArray()) {
            characters.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : characters) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String words[] = { "may", "student", "students", "dog",
                "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs",
                "amy", "yam", "balms", "looped",
                "poodle"};

        Map<String, List<String>> map = words(words);

        for (String key : map.keySet()) {
            System.out.println();
            System.out.print(key + " : ");

            for (String w : map.get(key)) {
                System.out.print(w + " ");
            }
        }
    }
}
