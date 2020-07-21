package com.sbardyuk.algofun.linkedlist;

public class SinglyLinkedList<T> {

    public class Node {
        public T data;
        public Node nextNode;

    }

    public Node headNode;
    public int size;

    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;

        headNode = newNode;
        size++;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        while (last.nextNode != null) {
            last = last.nextNode;
        }

        last.nextNode = newNode;
        size++;
    }

    public void insertAfter(T data, T previous) {
        Node newNode = new Node();
        newNode.data = data;

        Node currentNode = this.headNode;
        //traverse the list until node having data equal to previous is found
        while (currentNode != null && !currentNode.data.equals(previous)) {
            currentNode = currentNode.nextNode;
        }

        //if such a node was found then point our newNode to currentNode's nextElement
        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }
    }

    public boolean searchNode(T data) {
        Node temp = headNode;
        while(temp != null) {
            if (temp.data != null && temp.data.equals(data)) {
                return true;
            }
            temp = temp.nextNode;
        }

        return false;
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }

        //make the nextNode of the headNode equal to new headNode
        headNode = headNode.nextNode;
        size--;
    }

    public void deleteByValue(T data) {

        if (isEmpty()) {
            return;
        }

        if (headNode.data.equals(data)) {
            deleteAtHead();
        }

        Node curr = headNode;
        Node prev = null;
        while(curr != null) {
            if (curr.data != null && curr.data.equals(data) && prev != null) {
                prev.nextNode = curr.nextNode;
                return;
            }
            prev = curr;
            curr = curr.nextNode;
        }
    }

    public static <T> void reverse( SinglyLinkedList<T> list) {
        SinglyLinkedList.Node prev = null;
        SinglyLinkedList.Node curr = list.headNode;
        SinglyLinkedList.Node next = null;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }
        list.headNode = prev;
    }

    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        SinglyLinkedList.Node slow = list.headNode;
        SinglyLinkedList.Node fast = list.headNode;

        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // reverse test
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0; i < 15; i += 1) {
            list.insertAtEnd(i);
        }
        System.out.print("Before ");
        list.printList();
        reverse(list);
        System.out.print("After ");
        list.printList();


        // detectLoop test
        list = new SinglyLinkedList<Integer>();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        System.out.println("Before adding loop: " + detectLoop(list));
        list.headNode.nextNode.nextNode = list.headNode;
        System.out.println("After adding loop: " + detectLoop(list));

    }
}
