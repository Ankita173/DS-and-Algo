package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {

    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] input = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(input, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private static void combinationSum(int[] candidates, int target, List<Integer> current, int i) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || i >= candidates.length ) return;

        current.add(candidates[i]);
        combinationSum(candidates, target - candidates[i], current, i);
        current.remove(current.size()-1);
        combinationSum(candidates, target, current, i+1);
    }
}
