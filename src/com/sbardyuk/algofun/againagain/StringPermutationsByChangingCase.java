package com.sbardyuk.algofun.againagain;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 *
 * Example 1:
 *
 * Input: "ad52"
 * Output: "ad52", "Ad52", "aD52", "AD52"
 * Example 2:
 *
 * Input: "ab7c"
 * Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */
public class StringPermutationsByChangingCase {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();

        permutations.add("");

        for (char ch : str.toCharArray()) {

            List<String> newList = new ArrayList<>();

            for (String s : permutations) {

                if (Character.isLetter(ch)) {
                    newList.add(s + Character.toLowerCase(ch));
                    newList.add(s + Character.toUpperCase(ch));
                } else {
                    newList.add(s + ch);
                }

            }

            permutations = newList;

        }

        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
