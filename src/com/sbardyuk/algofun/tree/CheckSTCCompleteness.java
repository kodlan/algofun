package com.sbardyuk.algofun.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between
 * 1 and 2h nodes inclusive at the last level h.
 */
public class CheckSTCCompleteness {

  private static class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
      this.value = value;
    }
  }

  private static boolean isBSTComplete(TreeNode root){

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean wasNull = false;

    while (!queue.isEmpty()) {

      TreeNode node = queue.poll();

      if (node == null) {
        wasNull = true;
      } else {
        if (wasNull) return false;

        queue.add(node.left);
        queue.add(node.right);
      }
    }

    return true;

  }


  public static void main(String[] args) {
    TreeNode bst = new TreeNode(1);
    bst.left = new TreeNode(2);
    bst.left.left = new TreeNode(4);
    bst.left.right = new TreeNode(5);
    bst.right = new TreeNode(3);
    bst.right.left = new TreeNode(6);

    System.out.println("Is BST complete = " + isBSTComplete(bst));

    bst = new TreeNode(1);
    bst.left = new TreeNode(2);
    bst.left.left = new TreeNode(4);
    bst.left.right = new TreeNode(5);
    bst.right = new TreeNode(3);
    bst.right.right = new TreeNode(7);

    System.out.println("is BST complete = " + isBSTComplete(bst));
  }

}
