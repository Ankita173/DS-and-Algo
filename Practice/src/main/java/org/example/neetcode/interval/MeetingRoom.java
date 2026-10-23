package org.example.neetcode.interval;

import java.util.*;

//https://neetcode.io/problems/meeting-schedule/question
public class MeetingRoom {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(0,30));
        input.add(new Interval(5,10));
        input.add(new Interval(15,20));
        System.out.println(canAttendMeetings(input));

        input = new ArrayList<>();
        input.add(new Interval(5,9));
        input.add(new Interval(9,10));
        input.add(new Interval(15,20));
        System.out.println(canAttendMeetings(input));


    }

    public static boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) return false;
        }
        return true;
    }
}

class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
