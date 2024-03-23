package org.example.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithDuplicate {

  public static void main(String[] args) {
    int[] nums = {1,1,2};
    Arrays.sort(nums);
    List<List<Integer>> sol = new ArrayList<>();
    boolean flag[] = new boolean[nums.length];
    perm(sol, new ArrayList<>(), nums, flag);
    System.out.println(sol);
  }
  static void perm(List<List<Integer>> sol, List<Integer> temp, int[] nums, boolean flag[]) {
    if(temp.size() == nums.length) {
      sol.add(new ArrayList<>(temp));
      return;
    }
    for(int i = 0; i < nums.length; i++) {
      if (flag[i]) {
        continue;
      }
      if (i > 0 && nums[i] == nums[i-1] && !flag[i-1])
        continue;
      temp.add(nums[i]);
      flag[i] = true;
      perm(sol, temp, nums, flag);
      flag[i] = false;
      temp.remove(temp.size()-1);
    }

  }
}
