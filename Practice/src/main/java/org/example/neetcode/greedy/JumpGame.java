package org.example.neetcode.greedy;

// https://leetcode.com/problems/jump-game/description/
public class JumpGame {
    public static void main(String[] args) {
        int[] input = {3,2,1,0,4};
        System.out.println(canJump(input));
    }

    private static boolean canJump(int[] nums) {
        int goal = nums.length-1;
        int checkpoint = nums.length-1;
        while (checkpoint >= 0) {
            if (nums[checkpoint] + checkpoint >= goal) goal = checkpoint;
            checkpoint--;
        }
        return goal == 0;
    }
}
