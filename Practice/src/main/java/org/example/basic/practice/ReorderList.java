package org.example.basic.practice;

import org.example.datastructure.SinglyLinkedList;

public class ReorderList {

    public static void main(String[] args) {
        SinglyLinkedList head = new SinglyLinkedList(1, new SinglyLinkedList(2, new SinglyLinkedList(3, new SinglyLinkedList(4))));
        reorderList(head);

        while (head != null) {
            System.out.println(head.getVal());
            head = head.next;
        }
    }

    public static void reorderList(SinglyLinkedList head) {
        if (head == null) return;

        SinglyLinkedList node = findMidNode(head);
        SinglyLinkedList reverse = node.next;
        node.next = null;
        reverse = reverseLL(reverse);
        node = head;
        SinglyLinkedList next1 = null;
        SinglyLinkedList next2 = null;
        while (reverse != null) {
            next1 = node.next;
            next2 = reverse.next;
            node.next = reverse;
            reverse.next = next1;
            reverse = next2;
            node = next1;
        }
    }

    private static SinglyLinkedList reverseLL(SinglyLinkedList node) {
        SinglyLinkedList prev = null;
        SinglyLinkedList next;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    private static SinglyLinkedList findMidNode(SinglyLinkedList head) {
        SinglyLinkedList slow = head;
        SinglyLinkedList fast = head;
        while (fast != null) {
            if (fast.next == null || fast.next.next == null)
                return slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }
}
