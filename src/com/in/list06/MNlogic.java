package com.in.list06;

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

    public void deleteNodes(int M, int N) {
        if (head == null || M <= 0 || N <= 0) {
            return; // Invalid input
        }

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            // Retain M nodes
            for (int i = 0; i < M && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }

            // Delete N nodes
            for (int i = 0; i < N && curr != null; i++) {
                curr = curr.next;
            }

            // Adjust the pointers to skip the deleted nodes
            prev.next = curr;
        }
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Create a linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);

        int M = 2;
        int N = 3;

        System.out.println("Original Linked List:");
        list.printList();

        list.deleteNodes(M, N);

        System.out.println("Modified Linked List:");
        list.printList();
    }
}

