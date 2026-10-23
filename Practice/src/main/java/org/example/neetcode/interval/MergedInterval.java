package org.example.neetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergedInterval {
    public static void main(String[] args) {
        //unsorted input
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        System.out.println(Arrays.deepToString(merge(input)));
        System.out.println(Arrays.deepToString(merge2(input)));
    }

//  Approach uses sorting time: o(nlogn)) space: o(n)
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] newInterval = intervals[0];
        for(int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                merged.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[0] = newInterval[0] < intervals[i][0] ? newInterval[0] : intervals[i][0];
                newInterval[1] = newInterval[1] > intervals[i][1] ? newInterval[1] : intervals[i][1];
            }
        }
        merged.add(newInterval);
        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] merge2(int[][] intervals) {
        int max = 0;
        for(int[] interval : intervals) {
            max = Math.max(max, interval[0]);
        }

        int[] mergedLine = new int[max + 1];
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            mergedLine[start] = Math.max(end + 1, mergedLine[start]);
        }

        int count = 0;
        int endInterval = -1;
        int startInterval = -1;

        for (int i = 0; i <= max; i++) {
            if (mergedLine[i] != 0) {
                if (startInterval == -1) startInterval = i;
                endInterval = Math.max(endInterval, mergedLine[i] - 1);
            }

            if (i == endInterval) {
                intervals[count++] = new int[] { startInterval, endInterval };
                startInterval = -1;
                endInterval = -1;
            }
        }
        if (startInterval != -1) intervals[count++] = new int[] { startInterval, endInterval };
        if (count == intervals.length) return intervals;

        int[][] result = new int[count][2];
        System.arraycopy(intervals, 0, result, 0, count);
        return result;
    }

}
