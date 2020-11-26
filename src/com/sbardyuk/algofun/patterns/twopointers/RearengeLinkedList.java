package com.sbardyuk.algofun.patterns.twopointers;

/**
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the
 * second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
 * So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 */
public class RearengeLinkedList {

    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode rearangeList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middleNode = findMiddleNode(head);
        ListNode reversedHead = reverseList(middleNode);

        ListNode pointer1 = head;
        ListNode pointer2 = reversedHead;

        while (pointer1 != null && pointer2 != null) {
            ListNode temp = pointer1.next;
            pointer1.next = pointer2;
            pointer1 = temp;

            temp = pointer2.next;
            pointer2.next = pointer1;
            pointer2 = temp;
        }

        // set the next of the last node to 'null'
        if (pointer1 != null)
            pointer1.next = null;

        return head;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private static ListNode findMiddleNode(ListNode head) {
        // find middle of the list
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        System.out.println("middle of the list = " + middle.value);

        return middle;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);

        printList(head);
        rearangeList(head);
        printList(head);

        System.out.println();
        System.out.println();

        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(8);
        head1.next.next.next.next = new ListNode(10);

        printList(head1);
        rearangeList(head1);
        printList(head1);

    }
}
