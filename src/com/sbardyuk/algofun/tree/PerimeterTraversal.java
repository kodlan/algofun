package com.sbardyuk.algofun.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print perimeter of the tree
 */
public class PerimeterTraversal {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static void p(TreeNode root) {

        t(root, false, false, false);
    }

    static void t(TreeNode root, boolean hasParent, boolean fromLeft, boolean fromRight) {
        if (root.right == null && root.left == null) {
            System.out.println(root.value);
        }

        if (root.left != null) {
            fromLeft = hasParent ? fromLeft : true;

            if (fromLeft) {
                System.out.println(root.value);
            }
            t(root.left, true, fromLeft, false);
        }
        if (root.right != null) {
            fromRight = hasParent ? fromRight : true;
            t(root.right, true, fromLeft, fromRight);
            if (fromRight && hasParent) {
                System.out.println(root.value);
            }
        }
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
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(200);

        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(60);

        root.left.left.left = new TreeNode(10);

        root.left.right.right = new TreeNode(70);

        root.right.right = new TreeNode(350);
        root.right.right.right = new TreeNode(400);

        printTree(root);
        p(root);
    }
}
