package org.example.neetcode.bitManipulation;

public class SumOf2Int {
    public static void main(String[] args) {
        System.out.println(sum(3, 6));
    }

    public static int sum(int a, int b) {
        while (b != 0) {
            int carry = (a & b)  << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
