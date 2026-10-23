package org.example.neetcode.bitManipulation;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9, 3, 4, 5, 1, 6, 7, 8, 0};
        System.out.println(missing(nums));
    }

    public static int missing(int[] nums) {
        int sum = nums.length * (nums.length + 1)/2;
        for (int i : nums) sum -= i;
        return sum;
    }
}
