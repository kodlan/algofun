package com.sbardyuk.algofun.tree;

/** Some old test implementation */
@Deprecated
public class BinarySearchTree {

    private Node root;

    public void add(int value) {

        if (isEmpty()) {
            root = new Node(value);
            return;
        }

        Node currentNode = root;

        while(currentNode != null) {
            Node left = currentNode.getLeftChild();
            Node right = currentNode.getRightChild();

            if (currentNode.getValue() > value) {
                if (left == null) {
                    left = new Node(value);
                    currentNode.setLeftChild(left);
                    return;
                }
                currentNode = left;
            } else {
                if (right == null) {
                    right = new Node(value);
                    currentNode.setRightChild(right);
                    return;
                }
                currentNode = right;
            }
        }
    }

    public void print() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node == null) return;

        System.out.println(node.getValue() + ", ");
        printTree(node.getLeftChild());
        printTree(node.getRightChild());
    }

    public boolean isEmpty () {
        return root == null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node search(int value) {
        Node node = root;

        while (node != null) {
            if (node.getValue() == value) {
                return node;
            } else if (node.getValue() > value) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(1);
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.print();

        System.out.println("\n\n");

        Node res = bst.search(3);
        System.out.println(res.getValue());

        System.out.println("\n\n");

        res = bst.search(33);
        System.out.println(res == null);
    }
}
