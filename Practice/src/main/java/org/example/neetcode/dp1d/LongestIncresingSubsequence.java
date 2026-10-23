package org.example.neetcode.dp1d;

public class LongestIncresingSubsequence {
    public static void main(String[] args) {
        int[] nums ={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

        int[] nums1 ={7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS(nums1));

    }

    public static int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[nums.length-1] = 1;

        int count = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            int max = 0;
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j])
                    max = max < lis[j] ? lis[j] : max;
            }
            lis[i] = 1 + max;
            count = count < lis[i] ? lis[i] : count;
        }
        return count;
    }
}
