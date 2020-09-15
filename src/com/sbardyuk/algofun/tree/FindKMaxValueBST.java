package com.sbardyuk.algofun.tree;

public class FindKMaxValueBST extends BinarySearchTree {

    public int findKthMax(int k) {
        Node node = findKthMaxRecursive(getRoot(), k);
        if (node != null) {
            return node.getValue();
        }
        return -1;
    }

    private int backCounter = 0;

    private Node findKthMaxRecursive(Node root, int k) {

        if (root == null) {
            return null;
        }

        Node node = findKthMaxRecursive(root.getRightChild(), k);

        if (backCounter != k) {
            backCounter ++;
            node = root;
        }

        if (backCounter == k) {
            return node;
        } else {
            return findKthMaxRecursive(root.getLeftChild(), k);
        }
    }

    public static void main(String[] args) {

        FindKMaxValueBST bst = new FindKMaxValueBST();
        bst.add(10);
        bst.add(1);
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(20);
        bst.add(15);
        bst.add(25);
        bst.add(22);
        bst.add(30);
        bst.print();

        System.out.println("\n\n");
        System.out.println(bst.findKthMax(2));

    }

}
