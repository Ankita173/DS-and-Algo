package org.example.neetcode.twopointers;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
        int[] nums1 = {-1,0,1,0};
        System.out.println(threeSum(nums1));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        Set<String> unique = new HashSet<>();
        for (int i : nums) {
            if (frequency.containsKey(i)) frequency.put(i, frequency.get(i) + 1);
            else frequency.put(i, 1);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int remainder = -(nums[i] + nums[j]);
                if (frequency.containsKey(remainder)) {
                    int count = frequency.get(remainder);
                    if ((remainder == nums[i] && remainder == nums[j] && count < 3) ||
                            ((remainder == nums[i] || remainder == nums[j]) && count < 2) ||
                            ((remainder != nums[i] && remainder != nums[j]) && count < 1))  continue;
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], remainder);
                    String u = sortAndConcat(triplet);
                    if (!unique.contains(u)) {
                        output.add(triplet);
                        unique.add(u);
                    }
                }
            }
        }
        return output;
    }

    private static String sortAndConcat(List<Integer> arr) {
        Collections.sort(arr);
        String s = "";
        for (int i : arr) {
            s += i;
        }
        return s;
    }
}
