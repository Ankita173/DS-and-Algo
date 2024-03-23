package org.example.basic.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlphabetDecode {

    private static Map<Integer, Character> mapping = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 26; i++)
            mapping.put(i, (char)('a' + i - 1));
        System.out.println(decode(0, new StringBuffer(), "111"));
    }
    static Set<String> decode(int start, StringBuffer code, String input) {
        Set<String> allPossibleWords = new HashSet<>();
        if(input.length() == start) {
            allPossibleWords.add(code.toString());
            return allPossibleWords;
        }
        for (int i = start; i < input.length(); i++){
            int key = Integer.parseInt(input.substring(start, i+1));
            if (mapping.containsKey(key)) {
                code.append(mapping.get(key));
                allPossibleWords.addAll(decode(i + 1, code, input));
                code.deleteCharAt(code.length() - 1);
            }
            else break;
        }
        return allPossibleWords;
    }
}
