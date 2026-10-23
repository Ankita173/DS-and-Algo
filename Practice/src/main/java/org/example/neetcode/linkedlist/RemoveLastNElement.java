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
        System.out.println(removeNthFromEnd3(input, 2));
    }

    static public SinglyLinkedList removeNthFromEnd(SinglyLinkedList head, int n) {
        SinglyLinkedList dummy = new SinglyLinkedList(0);
        dummy.setNext(head);

        int i = 0;
        SinglyLinkedList left = dummy;
        SinglyLinkedList right = head;
        while (i < n && right != null) {
            right = right.getNext();
            i++;
        }

        while (right != null) {
            right = right.getNext();
            left = left.getNext();
        }
        if (left.getNext() != null)
            left.setNext(left.getNext().getNext());
        else
            left.setNext(null);
        return dummy.getNext();
    }

    static SinglyLinkedList removeNthFromEnd2(SinglyLinkedList head, int n) {
        SinglyLinkedList curr = head;
        if (n == 0)
            return head.next;
//        else if (n == 1)
//            return curr.next = curr.next.next;

        while (n-- > 1)
            curr = curr.next;

        if (curr == null) return null;
        else if (curr.next == null) curr = null;
        else curr.next = curr.next.next;
        return head;
    }

    static SinglyLinkedList removeNthFromEnd3(SinglyLinkedList head, int n) {
        if (head.next == null) return null;
        SinglyLinkedList left = head, right = head;
        while(right != null && n-- > 0)
            right = right.next;

        if (right == null) return head.next;

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return head;
    }

}
