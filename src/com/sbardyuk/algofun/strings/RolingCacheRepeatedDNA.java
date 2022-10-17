package com.sbardyuk.algofun.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Repeated DNA Sequences
 *
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences
 * (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 *
 */
public class RolingCacheRepeatedDNA {

  private static List<String> repeatedSequences(String dna) {

    int start = 0;
    long hash = 0;
    long pow = 1;

    Map<Long, String> sequences = new HashMap<>();
    Map<Long, Integer> freq = new HashMap<>();

    for (int end = 0; end < dna.length(); end ++) {

      if (end - start >= 10) {
        String sub = dna.substring(start, end);

        System.out.println(sub + " = " + hash);

        sequences.put(hash, sub);
        freq.put(hash, freq.getOrDefault(hash, 0) + 1);


        hash = (hash - dna.charAt(start)) / 31 + dna.charAt(end) * pow / 31;
        start ++;
      } else {
        hash += dna.charAt(end) * pow;
        pow *= 31;
      }
    }

    List<String> res = new ArrayList<>();
    for (Map.Entry<Long, Integer> entry : freq.entrySet()) {
      if (entry.getValue() > 1) {
        res.add(sequences.get(entry.getKey()));
      }
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(repeatedSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    System.out.println(repeatedSequences("AAAAAAAAAAAAA"));
  }

}
