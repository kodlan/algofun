package com.sbardyuk.algofun.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteZeroSumSubTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static void delete0(TreeNode root) {
        d0(root);
    }

    private static int d0(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = d0(root.left);
        int right = d0(root.right);

        if (left == 0) root.left = null;
        if (right == 0) root.right = null;

        return left + right + root.value;
    }

    static void printTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        System.out.println(root.value + " ");

        while (!q.isEmpty()) {

            Queue<TreeNode> nextLevelQ = new LinkedList<>();

            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left != null) nextLevelQ.add(node.left);
                if (node.right != null) nextLevelQ.add(node.right);
            }

            for (TreeNode node : nextLevelQ) {
                System.out.print(node.value + " ");
            }
            System.out.println();

            q.addAll(nextLevelQ);
        }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(-3);
        root.left.right = new TreeNode(-2);

        printTree(root);

        delete0(root);

        printTree(root);

    }
}
