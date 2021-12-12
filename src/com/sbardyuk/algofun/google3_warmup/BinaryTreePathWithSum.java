package com.sbardyuk.algofun.google3_warmup;

public class BinaryTreePathWithSum {

    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean hasPath(TreeNode root, int targetSum) {
        return hasPath(root, targetSum, 0);
    }

    private static boolean hasPath(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }

        int newSum = currentSum + root.val;

        if (root.left == null && root.right == null && newSum == targetSum) {
            return true;
        }

        return hasPath(root.left, targetSum, newSum) ||
                hasPath(root.right, targetSum, newSum);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + hasPath(root, 23));
        System.out.println("Tree has path: " + hasPath(root, 16));
    }

}
