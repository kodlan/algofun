package com.sbardyuk.algofun.againagain;

import java.util.*;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 */
public class BinaryTreeLevelOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<TreeNode>> traverse(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        result.add(Collections.singletonList(root));

        while (!queue.isEmpty()) {

            List<TreeNode> level = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    level.add(node.left);
                }

                if (node.right != null) {
                    level.add(node.right);
                }
            }

            result.add(level);
            queue.addAll(level);
        }


        return result;
    }

    private static void printTree(List<List<TreeNode>> res) {
        for (List<TreeNode> list : res) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode node : list) {
                sb.append(node.val).append(' ');
            }

            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        List<List<TreeNode>> result = traverse(root);
        printTree(result);
    }
}
