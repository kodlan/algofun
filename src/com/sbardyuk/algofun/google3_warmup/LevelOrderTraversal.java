package com.sbardyuk.algofun.google3_warmup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();

            while(!queue.isEmpty()) {
                TreeNode next = queue.poll();

                levelList.add(next.val);

                if (next.left != null) newQueue.add(next.left);
                if (next.right != null) newQueue.add(next.right);
            }

            res.add(levelList);
            queue.addAll(newQueue);
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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
