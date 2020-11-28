package com.sbardyuk.algofun.patterns.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.
 */
public class IntervalIntersection extends MergeIntervals{

    public static List<Interval> merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {

            Interval int1 = arr1[i];
            Interval int2 = arr2[j];

            if ((int1.start >= int2.start && int1.start <= int2.end)
                    || (int2.start >= int1.start && int2.start <= int1.end)) {

                result.add(new Interval(Math.max(int1.start, int2.start), Math.min(int1.end, int2.end)));
            }

            if (int1.end < int2.end) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };

        printIntervals(Arrays.asList(input1));
        System.out.println();
        printIntervals(Arrays.asList(input2));
        System.out.println();
        System.out.print("Intervals Intersection: ");
        printIntervals(merge(input1, input2));
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        printIntervals(Arrays.asList(input1));
        System.out.println();
        printIntervals(Arrays.asList(input2));
        System.out.println();
        System.out.print("Intervals Intersection: ");
        printIntervals(merge(input1, input2));
    }
}
