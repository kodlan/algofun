package com.sbardyuk.algofun.patterns.mergeintervals;

import java.util.*;

public class MergeIntervals {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.end));

        Iterator<Interval> iter = intervals.listIterator();

        Interval i = iter.next();

        while(iter.hasNext()) {
            Interval j = iter.next();

            if (j.start <= i.end) {
                // modify first interval to include second one
                i.end = Math.max(i.end, j.end);
                // remove second interval
                iter.remove();
            }

            i = j;
        }

        return intervals;
    }


    public static void printIntervals(List<Interval> intervals ) {
        for (Interval interval : intervals) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
    }

    public static void main(String[] args) {

        // Note: Arrays.asList returns a list that can't be modified
        List<Interval> intervalList = new ArrayList<> (Arrays.asList(new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)));

        printIntervals(intervalList);
        System.out.print(" -> ");
        printIntervals(mergeIntervals(intervalList));
        System.out.println();

        List<Interval> intervalList1 = new ArrayList<> (Arrays.asList(new Interval(6, 7), new Interval(2, 4), new Interval(5, 9)));

        printIntervals(intervalList1);
        System.out.print(" -> ");
        printIntervals(mergeIntervals(intervalList1));
        System.out.println();


        List<Interval> intervalList2 = new ArrayList<> (Arrays.asList(new Interval(1, 4), new Interval(2, 6), new Interval(3, 5)));

        printIntervals(intervalList);
        System.out.print(" -> ");
        printIntervals(mergeIntervals(intervalList));
        System.out.println();

    }
}
