package org.example.neetcode.interval;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/description/
public class NonOverlappingInterval {
    public static void main(String[] args) {
        int[][] input = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(input));

        int[][] input2 = {{1, 2}, {1, 2}, {1, 2}, {1, 2}};
        System.out.println(eraseOverlapIntervals(input2));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int discard = 0;

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) prevEnd = intervals[i][1];
            else {
                discard++;
                prevEnd = prevEnd < intervals[i][1] ? prevEnd : intervals[i][1];
            }
        }
        return discard;
    }
}
