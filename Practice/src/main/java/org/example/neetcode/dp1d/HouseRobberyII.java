package org.example.neetcode.dp1d;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobberyII {
    public static void main(String[] args) {
        int[] houses = {2, 3, 2};
        System.out.println(rob(houses));
    }

//    Circular house arrangement 1st and last can't be robbed together
    public static int rob(int[] nums) {
        return Math.max(
                HouseRobbery.rob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                HouseRobbery.rob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
}
