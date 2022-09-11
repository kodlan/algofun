package com.sbardyuk.algofun.againagain;

/**
 * Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.
 */
public class ReverseLinkedList {

    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        ListNode tmpnext;

        while (current.next != null) {
            tmpnext = current.next;

            current.next = prev;

            prev = current;
            current = tmpnext;
        }

        current.next = prev;

        return current;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }


}
