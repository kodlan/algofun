package com.sbardyuk.algofun.arrays;

import java.util.Arrays;

public class MoveAllZerosToBeginning {

    static int [] move(int [] array) {

        int read = array.length - 1;
        int write = array.length - 1;

        while (read >= 0) {

            if (array[read] != 0) {
                array[write] = array[read];
                write --;
                read --;
            } else {
                read --;
            }
        }

        while (write >= 0) {
            array[write] = 0;
            write --;
        }

        return array;
    }

    public static void main(String[] args) {

        int [] res = move(new int [] {1, 10, 20, 0, 59, 63, 0, 88, 0});
        System.out.println(Arrays.toString(res));
    }
}
