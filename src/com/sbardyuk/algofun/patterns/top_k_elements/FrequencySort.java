package com.sbardyuk.algofun.patterns.top_k_elements;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencySort {

    static String fsort(String str) {

        Map<Character, Integer> freq = getF(str);

        List<Character> list = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            list.add(ch);
        }

        list.sort(Comparator.comparingInt(key -> freq.get(Character.toLowerCase((char)key))).reversed());

        return list.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    static Map<Character, Integer> getF(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(Character.toLowerCase(ch), map.getOrDefault(Character.toLowerCase(ch), 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        String res = fsort("Programming");
        System.out.println(res);

        res = fsort("abcbab");
        System.out.println(res);
    }
}
