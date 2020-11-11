package com.sbardyuk.algofun.patterns.twopointers;

public class CompareStringsWithBackspaces
{

    public static boolean compareStrings(String str1, String str2) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;

        while (i >= 0 && j >= 0) {

            i = removeBackspace(str1, i);
            j = removeBackspace(str2, j);

            System.out.println(str1.charAt(i) + " == " + str2.charAt(j));

            if (str1.charAt(i) != str2.charAt(j)) {
                return false;
            }

            i --;
            j --;
        }

        return i == -1 && j == -1;
    }

    private static int removeBackspace(String str, int i) {
        if (str.charAt(i) == '#') {
            int x = i;
            int c = 0;

            while (x >= 0 && str.charAt(x) == '#') {
                x--;
                c++;
            }
            i = Math.max((i - c * 2), 0);
        }
        return i;
    }


    public static void main(String[] args) {

        System.out.println(compareStrings("xy#z", "xzz#"));
        System.out.println(compareStrings("xy#z", "xyz#"));
        System.out.println(compareStrings("xp#", "xyz##"));
        System.out.println(compareStrings("xywrrmp", "xywrrmu#p"));
        System.out.println(compareStrings("####xywrrmp", "###xywrrmu#p"));

    }

}
