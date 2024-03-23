package org.example.trustt;

import java.util.HashMap;
import java.util.Map;

public class MatchWord {




/*
task is to write a function that, given a list of words and a string, finds and returns the word in the list that is scrambled up inside the string, if any exists. There will be at most one matching word. The letters don't need to be in order or next to each other. The letters cannot be reused.
Example:
words = ['cat','baby','dog', 'bird', 'car', 'ax']
string1 = 'tcabnihjs' -> cat
string2 =  'rbahyrabwq' -> baby
string3 = 'test' -> Null/None
find_embedded_word(words, string1) -> cat (the letters do not have to be in order)


  */


    static String find_embedded_word(String[] words, String string1) {
        Map<Character, Integer> strFreq = getFreqency(string1);
        for (String word : words) {
            Map<Character, Integer> wordFreq = getFreqency(word);
            boolean flag = true;
            for (Map.Entry<Character, Integer> row : wordFreq.entrySet()) {
                if (strFreq.get(row.getKey()) != null && row.getValue() <= strFreq.get(row.getKey())) {
                    continue;
                }
                flag = false;
            }
            if (flag) return word;
        }
        return null;
    }

    static Map<Character, Integer> getFreqency(String string1) {
        Map<Character, Integer> strFreq = new HashMap<>();
        for (int i = 0; i < string1.length(); i++) {
            strFreq.put(string1.charAt(i), strFreq.getOrDefault(string1.charAt(i), 0) + 1);
        }
        return strFreq;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "baby", "dog", "bird"};
        System.out.println(find_embedded_word(words, "tcabnihjs"));
    }
}








