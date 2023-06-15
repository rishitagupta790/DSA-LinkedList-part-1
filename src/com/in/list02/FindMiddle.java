package com.in.list02;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class FindMiddle {
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

    public boolean hasLoop() {
        Node slowPtr = head;
        Node fastPtr = head;

        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return true; // Loop detected
            }
        }

        return false; // No loop found
    }

    public static void main(String[] args) {
        FindMiddle list = new FindMiddle();

        // Create a linked list with a loop
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.head.next.next.next.next.next = list.head.next; // Create a loop

        boolean hasLoop = list.hasLoop();
        System.out.println("Does the linked list have a loop? " + hasLoop);
    }
}

