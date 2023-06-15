package com.in.list04;

import java.util.Stack;

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Palindrom {
    Node head;

    public void insert(char data) {
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

    public boolean isPalindrome() {
        if (head == null) {
            return true; // An empty list is considered a palindrome
        }

        Node slowPtr = head;
        Node fastPtr = head;
        Stack<Character> stack = new Stack<>();

        // Push characters onto the stack until the fast pointer reaches the end
        while (fastPtr != null && fastPtr.next != null) {
            stack.push(slowPtr.data);
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Handle odd number of nodes by moving the slow pointer ahead one step
        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        // Compare characters from the stack with the remaining part of the linked list
        while (slowPtr != null) {
            char top = stack.pop();
            if (top != slowPtr.data) {
                return false; // Not a palindrome
            }
            slowPtr = slowPtr.next;
        }

        return true; // Palindrome
    }

    public static void main(String[] args) {
        Palindrom list = new Palindrom();

        // Create a linked list
        list.insert('R');
        list.insert('A');
        list.insert('D');
        list.insert('A');
        list.insert('R');

        boolean isPalindrome = list.isPalindrome();
        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}
