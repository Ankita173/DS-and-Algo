package org.example.neetcode.linkedlist;


import org.example.datastructure.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;


class Cache {
    DoublyLinkedList lru;
    DoublyLinkedList mru;
    Map<Integer, DoublyLinkedList> cache;
    int capacity;
    public Cache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lru = new DoublyLinkedList();
        mru = new DoublyLinkedList(lru, null);
        lru.setNext(mru);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoublyLinkedList found = cache.get(key);
            if (!found.equals(mru.getPrev())) {
                found.getPrev().setNext(found.getNext());
                found.getNext().setPrev(found.getPrev());
                found.setNext(mru);
                found.setPrev(mru.getPrev());
                mru.getPrev().setNext(found);
                mru.setPrev(found);

            }
            return found.getValue();
        } else return -1;
    }

    public void put(int key, int value) {
        if (this.get(key) != -1) {
            mru.getPrev().setValue(value);
        } else {
            if (cache.size() == capacity){
                int delete = lru.getNext().getKey();
                lru.setNext(lru.getNext().getNext());
                lru.getNext().setPrev(lru);
                cache.remove(delete);
            }
            DoublyLinkedList newNode = new DoublyLinkedList(key, value);
            newNode.setNext(mru);
            newNode.setPrev(mru.getPrev());
            mru.getPrev().setNext(newNode);
            mru.setPrev(newNode);
            cache.put(key, newNode);
        }
    }
}

public class LRUCache{
    public static void main(String[] args) {
        Cache cache = new Cache(2);
        System.out.println(cache.get(1));
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */