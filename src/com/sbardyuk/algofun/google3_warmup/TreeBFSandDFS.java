package com.sbardyuk.algofun.google3_warmup;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeBFSandDFS {

    private static class TreeNode {
        int val;
        TreeNode left, right;
        
        public TreeNode(int value) {
            this.val = value;
        }
    }

    private static void treePreDFS(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " -> ");

            treePreDFS(node.left);
            treePreDFS(node.right);
        }
    }

    private static void treePostDFS(TreeNode node) {
        if (node != null) {
            treePostDFS(node.left);
            treePostDFS(node.right);

            System.out.print(node.val + " -> ");
        }
    }

    private static void treeInOrderDFS(TreeNode node) {
        if (node != null) {
            treeInOrderDFS(node.left);
            System.out.print(node.val + " -> ");
            treeInOrderDFS(node.right);
        }
    }

    private static void treeDFSNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<> ();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            System.out.print(node.val + " -> ");

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }

    private static void treeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.val + " -> ");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        treePreDFS(root);
        System.out.println();
        treePostDFS(root);
        System.out.println();
        treeInOrderDFS(root);

        System.out.println();
        treeDFSNonRecursive(root);
        System.out.println();
        treeBFS(root);
    }
}
