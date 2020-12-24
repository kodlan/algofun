package com.sbardyuk.algofun.linkedlist;


/**
 * Given the head nodes of two linked lists that may or may not intersect, find out if they intersect and return the point of intersection. Return null otherwise.
 */
public class LinkedListIntersection {

    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    private static int findLen(ListNode root) {
        int res = 0;
        while (root.next != null) {
            res ++;
            root = root.next;
        }
        return res;
    }

    static void findIntersection(ListNode root1, ListNode root2) {
        int len1 = findLen(root1);
        int len2 = findLen(root2);

        int diff = Math.abs(len1 - len2);
        for (int i = 0; i < diff; i ++) {
            if (len1 > len2) {
                root1 = root1.next;
            } else {
                root2 = root2.next;
            }
        }

        while (root1 != null || root2 != null) {
            if (root1 == root2) {
                System.out.println(root1.value);
            }

            root1 = root1.next;
            root2 = root2.next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(12);
        head.next = new ListNode(4);

        ListNode head2 = new ListNode(29);
        head2.next = new ListNode(23);
        head2.next.next = new ListNode(82);

        ListNode tmp = new ListNode(12);

        head.next.next = tmp;
        head2.next.next.next = tmp;

        tmp.next = new ListNode(27);

        findIntersection(head, head2);

        ////////////////////////////
        ListNode root1 = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode root = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        findIntersection(root, root1);

    }
}
