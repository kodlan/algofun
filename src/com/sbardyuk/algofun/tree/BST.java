package com.sbardyuk.algofun.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {

  private BinaryNode root;

  public BST() {
    root = null;
  }

  public void insert(int value) {
    BinaryNode node = new BinaryNode(value);
    if (root == null) {
      root = node;
    } else {
      insert(root, node);
    }
  }

  public void print() {
    Queue<BinaryNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {

      List<BinaryNode> level = new ArrayList<>();

      while (!queue.isEmpty()) {
        BinaryNode node = queue.poll();

        System.out.print(node.value + " ");

        if (node.left != null) level.add(node.left);
        if (node.right != null) level.add(node.right);
      }

      System.out.println();

      queue.addAll(level);
    }

  }

  public BinaryNode search(int value) {
    if (root == null) return null;
    return searchInternal(root, value);
  }

  private BinaryNode searchInternal(BinaryNode root, int value) {
    if (root == null) {
      return null;
    } else if (root.value == value) {
      return root;
    } else if (value > root.value) {
      return searchInternal(root.right, value);
    } else {
      return searchInternal(root.left, value);
    }
  }

  private BinaryNode insert(BinaryNode root, BinaryNode newNode) {
    if (root == null) {
      return newNode;
    }

    if (newNode.value > root.value) {
      root.right = insert(root.right, newNode);
    } else {
      root.left = insert(root.left, newNode);
    }

    return root;
  }

  private static class BinaryNode {
    int value;
    BinaryNode left, right;

    BinaryNode(int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    BST bst = new BST();

    bst.insert(7);
    bst.insert(5);
    bst.insert(9);
    bst.insert(3);
    bst.insert(6);
    bst.insert(8);
    bst.insert(10);
    bst.insert(2);
    bst.insert(4);


    bst.print();

    System.out.println();
    System.out.println();

    System.out.println("search res = " + bst.search(10).value);
    System.out.println("search res = " + bst.search(11));
    System.out.println("search res = " + bst.search(4).value);
  }
}
