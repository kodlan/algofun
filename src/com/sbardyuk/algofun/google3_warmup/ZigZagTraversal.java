package com.sbardyuk.algofun.google3_warmup;

import com.sbardyuk.algofun.patterns.bfs_tree.ZigzagTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverseOrder = true;

        while (!queue.isEmpty()) {

            List<Integer> levelList = new ArrayList<>();
            Queue<TreeNode> newQueue = new LinkedList<>();

            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (reverseOrder) {
                    levelList.add(node.val);
                } else {
                    levelList.add(0, node.val);
                }


                if (node.left != null) newQueue.add(node.left);
                if (node.right != null) newQueue.add(node.right);
            }

            reverseOrder = !reverseOrder;
            res.add(levelList);
            queue.addAll(newQueue);

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
