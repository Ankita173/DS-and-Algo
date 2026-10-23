package org.example.neetcode.dp1d;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 0, -8};
        System.out.println(maxProduct(nums));

        int[] nums1 = {2, 0, -8, 1, 5, 3, 0, -4, 2, -3};
        System.out.println(maxProduct(nums1));
    }

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;
        int i = 0;

        // forward product or prefix product
        for(; i < nums.length; i++) {
            if (nums[i] == 0) {
                product = 1;
                max = max < 0 ? 0 : max;
            } else {
                product *= nums[i];
                max = max < product ? product : max;
            }
        }
        product = 1;
        // backward product or suffix product
        for(i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) product = 1;
            else {
                product *= nums[i];
                max = max < product ? product : max;
            }
        }
        return max;
    }
}
