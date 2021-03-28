package com.sbardyuk.algofun.again;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeStuf {

    private static class TreeAgain {
        TreeAgain left, right;
        int value;

        TreeAgain(int value) {
            this.value = value;
        }
    }

    private static void levelOrderPrint(TreeAgain root) {

        Queue<TreeAgain> q = new LinkedList<>();

        q.add(root);
        System.out.println(root.value);

        while(!q.isEmpty()) {

            List<TreeAgain> currentLevel = new ArrayList<>();

            while (!q.isEmpty()) {
                TreeAgain node = q.poll();

                if (node.left != null) currentLevel.add(node.left);
                if (node.right != null) currentLevel.add(node.right);
            }

            q.addAll(currentLevel);

            currentLevel.forEach(x -> System.out.print(x.value));
            System.out.println();
        }
    }

    private static void post(TreeAgain root) {
        if (root == null) return;
        post(root.left);
        post(root.right);
        System.out.print(root.value);
    }

    private static void pre(TreeAgain root) {
        if (root == null) return;
        System.out.print(root.value);
        pre(root.left);
        pre(root.right);
    }

    private static void in(TreeAgain root) {
        if (root == null) return;
        in(root.left);
        System.out.print(root.value);
        in(root.right);
    }

    private static void allPathWithSum(TreeAgain root, int sum) {
        List<List<TreeAgain>> paths = pathWithSumRec(root, sum);

        for (List<TreeAgain> list : paths) {
            System.out.println();
            list.forEach(x -> System.out.print(x.value + " "));
        }

    }

    private static List<List<TreeAgain>> pathWithSumRec(TreeAgain root, int sumLeft) {
        if (root.left == null &&  root.right == null) {
            if (sumLeft - root.value == 0) {
                List<List<TreeAgain>> pathList = new ArrayList<>();
                List<TreeAgain> currentPath = new ArrayList<>();
                currentPath.add(root);
                pathList.add(currentPath);
                return pathList;
            } else {
                return new ArrayList<>();
            }
        }

        List<List<TreeAgain>> resList = new ArrayList<>();
        if (root.left != null) {
            List<List<TreeAgain>> left = pathWithSumRec(root.left, sumLeft - root.value);
            resList.addAll(left);
        }

        if (root.right != null) {
            List<List<TreeAgain>> right = pathWithSumRec(root.right, sumLeft - root.value);
            resList.addAll(right);
        }

        for (List<TreeAgain> list : resList) {
            list.add(0, root);
        }

        return resList;
    }

    public static void main(String[] args) {

        TreeAgain t = new TreeAgain(0);

        t.left = new TreeAgain(1);
        t.left.left = new TreeAgain(2);
        t.left.right = new TreeAgain(3);

        t.right = new TreeAgain(4);
        t.right.left = new TreeAgain(5);
        t.right.right = new TreeAgain(6);

        levelOrderPrint(t);

        System.out.println();
        post(t);
        System.out.println();
        pre(t);
        System.out.println();
        in(t);

        System.out.println();
        allPathWithSum(t, 3);

    }

}
