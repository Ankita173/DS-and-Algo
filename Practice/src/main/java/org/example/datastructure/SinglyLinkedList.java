package org.example.datastructure;

public class SinglyLinkedList {
    int val;
    SinglyLinkedList next;
    public SinglyLinkedList(int val) {
        this.val = val;
    }
    public SinglyLinkedList(int val, SinglyLinkedList next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public SinglyLinkedList getNext() {
        return next;
    }

    public void setNext(SinglyLinkedList next) {
        this.next = next;
    }
}
