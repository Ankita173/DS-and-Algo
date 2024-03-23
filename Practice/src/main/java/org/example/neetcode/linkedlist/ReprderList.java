package org.example.neetcode.linkedlist;

import org.example.datastructure.SinglyLinkedList;

public class ReprderList {
    public static void main(String[] args) {
        int i = 1;
        SinglyLinkedList head = new SinglyLinkedList(i);
        SinglyLinkedList input = head;
        while (i < 6) {
            head.setNext(new SinglyLinkedList(++i));
            head = head.getNext();
        }
        reorderList(input);
    }
    static public void reorderList(SinglyLinkedList head) {
        //find the mid of the list
        SinglyLinkedList slow = head;
        SinglyLinkedList fast = head.getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast != null) fast = fast.getNext();
        }

        SinglyLinkedList second = slow.getNext();
        slow.setNext(null);
        slow = second.getNext();
        SinglyLinkedList lag = null;
        //reverse the second half of the list
        while (slow != null) {
            second.setNext(lag);
            lag = second;
            second = slow;
            slow = slow.getNext();
        }
        second.setNext(lag);
        //merge the two parts to form the reordered list
        //head - head of first half
        //second - head of second half
        SinglyLinkedList first = head;
        fast = head;
        lag = second;
        while (second != null) {
            fast = fast.getNext();
            lag = lag.getNext();
            first.setNext(second);
            second.setNext(fast);
            second = lag;
            first = fast;
        }
//         print reordered list
         first = head;
         while(first.getNext() != null) {
             System.out.println(first.getVal());
             first = first.getNext();
         }
    }

}
