package org.example.neetcode.math;

public class math {
    public static void main(String[] args) {
        System.out.println(myPow(0.00001d, 2147483647));
    }
    static double myPow(double x, int n) {
        if (n < 0) return myPow(1d/x, -n);
        if(n == 1) return x;
        return x * myPow(x, --n);
    }
}
