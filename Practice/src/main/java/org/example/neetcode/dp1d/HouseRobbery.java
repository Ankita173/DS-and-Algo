package org.example.neetcode.dp1d;

//https://leetcode.com/problems/house-robber/
public class HouseRobbery {
    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 4};
        System.out.println(rob(nums));
    }

//    Linear house arrangement 1st and last can be robbed together
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int rob1 = 0, rob2 = 0, temp;
        for (int house : nums) {
            temp = Math.max(house + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
