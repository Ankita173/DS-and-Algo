package org.example.neetcode.priorityqueue;

import java.util.PriorityQueue;

public class KthElement {
    public static void main(String[] args) {
        int[] element = {4, 5, 8, 2};
        KthLargest kth = new KthLargest(3, element);
        System.out.println(kth.add(3));
    }
}


class KthLargest {

    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        for (int n : nums) add(n);
    }

    public int add(int val) {
        heap.add(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }
}