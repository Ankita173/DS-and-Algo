package org.example.neetcode.linkedlist;

import org.example.datastructure.SinglyLinkedList;

public class SumList {
    public static void main(String[] args) {
        SinglyLinkedList l1 = new SinglyLinkedList(2, new SinglyLinkedList(4, new SinglyLinkedList(3, null)));
        SinglyLinkedList l2 = new SinglyLinkedList(5, new SinglyLinkedList(6, new SinglyLinkedList(4, null)));
        addTwoNumbers(l1, l2);
    }

    static public SinglyLinkedList addTwoNumbers(SinglyLinkedList l1, SinglyLinkedList l2) {
        SinglyLinkedList list = new SinglyLinkedList(-1);
        SinglyLinkedList sumList = list;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int s = (l1 == null ? 0 : l1.getVal()) + (l2 == null ? 0 : l2.getVal());
            if (carry > 0) {
                s += carry;
                carry = 0;
            }
            sumList.setNext(new SinglyLinkedList(s % 10));
            sumList = sumList.getNext();
            if (s / 10 != 0) {
                carry = s / 10;
            }
            if (l1 != null) l1 = l1.getNext();
            if (l2 != null) l2 = l2.getNext();
        }
        if (carry > 0) sumList.setNext(new SinglyLinkedList(carry));
        return list.getNext();
    }
}
