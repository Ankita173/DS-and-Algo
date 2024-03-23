package org.example.neetcode.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<Integer> pQueue
                = new PriorityQueue<>();
        pQueue.add(10);
        pQueue.add(12);
        pQueue.add(1);
        System.out.println(pQueue);

    }
}
