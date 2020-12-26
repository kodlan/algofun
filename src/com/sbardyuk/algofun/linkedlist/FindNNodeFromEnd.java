package com.sbardyuk.algofun.linkedlist;

public class FindNNodeFromEnd {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    static Node nth(Node root, int n) {
        Node p1 = root;
        Node p2 = root;

        int c = 0;
        while (c < n && p1 != null) {
            p1 = p1.next;
            c ++;
        }

        if (p1 == null) {
            return null;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }


    public static void main(String[] args) {
        Node root = new Node(1);

        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next = new Node(4);
        root.next.next.next = new Node(5);
        root.next.next.next.next = new Node(6);

        Node node = nth(root, 2);
        System.out.println(node.value);
    }
}
