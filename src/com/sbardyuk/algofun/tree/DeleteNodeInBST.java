package com.sbardyuk.algofun.tree;

public class DeleteNodeInBST extends BinarySearchTree {


    private Node findParentNode(Node childNode) {
        Node currentNode = getRoot();

        while (currentNode != null) {

            if (currentNode.getLeftChild() == childNode || currentNode.getRightChild() == childNode) {
                return currentNode;
            }

            if (currentNode.getValue() < childNode.getValue()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }

        return null;
    }

    private boolean isLeaf(Node node) {
        return node != null && node.getLeftChild() == null && node.getRightChild() == null;
    }

    private boolean hasOneChild(Node node) {
        return node != null && (
                (node.getLeftChild() == null && node.getRightChild() != null) ||
                        (node.getLeftChild() != null && node.getRightChild() == null));
    }

    private Node getOneChild(Node node) {
        if (node.getRightChild() != null) {
            return node.getRightChild();
        } else if (node.getLeftChild() != null) {
            return node.getLeftChild();
        }
        return null;
    }

    private void replaceChildNode(Node parentNode, Node nodeToDelete, Node nodeToInsert) {
        if (parentNode.getLeftChild() == nodeToDelete) {
            parentNode.setLeftChild(nodeToInsert);
        } else {
            parentNode.setRightChild(nodeToInsert);
        }
    }

    private void deleteLeafNode(Node parentNode, Node nodeToDelete) {
        replaceChildNode(parentNode, nodeToDelete, null);
    }

    private void deleteOneChild(Node parentNode, Node nodeToDelete) {
        Node childNode = getOneChild(nodeToDelete);
        replaceChildNode(parentNode, nodeToDelete, childNode);
    }

    private Node findSmallestNodeParent(Node node) {
        if (node.getLeftChild() == null) {
            return node;
        }

        while(node.getLeftChild().getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    private void deleteWhenTwoChildren(Node parentNode, Node nodeToDelete) {
        Node smallestParentFromRightTree = findSmallestNodeParent(nodeToDelete.getRightChild());
        Node smallestChildFromRightTree = smallestParentFromRightTree.getLeftChild();

        smallestParentFromRightTree.setLeftChild(null);

        smallestChildFromRightTree.setLeftChild(nodeToDelete.getLeftChild());
        smallestChildFromRightTree.setRightChild(nodeToDelete.getRightChild());

        parentNode.setRightChild(smallestChildFromRightTree);
    }

    public void delete(Node nodeToDelete) {
        Node parentNode = findParentNode(nodeToDelete);
        if (parentNode == null) {
            return;
        }

        if (isLeaf(nodeToDelete)) {
            deleteLeafNode(parentNode, nodeToDelete);
        } else if (hasOneChild(nodeToDelete)) {
            deleteOneChild(parentNode, nodeToDelete);
        } else {
            deleteWhenTwoChildren(parentNode, nodeToDelete);
        }
    }


    public static void main(String[] args) {
        DeleteNodeInBST bst = new DeleteNodeInBST();
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

        Node nodeToDelete = bst.search(9);

        bst.delete(nodeToDelete);

        System.out.println("\n\n\n\n");

        bst.print();
    }


}
