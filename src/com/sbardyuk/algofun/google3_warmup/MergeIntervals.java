package com.sbardyuk.algofun.google3_warmup;

import java.util.*;

public class MergeIntervals {

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static List<Interval> merge(List<Interval> input) {
        List<Interval> res = new ArrayList<>();

        input.sort(Comparator.comparingInt(a -> a.start));

        Iterator<Interval> iter = input.iterator();
        Interval current = iter.next();

        while (iter.hasNext()) {
            Interval next = iter.next();

            if (current.end < next.start) {
                res.add(current);
                current = next;
            } else {
                current = new Interval(current.start, Math.max(current.end, next.end));
            }
        }

        if (current != null) {
            res.add(current);
        }

        return res;
    }


    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
