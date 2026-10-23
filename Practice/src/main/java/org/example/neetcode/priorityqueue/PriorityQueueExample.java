package org.example.neetcode.priorityqueue;

import java.util.*;
import java.util.stream.Collectors;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<Integer> pQueue
                = new PriorityQueue<>((a, b) -> b - a);
        pQueue.add(10);
        pQueue.add(12);
        pQueue.add(1);
        System.out.println(pQueue);
    }
}
