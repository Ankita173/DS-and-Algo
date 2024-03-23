package org.example.tesco;
//        Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.
//
//        In a store, a colleague can work for multiple departments.
//        Here are shifts of a colleague in various departments:
//
//        In Bakery department: From 8 to 10
//        In Checkout department: From 10 to 12
//        In Diary department: From 14 to 19
//        Given the above split of shifts, provide an API/method to return the
//        different shifts of a colleague for the day after merging contiguous shifts.
//        This will be exposed to the colleague in different UI and help them plan their day accordingly.
//
//        His shift timings in this case are 8 to 12 and 14 to 19.
//        has context menu

import java.util.ArrayList;
import java.util.List;

// input
// start with no overlap - later can be handled
// 24 hour format and input can be in any order
public class Example {
    static class Shift {
        int checkinTime;
        int checkoutTime;
        String department;
        Shift(int checkinTime, int checkoutTime, String department) {
            this.checkinTime =  checkinTime;
            this.checkoutTime = checkoutTime;
            this.department = department;
        }
    }

    public static void main(String[] args) {
        System.out.println("scenario1");
        List<Shift> shifts = new ArrayList<>();
        shifts.add(new Shift(8, 10, "Bakery"));
        shifts.add(new Shift(9, 12, "Checkout"));
        shifts.add(new Shift(-1, 19, "Checkout"));
        try {
            for (Shift s : findShifts(shifts)) {
                System.out.println("Checkin:" + s.checkinTime + " checkout: " + s.checkoutTime);
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("scenario2");
        List<Shift> shifts1 = new ArrayList<>();
        shifts1.add(new Shift(8, 10, "Bakery"));
        shifts1.add(new Shift(9, 12, "Checkout"));
        shifts1.add(new Shift(14, 19, "Checkout"));
        try {
            for (Shift s : findShifts(shifts1)) {
                System.out.println("Checkin:" + s.checkinTime + " checkout: " + s.checkoutTime);
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("scenario3");
        List<Shift> shifts3 = new ArrayList<>();
        shifts3.add(new Shift(8, 10, "Bakery"));
        shifts3.add(new Shift(9, 12, "Checkout"));
        shifts3.add(new Shift(14, 19, "Checkout"));
        shifts3.add(new Shift(21, 23, "Checkout"));
        try {
            for (Shift s : findShifts(shifts3)) {
                System.out.println("Checkin:" + s.checkinTime + " checkout: " + s.checkoutTime);
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static List<Shift> findShifts(List<Shift> shifts) throws IllegalArgumentException{
        int[] time = new int[24];
        for(Shift s : shifts) {
            if (s.checkinTime > 24 || s.checkinTime < 0 || s.checkoutTime > 24 || s.checkoutTime < 0)
                //throw new IllegalArgumentException("wrong shift time");
                continue;
            for(int i = s.checkinTime; i < s.checkoutTime; i++) {
                time[i] = 1;
            }
        }
        List<Shift> datTime  = new ArrayList<>();
        int checkinTime = 0;
        int checkinOut = 0;
        for (int i = 0; i < 24; i++) {
            if (time[i] > 0) {
                checkinTime = i;
                while (time[i] > 0) {
                    i++;
                }
                checkinOut = i;
                datTime.add(new Shift(checkinTime, checkinOut, "shift"));
            }
        }
        return datTime;
    }



}