package org.example.neetcode.array;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int[] input = {-1,1,0,-3,3};
        System.out.println(productExceptSelf(input));
    }

    public static int[] productExceptSelf(int[] nums) {
        // int prod = 1;
        // int zero = 0;
        // for (int num : nums) {
        //     if(num != 0)
        //         prod *= num;
        //     else
        //         zero++;
        // }
        // int[] result = new int[nums.length];
        // if (nums.length == zero) prod = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (zero > 1) {
        //         result[i] = 0;
        //     } else if (zero == 1) {
        //         if (nums[i] != 0) result[i] = 0;
        //         else result[i] = prod;
        //     } else
        //         result[i] = prod / nums[i];
        // }
        // return result;


        int n = nums.length;
        int[] output = new int[n];

        if(n<1) return output;

        int product = 1;
        for(int i=0;i<n;i++) {
            product*=nums[i];
            output[i] = product;
        }
        product = 1;
        for(int i=n-1;i>0;i--) {
            output[i] = output[i-1] * product;
            product*=nums[i];
        }
        output[0] = product;
        return output;
    }
}
