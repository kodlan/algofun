package com.sbardyuk.algofun.recursion;

import java.util.Arrays;

public class FindPathInArray {

    private static int n = 4;

    private static int[][] a = {
            {1, 1, 0, 1},
            {1, 0, 1, 0},
            {1, 1, 1, 0},
            {0, 0, 1, 1}
    };

    private static int[][] path = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };

    private static boolean findPath(int i, int j) {

        if (i == n-1 && j == n-1) {
            path[i][j] = 1;
            return true;
        }

        if (a[i][j] == 1) {
            path [i][j] = 1;

            if (findPath(i, j + 1) || findPath(i + 1, j)) {
                return true;
            } else {
                path [i][j] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        findPath(0, 0);

        System.out.println(Arrays.deepToString(path));

    }

}
