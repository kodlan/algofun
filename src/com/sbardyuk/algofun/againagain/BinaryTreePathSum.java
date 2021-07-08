package com.sbardyuk.algofun.againagain;

/**
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
 */
public class BinaryTreePathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    public static boolean hasPathRecursive(TreeNode root, int sum) {
        return hasPathRecursiveInternal(root, sum, 0);
    }

    private static boolean hasPathRecursiveInternal(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return targetSum == currentSum;
        }

        return hasPathRecursiveInternal(node.left, targetSum, currentSum + node.val)
                || hasPathRecursiveInternal(node.right, targetSum, currentSum + node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path: " + hasPathRecursive(root, 23));
        System.out.println("Tree has path: " + hasPathRecursive(root, 16));
    }
}
