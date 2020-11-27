package com.sbardyuk.algofun.patterns.twopointers;

public class CycleCircularArray {

    public static boolean hasCycle(int [] array) {

        // skipping the case when 0,0,0,...

        for (int i = 0; i < array.length; i++) {
            if (hasCycleFromIndex(array, i)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasCycleFromIndex(int [] array, int i) {
        int slow = getNextPosition(array, i);
        int fast = getNextPosition(array, slow);

        int directionSlow = array[i] >= 0 ? 1 : -1;
        int directionFast = array[getNextPosition(array, i)] >= 0 ? 1 : -1;

        do {
            slow = getNextPosition(array, slow);
            fast = getNextPosition(array, getNextPosition(array, fast));

            int newDirectionSlow = array[slow] >= 0 ? 1 : -1;
            int newDirectionFast = array[fast] >= 0 ? 1 : -1;

            if (slow == fast) {
                return true;
            }

            if (directionSlow != newDirectionSlow || directionFast != newDirectionFast) {
                return false;
            }

        } while (true);


    }

    private static int getNextPosition(int [] array, int i) {
        return getNextCircularIndex(array.length, i, array[i]);
    }

    private static int getNextCircularIndex(int n, int i, int inc) {
        return (i + inc) % n;
    }

    public static void main(String[] args) {
        System.out.println(hasCycle(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(hasCycle(new int[] { 2, 2, -1, 2 }));
        System.out.println(hasCycle(new int[] { 2, 1, -1, -2 }));
    }

}
