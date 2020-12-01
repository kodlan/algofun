package com.sbardyuk.algofun.patterns.dfs_tree;

public class TreeDiameter {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static int treeDiameter(TreeNode node) {
        treeDiameterInternal(node);
        return diameterMax;
    }

    private static int diameterMax = 0;

    private static int treeDiameterInternal(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftDiameter = treeDiameterInternal(node.left);
        int rightDiameter = treeDiameterInternal(node.right);

        int currentDiameter = leftDiameter + rightDiameter + 1;
        if (currentDiameter > diameterMax) {
            diameterMax = currentDiameter;
        }

        return Math.max(leftDiameter, rightDiameter) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);

        root.right.left.right = new TreeNode(8);
        root.right.left.right.right = new TreeNode(10);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(11);

        int diameter = treeDiameter(root);
        System.out.println(diameter);
    }
}
