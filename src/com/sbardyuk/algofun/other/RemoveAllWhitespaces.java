package com.sbardyuk.algofun.other;

public class RemoveAllWhitespaces {

    static String remove(String string) {

        char [] chars = string.toCharArray();

        int read = 0;
        int write = 0;

        while (chars[write] != ' ') {
            write ++;
        }
        read = write + 1;

        while (read < chars.length && write < chars.length) {

            if (chars[read] != ' ') {
                chars[write] = chars[read];
                write ++;
            }

            read ++;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String res = remove("this Is A Test String");
        System.out.println(res);
    }
}
