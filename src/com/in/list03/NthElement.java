package com.in.list03;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class NthElement {
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

    public Node findNthFromEnd(int n) {
        if (head == null || n <= 0) {
            return null; // Invalid input
        }

        Node slowPtr = head;
        Node fastPtr = head;

        // Move the fast pointer n positions ahead
        for (int i = 0; i < n; i++) {
            if (fastPtr == null) {
                return null; // Invalid input if n is greater than the number of nodes
            }
            fastPtr = fastPtr.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        return slowPtr;
    }

    public static void main(String[] args) {
        NthElement list = new NthElement();

        // Create a linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        int n = 3; // Find the 3rd node from the end
        Node nthNodeFromEnd = list.findNthFromEnd(n);
        
        if (nthNodeFromEnd != null) {
            System.out.println("The " + n + "th node from the end: " + nthNodeFromEnd.data);
        } else {
            System.out.println("Invalid input or Nth node not found.");
        }
    }
}

