package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(n);
        long p = Long.parseLong(br.readLine());
        System.out.println(p);
        System.out.println(findPFactor(n, p));
    }

    static long findPFactor(long n, long p) {
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0 ) {
                p--;
            }
            if (p == 0) return i;
        }
        if (--p == 0) return n;
        return -1;
    }
}
