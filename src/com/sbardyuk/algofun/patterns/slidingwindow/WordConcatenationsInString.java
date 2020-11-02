package com.sbardyuk.algofun.patterns.slidingwindow;

import java.util.*;

public class WordConcatenationsInString {


    public static List<Integer> findConcatenations (String str, String[] words) {
        List<Integer> resIndexList = new ArrayList<>();

        int wordLen = words[0].length();
        int wordsLen = wordLen * words.length;

        for (int windowStart = 0; windowStart <= str.length() - wordsLen; windowStart ++) {

            Map<String, Integer> wordMap = initWordMap(words);

            // go through all the key and if chars match ++ the value
            int counter = 0;
            for(int i = windowStart; i < windowStart + wordsLen; i++) {

                for (String key : wordMap.keySet()) {
                    if (key.charAt(counter) == str.charAt(i)) {
                        wordMap.put(key, wordMap.get(key) + 1);
                    }
                }

                counter ++;
                if (counter >= wordLen) {
                    counter = 0;
                }
            }

            if(checkWordMap(wordMap, wordLen)) {
                resIndexList.add(windowStart);
            }
        }

        return resIndexList;
    }

    private static Map<String, Integer> initWordMap(String [] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, 0);
        }
        return map;
    }

    private static boolean checkWordMap(Map<String, Integer> wordMap, int wordLen) {
        // if all the keys have values == wordlen it means all the words were used in this part of the string

        for (String key : wordMap.keySet()) {
            Integer value = wordMap.get(key);
            if (value != wordLen) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        List<Integer> res = findConcatenations("catfoxcat", new String[] {"cat", "fox"});
        System.out.println(Arrays.toString(res.toArray()));

        res = findConcatenations("catcatfoxfox", new String[] {"cat", "fox"});
        System.out.println(Arrays.toString(res.toArray()));


    }
}
