package com.sbardyuk.algofun.google3_new;

import java.util.TreeSet;

public class KEmptySlots {

    // Insert into sorted structure - TreeSet
    private static int slots(int [] bulbs, int k) {

        TreeSet<Integer> activeBulbs = new TreeSet<> ();

        for (int day = 0; day < bulbs.length; day ++) {
            int bulb = bulbs[day];

            activeBulbs.add(bulb);

            if (activeBulbs.size() > 1) {
                Integer lower = activeBulbs.lower(bulb);
                Integer higher = activeBulbs.higher(bulb);

                if (lower != null && bulb - lower - 1 == k) return day + 1;
                if (higher != null && higher - bulb - 1 == k) return day + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println("Number of days = " + slots(new int [] {1, 3, 2}, 1));

    }
}
