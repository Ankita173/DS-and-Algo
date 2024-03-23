package org.example.neetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongConsecutiveSequence {
    public static void main(String[] args) {
//        int[] nums = {-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7};
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        int max = 1;
        if (nums.length < 1) return 0;
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (unique.contains(num)) continue;
            unique.add(num);
            int process = 0;
            if(start.containsKey(num + 1)) {
                int e = start.get(num + 1);
                int st = num;
                if (end.containsKey(num)) {
                    e = end.get(num);
                    end.remove(num);
                }
                start.put(st, e);
                start.remove(num + 1);
                end.put(e, st);
                int s = e - st + 1;
                if (s > max) {
                    max = s;
                }
                process++;
            }
            if (end.containsKey(num - 1)) {
                int st = end.get(num - 1);
                int e = num;
                if (start.containsKey(num)) {
                    e = start.get(num);
                    start.remove(num);
                }
                end.put(e, st);
                end.remove(num - 1);
                start.put(st, e);
                int s = e - st + 1;
                if (s > max) {
                    max = s;
                }
                process++;
            }
            if (process == 0) {
                start.put(num, num);
                end.put(num, num);
            }
        }
        return max;
    }
}
