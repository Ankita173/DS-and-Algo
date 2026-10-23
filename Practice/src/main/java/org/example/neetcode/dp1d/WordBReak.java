package org.example.neetcode.dp1d;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBReak {
    public static void main(String[] args) {
        List<String> dict = List.of("leet", "code");
        String word = "leetcode";
        System.out.println(wordBreak(word, dict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] match = new boolean[s.length() + 1];
        match[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() &&
                        s.substring(i, i + word.length()).equals(word))
                    match[i] = match[i + word.length()];
                if (match[i]) break;
            }
        }
        return match[0];
    }

    // Not all case passed but worth try
    public static boolean wordBreak2(String s, List<String> wordDict) {
        int[] match = new int[s.length()];
        Set<String> words = new HashSet<>(wordDict);
        int end = s.length();
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (words.contains(s.substring(i, end))) {
                match[i] = end - i;
                end = i;
            } else match[i] = -1;
        }

        if (end != 0) return false;
        while(end < s.length() && match[end] != -1) {
            end += match[end];
        }

        return end != -1;
    }
}
