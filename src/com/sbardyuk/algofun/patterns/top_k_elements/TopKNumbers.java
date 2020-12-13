package com.sbardyuk.algofun.patterns.top_k_elements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKNumbers {

    static List<Integer> findTopNNumbers(int [] array, int k) {

        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minQ.add(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if (array[i] > minQ.peek()) {
                minQ.poll();
                minQ.add(array[i]);
            }
        }

        return new ArrayList<>(minQ);
    }

    public static void main(String[] args) {
        List<Integer> res = findTopNNumbers(new int[] {1, 5, 12, 2, 11, 5}, 3);
        System.out.println(res);

        res = findTopNNumbers(new int[] {3, 1, 5, 12, 2, 11}, 3);
        System.out.println(res);
    }

}
