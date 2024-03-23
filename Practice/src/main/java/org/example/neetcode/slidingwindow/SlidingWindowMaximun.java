package org.example.neetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximun {

    public static void main(String[] args) {
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        System.out.println(maxSlidingWindow(nums, 5));

    }
    static int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        Deque<Integer> maxInWindow = new ArrayDeque<>();
        int i = 0, j = 0;
        while(j < nums.length) {
            while(!maxInWindow.isEmpty() && maxInWindow.peekFirst() < i) maxInWindow.pollFirst();
            while(!maxInWindow.isEmpty() && nums[maxInWindow.peekLast()] < nums[j]) maxInWindow.pollLast();
            maxInWindow.addLast(j);
            if(j - i + 1 == k) {
                ans[i] = nums[maxInWindow.peekFirst()];
                i++;
            }
            j++;
        }
        return ans;
    }
}