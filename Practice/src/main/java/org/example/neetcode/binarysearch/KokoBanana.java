package org.example.neetcode.binarysearch;

public class KokoBanana {
    public static void main(String[] args) {
        int[] piles = {312884470};
        int h = 968709470;
        System.out.println(minEatingSpeed(piles, h));

    }

    public static int minEatingSpeed(int[] piles, int h) {
        int res = 0;
        if (h < piles.length) return res;
        int j = piles[0];
        for (int p : piles) {
            if (p > j) j = p;
        }
        int i = 0;
        int k = j;
        while (i <= j) {
            k = (i+j)/2;
            if (k == 0) break;
            int sum = 0;
            for (int p : piles) {
                sum += p/k + (p%k == 0 ? 0 : 1);
            }
            if (sum <= h) {
                j = k;
            } else {
                i = k + 1;
            }
        }
        return j;
    }
}
