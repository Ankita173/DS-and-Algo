package org.example.neetcode.linkedlist;

import org.example.datastructure.SinglyLinkedList;

public class MergeKSortedList {

    public static void main(String[] args) {
        SinglyLinkedList[] list = new SinglyLinkedList[3];
        list[0] = new SinglyLinkedList(1, new SinglyLinkedList(3, new SinglyLinkedList(5, null)));
        list[1] = new SinglyLinkedList(1, new SinglyLinkedList(2, new SinglyLinkedList(3, null)));
        list[2] = new SinglyLinkedList(2, new SinglyLinkedList(4, new SinglyLinkedList(6, null)));
        mergeKLists(list);
    }
    public static SinglyLinkedList mergeKLists(SinglyLinkedList[] lists) {
        SinglyLinkedList mergedList = null;
        SinglyLinkedList mergedLastNode = null;
        while(true) {
            SinglyLinkedList minNode = null;
            int minI = 0;
            for (int i = 0; i < lists.length; i++) {
                if (minNode == null || (lists[i] != null && minNode.getVal() > lists[i].getVal())) {
                    minNode = lists[i];
                    minI = i;
                }
            }
            if (minNode == null) break;
            lists[minI] = minNode.getNext();
            if (mergedList == null) {
                mergedList = minNode;
                mergedLastNode = minNode;
            } else {
                mergedLastNode.setNext(minNode);
                mergedLastNode = mergedLastNode.getNext();
            }
            minNode.setNext(null);
        }
        return mergedList;
    }
}
