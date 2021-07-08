package com.sbardyuk.algofun.againagain;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
 * Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).
 */
public class CountPathsForSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int countPaths(TreeNode root, int s) {
        return countRec(root, s, new LinkedList<>());
    }

    private static int countRec(TreeNode node, int targetSum, List<Integer> currentPath) {
        if (node == null) {
            return 0;
        }

        currentPath.add(node.val);

        int pathCount = 0;
        int pathSum = 0;

        ListIterator<Integer> iter = currentPath.listIterator(currentPath.size());
        while (iter.hasPrevious()) {
            pathSum += iter.previous();
            if (pathSum == targetSum) {
                pathCount ++;
            }
        }

        pathCount += countRec(node.left, targetSum, currentPath);
        pathCount += countRec(node.right, targetSum, currentPath);

        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + countPaths(root, 11));
    }
}
