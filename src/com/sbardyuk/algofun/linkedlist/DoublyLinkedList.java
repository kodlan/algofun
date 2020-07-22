package com.sbardyuk.algofun.linkedlist;

public class DoublyLinkedList<T> {

    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public int size;

    public DoublyLinkedList() {
        this.headNode = null;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;

        newNode.nextNode = this.headNode;
        newNode.prevNode = null;

        if (headNode != null)
            headNode.prevNode = newNode;
        this.headNode = newNode;
        size++;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : null <- ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }

        headNode = headNode.nextNode;
        headNode.prevNode = null;
        size--;
    }

    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }

        Node currentNode = this.headNode;

        if (currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }

        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)) {
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if (currentNode.nextNode != null)
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                size--;
            }
            currentNode = currentNode.nextNode;
        }
    }
}
