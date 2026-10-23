package org.example.neetcode.bitManipulation;

public class CountingBits {
    public static void main(String[] args) {
        for(int i : countBits(5)) {
            System.out.println(i);
        }
    }

    static public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for(int i = 0; i <= n; i++) {
            bits[i] = convertAndCount(i);
        }
        return bits;
    }

    static private int convertAndCount(int n) {
        int count = 0;
        while (n > 0) {
            count+= (n % 2 == 0) ? 0 : 1;
            n /= 2;
        }
        return count;
    }
}
