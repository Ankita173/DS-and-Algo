package org.example.basic;

public class ReverseNumber {
    public static void main(String[] args) {
        int dd = 17;
        int MM = 3;
        System.out.print("Print Date: ");
        printDateMonth(dd, MM);
        System.out.print("Print Reverse Date: ");
        printMonthDate(dd, MM);
    }

    private static void printDateMonth(int dd, int MM) {
        System.out.println(dd + "/" + MM);
    }

    private static void printMonthDate(int dd, int MM) {
        dd = dd + MM; //17 + 3 = 20
        MM = dd - MM; //20 - 3 = 17
        dd = dd - MM; //20 - 17 = 3
        printDateMonth(dd, MM);
    }
}
