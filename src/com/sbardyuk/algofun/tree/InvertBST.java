package com.sbardyuk.algofun.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBST {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static void invert(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {

            Queue<TreeNode> nextLevelQ = new LinkedList<>();

            while (!q.isEmpty()) {
                TreeNode node = q.poll();

                TreeNode left = node.left;
                TreeNode right = node.right;

                node.left = right;
                node.right = left;

                if (left != null) nextLevelQ.add(left);
                if (right != null) nextLevelQ.add(right);

            }

            q.addAll(nextLevelQ);
        }
    }

    static void print(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        System.out.println(root.value);

        while (!q.isEmpty()) {

            Queue<TreeNode> nextLevelQ = new LinkedList<>();

            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left != null) nextLevelQ.add(node.left);
                if (node.right != null) nextLevelQ.add(node.right);
            }

            for (TreeNode node : nextLevelQ) {
                System.out.print(node.value);
            }
            System.out.println();

            q.addAll(nextLevelQ);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        print(root);
        invert(root);
        print(root);

    }
}
