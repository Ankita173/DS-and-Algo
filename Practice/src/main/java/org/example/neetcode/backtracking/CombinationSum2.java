package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        System.out.println(combinationSum2(candidates, 5));
    }

    static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> comb = new ArrayList<>();
        sum(candidates, target, comb, new ArrayList<>(), 0);
        return comb;
    }

    static void sum(int[] candidates, int target, List<List<Integer>> comb, List<Integer> list, int index) {
        if (0 == target) {
            comb.add(new ArrayList<>(list));
            return;
        }

        if (index == candidates.length || candidates[index] > target)
            return;

        list.add(candidates[index]);
        sum(candidates, target - candidates[index], comb, list, index + 1);
        list.remove(list.size()-1);

        for (; index+1 < candidates.length && candidates[index+1] == candidates[index]; index++);

        sum(candidates, target, comb, list, index+1);
    }

}
