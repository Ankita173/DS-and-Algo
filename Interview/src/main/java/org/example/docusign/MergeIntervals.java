package org.example.docusign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (l1, l2) -> l1[0]-l2[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] prev = intervals[i-1];
            int[] curr = intervals[i];
            if(prev[1] >= curr[0] && curr[0] >= prev[0]) {
                int max = prev[1] > curr[1] ? prev[1] : curr[1];
                intervals[i-1] = new int[]{0, 0};
                intervals[i] = new int[]{prev[0], max};
            }
        }

        List<int[]> mergedInterval = new ArrayList<>();
        for (int[] merged : intervals) {
            if(merged[0] == 0)
                continue;
            mergedInterval.add(merged);
        }


        int[][] mergedIntervals = new int[mergedInterval.size()][2];
        for (int i = 0; i < mergedInterval.size(); i++) {
            mergedIntervals[i] = mergedInterval.get(i);
        }

        return mergedIntervals;

    }


}
