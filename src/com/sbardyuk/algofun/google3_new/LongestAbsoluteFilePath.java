package com.sbardyuk.algofun.google3_new;

import java.util.Stack;

/**
 * Leetcode 388.
 * Suppose we have a file system that stores both files and directories. An example of one system is represented in the following picture:
 *
 *
 *
 * Here, we have dir as the only directory in the root. dir contains two subdirectories, subdir1 and subdir2. subdir1 contains a file file1.ext and subdirectory subsubdir1. subdir2 contains a subdirectory subsubdir2, which contains a file file2.ext.
 *
 * In text form, it looks like this (with ⟶ representing the tab character):
 *
 * dir
 * ⟶ subdir1
 * ⟶ ⟶ file1.ext
 * ⟶ ⟶ subsubdir1
 * ⟶ subdir2
 * ⟶ ⟶ subsubdir2
 * ⟶ ⟶ ⟶ file2.ext
 * If we were to write this representation in code, it will look like this: "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext". Note that the '\n' and '\t' are the new-line and tab characters.
 *
 * Every file and directory has a unique absolute path in the file system, which is the order of directories that must be opened to reach the file/directory itself, all concatenated by '/'s. Using the above example, the absolute path to file2.ext is "dir/subdir2/subsubdir2/file2.ext". Each directory name consists of letters, digits, and/or spaces. Each file name is of the form name.extension, where name and extension consist of letters, digits, and/or spaces.
 *
 * Given a string input representing the file system in the explained format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.
 *
 */
public class LongestAbsoluteFilePath {

    int maxLength = 0;
    int currentLength = 0;

    Stack<String> folderStack = new Stack<>();

    public int lengthLongestPath(String input) {

        for(String line : input.split("\\n")) {

            int nextLevel = getLevel(line);
            String name = getNameWithoutTabulation(line, nextLevel);

            while (nextLevel < folderStack.size()) {
                popFolder();
            }

            if (isFile(name)) {
                checkFile(name);
            } else {
                pushFolder(name);
            }
        }

        return maxLength;
    }

    private void pushFolder(String name) {
        folderStack.push(name);
        currentLength += name.length() + 1;
    }

    private void popFolder() {
        currentLength = currentLength - folderStack.pop().length() - 1;
    }

    private void checkFile(String name) {
        int fileLength = currentLength + name.length();
        maxLength = Math.max(fileLength, maxLength);
    }

    private int getLevel(String line) {
        int i = 0;
        while (i < line.length() && line.charAt(i) == '\t') i++;
        return i;
    }

    private String getNameWithoutTabulation(String line, int level) {
        return line.substring(level);
    }

    private boolean isFile(String fileName) {
        return fileName.contains(".");
    }

    public static void main(String[] args) {
        System.out.println(new LongestAbsoluteFilePath()
                .lengthLongestPath("a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
    }
}