package org.example.datastructure;
public class DoublyLinkedList {
    int key;
    int value;
    DoublyLinkedList prev;
    DoublyLinkedList next;
    public DoublyLinkedList() {}
    public DoublyLinkedList(DoublyLinkedList prev, DoublyLinkedList next) {
        this.next = next;
        this.prev =  prev;
    }
    public DoublyLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public DoublyLinkedList getNext() {
        return next;
    }

    public void setNext(DoublyLinkedList next) {
        this.next = next;
    }

    public DoublyLinkedList getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedList prev) {
        this.prev = prev;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
