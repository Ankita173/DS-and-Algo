package org.example.neetcode.dp2d;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-earnings-from-taxi/description/?envType=problem-list-v2&envId=dz0hbz9d
// Time = o(n+m)
// Space = o(n+m)
// n=spots, m=rides
public class MaxTaxiEarning {
    public static void main(String[] args) {
        int[][] rides = {{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}};
        System.out.println(maxTaxiEarnings(20, rides));
    }
    public static long maxTaxiEarnings(int n, int[][] rides) {

        List<int[]>[] endingRides = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) endingRides[i] = new ArrayList<>();

        for (int[] ride : rides)
            endingRides[ride[1]].add(ride);

        long[] profit = new long[n+1];
        for (int i = 1; i <= n; i++) {
            profit[i] = profit[i-1];

            for(int[] ending : endingRides[i]) {
                profit[i] = Math.max(profit[i], profit[ending[0]] + ending[1] - ending[0] + ending[2]);

            }

        }
        return profit[n];
    }
}
