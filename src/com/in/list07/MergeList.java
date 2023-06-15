package com.in.list07;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head1;
    Node head2;

    public void insertFirstList(int data) {
        Node newNode = new Node(data);
        if (head1 == null) {
            head1 = newNode;
        } else {
            Node curr = head1;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void insertSecondList(int data) {
        Node newNode = new Node(data);
        if (head2 == null) {
            head2 = newNode;
        } else {
            Node curr = head2;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void mergeLists() {
        if (head1 == null || head2 == null) {
            return; // Invalid input
        }

        Node curr1 = head1;
        Node curr2 = head2;

        while (curr1 != null && curr2 != null) {
            Node next1 = curr1.next;
            Node next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }

        head2 = null; // Empty the second list after merging
    }

    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Create the first linked list
        list.insertFirstList(5);
        list.insertFirstList(7);
        list.insertFirstList(17);
        list.insertFirstList(13);
        list.insertFirstList(11);

        // Create the second linked list
        list.insertSecondList(12);
        list.insertSecondList(10);
        list.insertSecondList(2);
        list.insertSecondList(4);
        list.insertSecondList(6);

        System.out.println("First Linked List:");
        list.printList(list.head1);

        System.out.println("Second Linked List:");
        list.printList(list.head2);

        list.mergeLists();

        System.out.println("Merged Linked List (First List after insertion, Second List emptied):");
        list.printList(list.head1);
        System.out.println("Second Linked List (after emptying):");
        list.printList(list.head2);
    }
}
