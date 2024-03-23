package org.example;

import java.util.HashMap;
import java.util.Map;

public class FindSubArraySumToTarget {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6}; int target = 6;
//        int[] arr = new int[]{3,4,7,2,-3,1,4,2}; int target = 7;
        System.out.println(arr);
        System.out.println("count " + findSubarraySum(arr, target));
    }

    static int findSubarraySum(int[] arr, int t) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            frequency.put(sum, frequency.getOrDefault(sum, 0) + 1);
            sum += arr[i];
            if (frequency.containsKey(sum - t)) {
                frequency.put(sum, frequency.getOrDefault(sum - t, 0) + 1);
                count++;
            }
        }
        return count;
    }
}
