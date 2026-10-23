package org.example.neetcode.bitManipulation;

public class ReverseBit {
    public static void main(String[] args) {
        System.out.println(reverseBit(536870912));
    }

    public static int reverseBit(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res  += ( bit << (31 - i));

        }
        return res;
    }
}
