package org.example.neetcode.array;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String sorted = sortString(strs[i]);
            if(group.containsKey(sorted)) {
                List<String> updated = group.get(sorted);
                updated.add(strs[i]);
                group.put(sorted, updated);
            } else {
                List<String> updated = new ArrayList<>();
                updated.add(strs[i]);
                group.put(sorted, updated);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry row : group.entrySet()) {
            result.add((List<String>)row.getValue());
        }
        return result;
    }

    private static String sortString(String str) {
        char arr[] = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
