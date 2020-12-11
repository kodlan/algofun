package com.sbardyuk.algofun.patterns.subsets;

import javax.security.auth.callback.CallbackHandler;
import java.util.ArrayList;
import java.util.List;

public class StringPermutationsChanginCase {


    static List<StringBuilder> permutLetter(String str) {
        List<StringBuilder> res = new ArrayList<>();
        res.add(new StringBuilder());

        for (char ch : str.toCharArray()) {

            List<StringBuilder> toAdd = new ArrayList<>();

            for (StringBuilder sb : res) {
                if (Character.isLetter(ch)) {
                    StringBuilder newSb = new StringBuilder(sb);

                    sb.append(Character.toLowerCase(ch));

                    newSb.append(Character.toUpperCase(ch));
                    toAdd.add(newSb);
                } else {
                    sb.append(ch);
                }
            }

            res.addAll(toAdd);
        }

        return res;
    }


    public static void main(String[] args) {

        List<StringBuilder> res = permutLetter("af52");
        System.out.println(res);

        res = permutLetter("ab7c");
        System.out.println(res);
    }
}
