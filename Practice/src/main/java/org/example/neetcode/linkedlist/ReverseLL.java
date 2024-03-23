package org.example.neetcode.linkedlist;

import org.example.datastructure.SinglyLinkedList;

public class ReverseLL {
    public static void main(String[] args) {
        SinglyLinkedList head = null;
        SinglyLinkedList tail = null;
        int[] list = {1,2,3,4,5,6};
        for (int i : list) {
            SinglyLinkedList n = new SinglyLinkedList(i);
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.setNext(n);
                tail = tail.getNext();
            }
        }
        SinglyLinkedList reverse = reverseList(head);
        while(reverse != null) {
            System.out.println(reverse.getVal());
            reverse = reverse.getNext();
        }
    }

    public static SinglyLinkedList reverseList(SinglyLinkedList head) {
        SinglyLinkedList newHead = null;
        SinglyLinkedList newTail = null;
        while(head != null) {
            newHead = head;
            head = head.getNext();
            newHead.setNext(newTail);
            newTail = newHead;
        }
        return newHead;
    }
}
