package org.example.neetcode.linkedlist;

import org.example.datastructure.SinglyLinkedList;

public class RemoveLastNElement {

    public static void main(String[] args) {
        int i = 1;
        SinglyLinkedList head = new SinglyLinkedList(i);
        SinglyLinkedList input = head;
        while (i < 2) {
            head.setNext(new SinglyLinkedList(++i));
            head = head.getNext();
        }
        removeNthFromEnd(input, 2);
    }
    static public SinglyLinkedList removeNthFromEnd(SinglyLinkedList head, int n) {
        SinglyLinkedList dummy = new SinglyLinkedList(0);
        dummy.setNext(head);



        int i = 0;
        SinglyLinkedList left = dummy;
        SinglyLinkedList right = head;
        while(i < n && right != null) {
            right = right.getNext();
            i++;
        }

        while(right != null) {
            right = right.getNext();
            left = left.getNext();
        }
        if (left.getNext() != null)
            left.setNext(left.getNext().getNext());
        else
            left.setNext(null);
        return dummy.getNext();
    }

}
