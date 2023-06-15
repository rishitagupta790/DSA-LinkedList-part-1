package com.in.list01;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class DeleteMiddle {
    Node head;

    public void deleteMiddle() {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, return null
            head = null;
            return;
        }

        Node slowPtr = head;
        Node fastPtr = head;
        Node prev = null;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }

        prev.next = slowPtr.next;
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
        DeleteMiddle list = new DeleteMiddle();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        list.printList();

        list.deleteMiddle();

        System.out.println("Modified Linked List:");
        list.printList();
    }
}
