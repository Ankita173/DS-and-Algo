package org.example.neetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/insert-interval/description/
public class InsertInterval {
    public static void main(String[] args) {
        int[][] input = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println(Arrays.deepToString(insert(input, newInterval)));

    }

//    This is a greedy approach
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                merged.add(interval);
            } else if (interval[0] > newInterval[1]) {
                merged.add(newInterval);
                merged.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = newInterval[0] < interval[0] ? newInterval[0] : interval[0];
                newInterval[1] = newInterval[1] > interval[1] ? newInterval[1] : interval[1];
            }
        }
        if (newInterval != null) merged.add(newInterval);
        return merged.toArray(new int[merged.size()][]);
    }
}
