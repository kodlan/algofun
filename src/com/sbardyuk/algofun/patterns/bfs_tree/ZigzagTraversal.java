package com.sbardyuk.algofun.patterns.bfs_tree;

import java.util.*;

/**
 * Given a binary tree, populate an array to represent its zigzag level order traversal.
 * You should populate the values of all nodes of the first level from left to right,
 * then right to left for the next level and keep alternating in the same manner for the following levels.
 */
public class ZigzagTraversal {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int levelCount = 0;

        while (!queue.isEmpty()) {

            Queue<TreeNode> tmpQueue = new LinkedList<>(queue);
            queue.clear();

            List<Integer> levelList = new ArrayList<>();

            while (!tmpQueue.isEmpty()) {
                TreeNode node = tmpQueue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                if (levelCount % 2 == 0) {
                    levelList.add(node.value);
                } else {
                    levelList.add(0, node.value);
                }
            }

            res.add(levelList);

            levelCount ++;

        }

        return res;
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

        List<List<Integer>> result = zigzag(root);

        System.out.println(result);
    }
}

