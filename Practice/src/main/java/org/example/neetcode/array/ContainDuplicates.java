package org.example.neetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> found = new HashSet<>();
        for (int i : nums) {
            if (!found.add(i)) return true;
        }
        return false;
    }
}
