package org.example.neetcode.linkedlist;

import org.example.datastructure.SinglyLinkedList;

public class MergedSortedLL {
    public static void main(String[] args) {
        SinglyLinkedList head1 = null;
        SinglyLinkedList tail1 = null;
        int[] list1 = {1,2,4};
        for (int i : list1) {
            SinglyLinkedList n = new SinglyLinkedList(i, null);
            if (head1 == null) {
                head1 = n;
                tail1 = n;
                continue;
            }
            tail1.setNext(n);
            tail1 = tail1.getNext();
        }

        SinglyLinkedList head2 = null;
        SinglyLinkedList tail2 = null;
        int[] list2 = {1,3,4};
        for (int i : list2) {
            SinglyLinkedList n = new SinglyLinkedList(i);
            if (head2 == null) {
                head2 = n;
                tail2 = n;
                continue;
            }
            tail2.setNext(n);
            tail2 = tail2.getNext();
        }
        SinglyLinkedList mergeTwoLists = mergeTwoLists(head1, head2);
        while (mergeTwoLists != null) {
            System.out.println(mergeTwoLists.getVal());
            mergeTwoLists = mergeTwoLists.getNext();
        }
    }
    public static SinglyLinkedList mergeTwoLists(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedHead = null;
        SinglyLinkedList mergedTail = null;
        SinglyLinkedList pick;
        while (list1 != null && list2 != null) {
            if (list1.getVal() > list2.getVal()) {
                pick = new SinglyLinkedList(list2.getVal());
                list2 = list2.getNext();
            } else {
                pick = new SinglyLinkedList(list1.getVal());
                list1 = list1.getNext();
            }
            if(mergedHead != null) {
                mergedTail.setNext(pick);
                mergedTail = mergedTail.getNext();
            } else {
                mergedHead = pick;
                mergedTail = pick;
            }
        }
        if (list1 != null) {
            if (mergedHead == null)
                mergedHead = list1;
            else
                mergedTail.setNext(list1);
        }
        if (list2 != null) {
            if (mergedHead == null)
                mergedHead = list2;
            else
                mergedTail.setNext(list2);
        }
        return mergedHead;
    }
}
