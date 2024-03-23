package org.example.neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimunWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    static String minWindow(String s, String t) {
        Map<Character, Integer> tfreq = new HashMap<>();
        for(int i = 0; i < t.length(); i++) tfreq.put(t.charAt(i), tfreq.getOrDefault(t.charAt(i), 0) + 1);
        int l = 0, r = 0;
        int hit = 0;
        Map<Character, Integer> sfreq = new HashMap<>();
        String answer = "";
        boolean acquire;
        boolean release;
        do {
            acquire = false;
            release = false;
            while(r < s.length() && hit < t.length()) {
                char i = s.charAt(r);
                sfreq.put(i, sfreq.getOrDefault(i, 0) + 1);
                if(tfreq.getOrDefault(i, 0) >= sfreq.get(i)){
                    hit++;
                }
                r++;
                acquire = true;
            }

            while(l < r && hit == t.length()) {
                String match = s.substring(l, r);
                if (answer.isEmpty() || match.length() < answer.length()) answer = match;
                char i = s.charAt(l);
                if(sfreq.get(i) == 1)  sfreq.remove(i);
                else sfreq.put(i, sfreq.getOrDefault(i, 0) - 1);
                if(tfreq.getOrDefault(i, 0) > sfreq.getOrDefault(i, 0)){
                    hit--;
                }
                l++;
                release = true;
            }
        } while (acquire || release);
        return answer;
    }
}
