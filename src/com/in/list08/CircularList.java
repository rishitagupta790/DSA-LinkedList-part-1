package com.in.list08;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public boolean isCircular() {
        if (head == null) {
            return false;
        }

        Node slowPtr = head;
        Node fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return true; // Linked list is circular
            }
        }

        return false; // Linked list is not circular
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Create a circular linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        // Make the linked list circular by connecting the last node to the first node
        list.head.next.next.next.next = list.head;

        if (list.isCircular()) {
            System.out.println("Linked list is circular.");
        } else {
            System.out.println("Linked list is not circular.");
        }
    }
}

