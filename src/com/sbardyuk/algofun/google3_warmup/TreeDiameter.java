package com.sbardyuk.algofun.google3_warmup;

public class TreeDiameter {

    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    private static int maxDiam = 0;

    private static int findDiameter(TreeNode root) {
        dfs(root);
        return maxDiam - 1;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDiam = dfs(root.left);
        int rightDiam = dfs(root.right);

        if (maxDiam < leftDiam + 1 + rightDiam) {
            maxDiam = leftDiam + 1 + rightDiam;
        }

        return Math.max(leftDiam + 1, rightDiam + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + findDiameter(root));
    }
}
