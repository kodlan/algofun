package com.sbardyuk.algofun.other;

public class DeleteNthNodeInLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private static void printList(Node root) {
        Node next = root;

        System.out.println("list = ");

        while(next != null) {
            System.out.print(next.val + " -> ");
            next = next.next;
        }

        System.out.println("null");
    }

    private static void deleteFromEnd(Node root, int nth) {

        Node head = root;
        Node slow = root;

        int count = 0;

        while(head != null) {
            head = head.next;

            if (count >= nth + 1) {
                slow = slow.next;
            }

            count ++;
        }

        slow.next = slow.next.next;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next = new Node(7);
        root.next.next.next.next.next.next.next = new Node(8);

        printList(root);

        deleteFromEnd(root, 2);
        printList(root);

        root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next = new Node(7);
        root.next.next.next.next.next.next.next = new Node(8);
        deleteFromEnd(root, 4);
        printList(root);

    }

}
