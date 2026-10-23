package org.example.neetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationTwo {
    public static void main(String[] args) {
        int[] nums = {2,1,1};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(Arrays.stream(nums).boxed().collect(Collectors.toList()), 0, list);
        return list;
    }

    private static void permute(List<Integer> nums, int start, List<List<Integer>> list) {
        if(start == nums.size()) {
            list.add(nums);
        } else {
            Set<Integer> seen = new HashSet<>();
            for (int i = start; i < nums.size(); i++) {
                if (seen.contains(nums.get(i))) continue;
                seen.add(nums.get(i));
                swap(nums, i, start);
                permute(nums, start + 1, list);
                swap(nums, start, i);
            }
        }
    }



    private static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
