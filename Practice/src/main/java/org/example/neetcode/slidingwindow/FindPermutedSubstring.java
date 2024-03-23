package org.example.neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FindPermutedSubstring {

    public static void main(String[] args) {
//        System.out.println(checkInclusion("hello", "ooolleoooleh"));
//        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("adc", "dcda"));
    }

    static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> inputFreq = getFrequency(s1, 0, s1.length()-1);
        Map<Character, Integer> windowFreq = new HashMap<>(inputFreq);
        int l = 0, r = 0;
        for(; r < s2.length(); r++) {
            if (!reduceFreq(windowFreq, s2.charAt(r))) {
                l++;
                windowFreq = new HashMap<>(inputFreq);
                continue;
            }
            if(r - l + 1 == s1.length()) {
                if (windowFreq.isEmpty()) return true;
                l++;
            }
        }
        return false;
    }

    static boolean reduceFreq(Map<Character, Integer> inputFreq, char c) {
        if (inputFreq.containsKey(c)) {
            int freq = inputFreq.get(c);
            if (freq == 1) inputFreq.remove(c);
            else inputFreq.put(c, freq - 1);
            return true;
        }
        return false;
    }

    static Map<Character, Integer> getFrequency(String s1, int l , int r) {
        Map<Character, Integer> inputFreq = new HashMap<>();
        for (int i = l ; i <= r; i++) {
            char c = s1.charAt(i);
            if (inputFreq.containsKey(c))
                inputFreq.put(c, inputFreq.get(c) + 1);
            else inputFreq.put(c, 1);
        }
        return inputFreq;
    }
}
