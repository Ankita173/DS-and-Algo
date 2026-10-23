package org.example.neetcode.greedy;

// https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] input =  {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarray(input));
    }

    private static int maxSubarray(int[] nums) {
        int min = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i :  nums) {
            if (currSum < 0) currSum = 0;
            else currSum += i;

            min = min < currSum ? currSum : min;
        }
        return min;
    }
}
