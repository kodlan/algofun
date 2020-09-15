package com.sbardyuk.algofun.tree;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NodesWithDistanceFromRoot extends BinarySearchTree {

    private Set<Integer> res;

    private void findKNodesRecursive(Node root, int i, int k) {
        if (root == null) {
            return;
        }

        if (i == k) {
            res.add(root.getValue());
        } else {
            findKNodesRecursive(root.getLeftChild(), i + 1, k);
            findKNodesRecursive(root.getRightChild(), i + 1, k);
        }
    }

    private String findKNodes(int k) {
        res = new HashSet<>();

        findKNodesRecursive(this.getRoot(), 0, k);

        return res.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }


    public static void main(String[] args) {
        NodesWithDistanceFromRoot bst = new NodesWithDistanceFromRoot();

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
        System.out.println(bst.findKNodes(2));
    }
}
