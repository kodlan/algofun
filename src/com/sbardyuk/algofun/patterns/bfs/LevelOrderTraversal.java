package com.sbardyuk.algofun.patterns.bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of
 * all nodes of each level from left to right in separate sub-arrays.
 */
public class LevelOrderTraversal {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<List<Integer>> traverseLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Queue<TreeNode> tmpQueue = new LinkedList<>(queue);
            queue.clear();

            List<Integer> levelList = new ArrayList<>();

            while (!tmpQueue.isEmpty()) {
                TreeNode node = tmpQueue.poll();

                levelList.add(node.value);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(levelList);
        }

        return res;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = traverseLevelOrder(root);

        System.out.println(result);
    }

}
