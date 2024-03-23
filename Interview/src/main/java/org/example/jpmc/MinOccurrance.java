package org.example.jpmc;

import java.util.LinkedHashMap;
import java.util.Map;

public class MinOccurrance {

    public static void main(String[] args) {
        System.out.println(minOccurrence("This is heights!"));
    }

    static char minOccurrence(String input) {
        input = input.toLowerCase();
        Map<Character, Integer> freq = new LinkedHashMap<>();
        int max = 0;
        char maxChar = '1';
        for(char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (max < freq.get(c)) {
                max = freq.get(c);
                maxChar = c;
            }
        }
        int min = input.length() + 1;
        char minchar = '1';
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                minchar = entry.getKey();
            }
        }
        System.out.println("Min char: "+minchar);
        System.out.println("Max char: "+maxChar);
        return minchar;
    }
}
