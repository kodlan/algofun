package com.sbardyuk.algofun.other;

import java.util.HashMap;
import java.util.Map;

public class RansomNoteOneHashMap {

    private static boolean canConstructNote(String noteToCostract, String fullText) {
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : noteToCostract.split("\\s")) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 0);
            }
        }

        for (String word : fullText.split("\\s")) {
            if (wordMap.containsKey(word)) {
                int count = wordMap.get(word) - 1;
                if (count > 0) {
                    wordMap.put(word, count);
                } else {
                    wordMap.remove(word);
                }
            }
        }

        return wordMap.isEmpty();
    }


    public static void main(String[] args) {
        String fullText = "This handy tool helps you create dummy text for all your layout needs.\n" +
                "We are gradually adding new functionality and we welcome your suggestions and feedback.\n" +
                "Please feel free to send us any additional dummy texts.";

        System.out.println(canConstructNote("free new text", fullText));
        System.out.println(canConstructNote("impossible text", fullText));
        System.out.println(canConstructNote("welcome Please feel free to", fullText));
    }
}
