package com.in.list05;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class RemoveLoop {
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

    public void createLoop(int position) {
        if (position <= 0 || head == null) {
            return; // Invalid input
        }

        Node lastNode = head;
        Node loopNode = null;

        int count = 1;
        while (lastNode.next != null) {
            if (count == position) {
                loopNode = lastNode;
            }
            lastNode = lastNode.next;
            count++;
        }

        if (loopNode != null) {
            lastNode.next = loopNode;
        }
    }

    public void removeLoop() {
        if (head == null || head.next == null) {
            return; // No loop or invalid input
        }

        Node slowPtr = head;
        Node fastPtr = head;

        // Detect the loop using Floyd's Cycle-Finding Algorithm
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                break; // Loop detected
            }
        }

        // No loop found
        if (slowPtr != fastPtr) {
            return;
        }

        // Move slowPtr back to the head and move both pointers at the same pace until they meet
        slowPtr = head;
        while (slowPtr.next != fastPtr.next) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        // Break the loop by setting the next pointer of the last node to null
        fastPtr.next = null;
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
        RemoveLoop list = new RemoveLoop();

        // Create a linked list with a loop
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.createLoop(2); // Create a loop at position 2

        System.out.println("Original Linked List:");
        list.printList();

        list.removeLoop();

        System.out.println("Modified Linked List (after removing the loop):");
        list.printList();
    }
}

