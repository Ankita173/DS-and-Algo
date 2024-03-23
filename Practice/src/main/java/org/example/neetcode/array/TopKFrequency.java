package org.example.neetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequency {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] r = topKFrequent(nums, 2);
        System.out.println(r);
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] freqBucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            List<Integer> list = freqBucket[entry.getValue()];
            if (list == null)
                list = new ArrayList<>();
            list.add(entry.getKey());
            freqBucket[entry.getValue()] = list;
        }
        int[] output = new int[k];
        for(int i = nums.length, l=0; i > 0  && l < output.length; i--) {
            List<Integer> list = freqBucket[i];
            if (list != null && !list.isEmpty()) {
                for (int j = 0; j < list.size() && l < output.length; j++, l++) {
                    output[l] = list.get(j);
                }
            }
        }
        return output;







//        Map<Integer, Integer> frequency = new HashMap<>();
//        for (int num : nums) {
//            if (frequency.containsKey(num)) {
//                frequency.put(num, frequency.get(num) + 1);
//            } else {
//                frequency.put(num, 1);
//            }
//        }
//        return frequency.entrySet()
//                .stream()
//                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//                .limit(k)
//                .map(Map.Entry::getKey)
//                .mapToInt(i->i)
//                .toArray();

    }

}
