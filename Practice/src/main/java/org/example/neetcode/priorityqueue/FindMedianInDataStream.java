package org.example.neetcode.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/find-median-from-data-stream/description/
public class FindMedianInDataStream {
    public static void main(String[] args) {
        MedianFinder strm = new MedianFinder();
        strm.addNum(1);
        strm.addNum(2);
        System.out.println(strm.findMedian());
        strm.addNum(3);
        System.out.println(strm.findMedian());
    }

}

class MedianFinder {
    Queue<Integer> min;
    Queue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>((a,b) -> b - a);
        max = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(min.peek() == null) min.add(num);
        else if (min.peek() < num) max.add(num);
        else min.add(num);

        if ((min.size() - max.size()) > 1) max.add(min.remove());
        else if ((min.size() - max.size()) < 0) min.add(max.remove());
    }

    public double findMedian() {
        if (min.size() > max.size()) return min.peek();
        else return (double)(min.peek() + max.peek()) / 2;
    }
}
