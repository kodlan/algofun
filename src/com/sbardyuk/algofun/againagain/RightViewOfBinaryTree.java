package com.sbardyuk.algofun.againagain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return an array containing nodes in its right view. The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.
 */
public class RightViewOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        result.add(root);

        while (!queue.isEmpty()) {

            List<TreeNode> level = new ArrayList<>();

            while(!queue.isEmpty()) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) level.add(currentNode.left);
                if (currentNode.right != null) level.add(currentNode.right);
            }

            if (!level.isEmpty()) {
                result.add(level.get(level.size() - 1));
            }
            queue.addAll(level);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
