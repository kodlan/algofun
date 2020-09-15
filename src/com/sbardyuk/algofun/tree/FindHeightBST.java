package com.sbardyuk.algofun.tree;

public class FindHeightBST extends BinarySearchTree {

    private int findMaxHeight(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return 0;
        }

        int left = findMaxHeight(root.getLeftChild());
        int right = findMaxHeight(root.getRightChild());

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        FindHeightBST bst = new FindHeightBST();

        bst.add(6);
        bst.add(4);
        bst.add(2);
        bst.add(5);
        bst.add(9);
        bst.add(8);
        bst.add(12);
        bst.add(10);
        bst.add(14);

        bst.print();

        System.out.println("\n\n");
        System.out.println(bst.findMaxHeight(bst.getRoot()));
    }
}
