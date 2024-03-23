package org.example;

public class StringSum {

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }
// 984362587
//6000000000
    public static String addStrings(String num1, String num2) {
        String sum = "";
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        for(int i = 0; i <= (l1 > l2 ? l1 : l2); i++) {
            carry += (l1 - i >= 0 ? getInt(num1.charAt(l1 - i)) : 0 ) +
                    (l2 - i >= 0 ? getInt(num2.charAt(l2 - i)) : 0);
//            sum += (carry%10) * Math.pow(10, i);
            sum = carry%10 + sum;
            carry /= 10;
        }
        return carry+sum;
    }

    static int getInt(char c) {
        return c - '0';
    }
}
