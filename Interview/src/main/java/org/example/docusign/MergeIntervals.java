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
            if(prev[1] >= curr[0]) {
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



//  import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public static List<Meeting> mergeRanges(List<Meeting> meetings) {
//
//    // make a copy so we don't destroy the input
//    List<Meeting> sortedMeetings = new ArrayList<>();
//    for (Meeting meeting: meetings) {
//        Meeting meetingCopy = new Meeting(meeting.getStartTime(), meeting.getEndTime());
//        sortedMeetings.add(meetingCopy);
//    }
//
//    // sort by start time
//    Collections.sort(sortedMeetings, new Comparator<Meeting>() {
//        @Override
//        public int compare(Meeting m1, Meeting m2) {
//            return m1.getStartTime() - m2.getStartTime();
//        }
//    });
//
//    // initialize mergedMeetings with the earliest meeting
//    List<Meeting> mergedMeetings = new ArrayList<>();
//    mergedMeetings.add(sortedMeetings.get(0));
//
//    for (Meeting currentMeeting : sortedMeetings) {
//
//        Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);
//
//        // if the current meeting overlaps with the last merged meeting, use the
//        // later end time of the two
//        if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
//            lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));
//
//            // add the current meeting since it doesn't overlap
//        } else {
//            mergedMeetings.add(currentMeeting);
//        }
//    }
//
//    return mergedMeetings;
//}
