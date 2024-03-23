package org.example.neetcode.linkedlist;

import org.example.datastructure.SinglyLinkedList;

public class LLHasCycle {
    public boolean hasCycle(SinglyLinkedList head) {
        SinglyLinkedList tails = head;
        while(head != null && head.getNext() != null) {
            tails = tails.getNext();
            head = head.getNext().getNext();
            if(head == tails) return true;
        }
        return false;
    }
}
