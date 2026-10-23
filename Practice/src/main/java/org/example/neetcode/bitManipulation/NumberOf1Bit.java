package org.example.neetcode.bitManipulation;

public class NumberOf1Bit {
    public static void main(String[] args) {
        System.out.println(hammingWeightRecurssion(44));
        System.out.println(hammingWeightIteration(44));
    }

    public static int hammingWeightRecurssion(int n) {
        if (n == 0)
            return 0;
        else if (n % 2 == 1)
            return 1 + hammingWeightRecurssion(n / 2);

        return hammingWeightRecurssion(n / 2);
    }


    public static int hammingWeightIteration(int n) {
         int weight = 0;
         while(n > 0) {
             if(n % 2 == 1) weight++;
             n /= 2;
         }
         return weight;
    }
}