package com.sbardyuk.algofun.tree;


public class NthBiggestNumberInTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static int nth(TreeNode root, int nth) {
        TreeNode node =  n(root, 0, nth);
        if (node != null) {
            return node.value;
        }
        return -1;
    }


    private static TreeNode n(TreeNode node, int i, int n) {

        if (node == null) {
            return null;
        }

        TreeNode res1 = n(node.right, i, n);
        if (res1 != null) return res1;

        if (i + 1 == n) {
            return node;
        }

        TreeNode res2 = n(node.left, i + 2, n);
        if (res2 != null) return res2;

        return null;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.left.left = new TreeNode(25);

        root.left.right = new TreeNode(75);
        root.right = new TreeNode(200);
        root.right.left = new TreeNode(125);
        root.right.right = new TreeNode(350);

        System.out.println(nth(root, 3));
    }
}
