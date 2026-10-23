package org.example.neetcode.graph;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] input = {"hrn","hrf","er","enn","rfnn"};
        System.out.println(foreignDictionary(input));
    }

    public static String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> connected = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // init the connected sequence and path indegree with unique characters in the input
        for (String word : words) {
            for (char c : word.toCharArray()) {
                connected.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int minlen = Math.min(first.length(), second.length());
            if (first.length() > second.length() && first.substring(0, minlen).equals(second.substring(0, minlen)))
                return "";

            for (int j = 0; j < minlen; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    if (!connected.get(first.charAt(j)).contains(second.charAt(j))) {
                        connected.get(first.charAt(j)).add(second.charAt(j));
                        indegree.put(second.charAt(j), indegree.get(second.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char key : indegree.keySet()) {
            if(indegree.get(key) == 0)
                queue.offer(key);
        }

        StringBuffer result = new StringBuffer();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            for (char neighbour : connected.get(c)) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if (indegree.get(neighbour) == 0)
                    queue.offer(neighbour);
            }
        }

        if (result.length() != indegree.size()) return "";
        return result.toString();
    }
}
