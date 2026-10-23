package org.example.neetcode.dp1d;

//https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbingWays(n-1, 1, 1));
    }

    private static int climbingWays(int n, int last, int second) {
        if (n == 0) return second;
        return climbingWays(n-1, second, second+last);
    }
}
