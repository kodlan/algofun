package com.sbardyuk.algofun.patterns.dfs_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 */
public class BinaryTreeAllPathWithSum {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<List<Integer>> findPath(TreeNode node, int sum) {
        return findPathInternal(node, node, sum, 0);
    }

    private static List<List<Integer>> findPathInternal(TreeNode node, TreeNode root, int targetSum, int currentSum) {

        if (node == null) {
            if (targetSum == currentSum) {
                List<List<Integer>> lists = new ArrayList<>();
                lists.add(new ArrayList<>());
                return lists;
            } else {
                return null;
            }
        }

        List<List<Integer>> paths = new ArrayList<>();

        List<List<Integer>> leftPath = findPathInternal(node.left, root, targetSum, currentSum + node.value);
        List<List<Integer>> rightPath = findPathInternal(node.right, root, targetSum, currentSum + node.value);

        if (leftPath != null) {
            paths.addAll(leftPath);
        }

        if (rightPath != null) {
            paths.addAll(rightPath);
        }

        for (List<Integer> list : paths) {
            list.add(node.value);
        }

        return paths.isEmpty() ? null : paths;
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

        List<List<Integer>> result = findPath(root, 22);

        System.out.println(result);

    }


}
