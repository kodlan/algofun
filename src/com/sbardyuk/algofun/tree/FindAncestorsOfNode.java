package com.sbardyuk.algofun.tree;

public class FindAncestorsOfNode extends BinarySearchTree {

    StringBuilder sb;

    private Node findAncestors(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (root.getValue() == value) {
            return root;
        } else {

            Node nodeFound = findAncestors(root.getLeftChild(), value);

            if (nodeFound == null) {
                nodeFound = findAncestors(root.getRightChild(), value);
            }

            if (nodeFound != null) {
                sb.append(nodeFound.getValue());
                sb.append(" - > ");
                return root;
            }
        }

        return null;
    }

    private String findAncestorPath(int value) {
        sb = new StringBuilder();

        Node node = findAncestors(this.getRoot(), value);
        if (node != null) {
            sb.append(node.getValue());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FindAncestorsOfNode bst = new FindAncestorsOfNode();

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
        System.out.println(bst.findAncestorPath(10));
    }

}
