package com.sbardyuk.algofun.patterns.mergeintervals;

import java.util.*;

/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
 */
public class MinimumMeetingRooms extends MergeIntervals {

    public static int findMinimumMeetingRooms(List<Interval> meetings) {

        if (meetings == null || meetings.size() == 0)
            return 0;

        // sort the meetings by start time
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        int minRooms = 0;
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
        for (Interval meeting : meetings) {
            // remove all meetings that have ended
            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            // add the current meeting into the minHeap
            minHeap.offer(meeting);
            // all active meeting are in the minHeap, so we need rooms for all of them.
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }


    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>() {
            {
                add(new Interval(4, 5));
                add(new Interval(2, 3));
                add(new Interval(2, 4));
                add(new Interval(3, 5));
            }
        };

        printIntervals(input);
        System.out.println();

        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

    }

}
