package org.example.neetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://neetcode.io/problems/meeting-schedule-ii/question
public class MeetingRoomII {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,10));
        input.add(new Interval(2,3));
        input.add(new Interval(4,5));
        input.add(new Interval(6,7));
        input.add(new Interval(2,6));
        input.add(new Interval(8,9));
        System.out.println(minMeetingRooms(input));
        System.out.println(minMeetingRooms2(input));

        input = new ArrayList<>();
        input.add(new Interval(5,9));
        input.add(new Interval(9,10));
        input.add(new Interval(15,20));
        System.out.println(minMeetingRooms(input));
        System.out.println(minMeetingRooms2(input));
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;
        intervals.sort(Comparator.comparing(i -> i.start));
        List<Integer> rooms = new ArrayList<>();
        rooms.add(intervals.get(0).end);
        int minTimeIndex = 0;

        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start < rooms.get(minTimeIndex)) {
                rooms.add(intervals.get(i).end);
                minTimeIndex = rooms.get(minTimeIndex) < intervals.get(i).end ? minTimeIndex : rooms.size()-1;
            } else {
                rooms.set(minTimeIndex, intervals.get(i).end);
                minTimeIndex = findMinIndex(rooms);
            }
        }
        return rooms.size();
    }

    private static int findMinIndex(List<Integer> rooms) {
        int min = 0;
        for (int i = 1; i < rooms.size(); i++)
            min = rooms.get(min) < rooms.get(i) ? min : i;
        return min;
    }


//    This approach thinks at any given timestamp how many meetings are going on, max of that is the required room
    public static int minMeetingRooms2(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        int[] startTime = new int[intervals.size()];
        int[] endTime = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int meeting = 0;
        int room = Integer.MIN_VALUE;
        for (int s = 0, e = 0; s < intervals.size();) {
            if (startTime[s] < endTime[e]) {
                meeting++;
                s++;
            } else {
                meeting--;
                e++;
            }
            room = room < meeting ? meeting : room;
        }

        return room;
    }
}
