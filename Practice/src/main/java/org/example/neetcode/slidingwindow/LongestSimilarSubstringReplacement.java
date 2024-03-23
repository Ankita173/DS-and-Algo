package org.example.neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSimilarSubstringReplacement {
    public static void main(String[] args) {
//        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));

    }


    static int characterReplacement(String s, int k) {
        Map<Character, Integer> frequency = new HashMap<>();
        int result = 0;
        int l = 0, r = 0;
        int max = 0;
        boolean ifLMoved = false;
        while (true) {
            if (!ifLMoved) {
                char charR = s.charAt(r);
                if (frequency.containsKey(charR)) {
                    frequency.put(charR, frequency.get(charR) + 1);
                } else frequency.put(charR, 1);
                max = max < frequency.get(charR) ? frequency.get(charR) : max;
            }
            int window = r - l + 1;
            if (window - max <= k) {
                result = window > result ? window : result;
            }
            else {
                char charL = s.charAt(l);
                frequency.put(charL, frequency.get(charL) - 1);
                max = findMax(frequency);
                l++;
                ifLMoved = true;
                continue;
            }
            if (r+1 < s.length())  {
                r++;
                ifLMoved = false;
            }
            else {
                if(r - l + 1 <= result) break;
                char charL = s.charAt(l);
                frequency.put(charL, frequency.get(charL) - 1);
                max = findMax(frequency);
                l++;
                ifLMoved = true;

            }
        }
        return result;
    }

    private static int findMax(Map<Character, Integer> frequency) {
        int max = 0;
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            max = entry.getValue() > max ? entry.getValue() : max;
        }
        return max;
    }

}
