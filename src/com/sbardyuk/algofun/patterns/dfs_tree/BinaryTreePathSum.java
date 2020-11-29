package com.sbardyuk.algofun.patterns.dfs_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a number ‘S’, find if the
 *
 * tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
 */
public class BinaryTreePathSum {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<Integer> findPath(TreeNode node, int sum) {
        List<Integer> res = new ArrayList<>();

        findPathInternal(node, sum, 0, res);

        return res;
    }

    private static boolean findPathInternal(TreeNode node, int targetSum, int currentSum, List<Integer> path) {

        if (node == null) {
            return targetSum == currentSum;
        }

        boolean shouldIncludeInPath = findPathInternal(node.left, targetSum, currentSum + node.value, path) |
                findPathInternal(node.right, targetSum, currentSum + node.value, path);

        if (shouldIncludeInPath) {
            path.add(node.value);
        }

        return shouldIncludeInPath;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);


        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);

        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        List<Integer> result = findPath(root, 22);

        System.out.println(result);

    }

}
