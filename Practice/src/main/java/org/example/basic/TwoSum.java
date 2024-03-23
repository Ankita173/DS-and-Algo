package org.example.basic;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(twoSum(nums, target));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int ans[] = new int[2];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if(lookup.containsKey(nums[i])) {
                ans[0] = i;
                ans[1] = lookup.get(nums[i]);
                return ans;
            } else {
                lookup.put(target - nums[i] ,i);
            }
        }
        return ans;
    }
}
