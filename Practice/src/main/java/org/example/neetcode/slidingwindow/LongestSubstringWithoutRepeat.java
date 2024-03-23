package org.example.neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        System.out.println(longestSubstring("pwwkew"));
        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring(" "));
    }

    static int longestSubstring(String s) {
        int start = 0;
        int end = -1;
        int max = 0;
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(index.containsKey(s.charAt(i))) {
                max = end - start + 1 > max ? end - start + 1 : max;
                while (start <= index.get(s.charAt(i))) {
                    index.remove(index.get(start));
                    start++;
                }
            }
            end++;
            index.put(s.charAt(i), i);
            max = end - start + 1 > max ? end - start + 1 : max;
        }
        return max;
    }
}
