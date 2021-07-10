package com.sbardyuk.algofun.againagain;

/**
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass through the root.
 *
 * Note: You can always assume that there are at least two leaf nodes in the given tree.
 */
public class TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    public static int findDiameter(TreeNode root) {
        rec(root);
        return  maxLength;
    }

    static int maxLength = 0;

    private static int rec(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = rec(node.left);
        int right = rec(node.right);

        int count = left + right + 1;

        if (maxLength < count) {
            maxLength = count;
        }

        return Math.max(left + 1, right + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));

        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
