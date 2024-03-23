package org.example.linkedin;

import java.util.*;

public class ShortestWordDistance {
    Map<String, List<Integer>> dict;
    public ShortestWordDistance(List<String> words) {
        this.dict = new HashMap<>();
        for (int i = 0; i < words.size(); i++){
            List<Integer> index = dict.getOrDefault(words.get(i), new ArrayList<>());
            index.add(i);
            dict. put(words.get(i).toLowerCase(), index);
        }
    }

    public int shortestDistanceBetweenWords(String word1, String word2) {
        List<Integer> index1 = dict.get(word1.toLowerCase());
        List<Integer> index2 = dict.get(word2.toLowerCase());
        if (index1 == null || index1.isEmpty() || index2 == null || index2.isEmpty())
            return -1;
        else if (index1.size() == 1 && index2.size() == 1)
            return Math.abs(index1.get(0) - index2.get(0));
        return merge(index1, index2);
    }

    private int merge(List<List<Integer>> array) {
        int[] index = new int[array.size()];
        while(true) {
            for (int i = 0; i < array.size() - 1; i++) {
                int minIndex = 0;
                int minRow = 0;

            }
        }
    }

    private int merge(List<Integer> array1, List<Integer> array2) {
        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;
        while (i < array1.size() && j < array2.size()) {
            if (array1.get(i) < array2.get(j)) {
                int diff =  array2.get(j) - array1.get(i);
                minDiff = minDiff > diff ? diff : minDiff;
                i++;
            } else {
                int diff =  array1.get(i) - array2.get(j);
                minDiff = minDiff > diff ? diff : minDiff;
                j++;
            }
        }
        return minDiff;
    }
}

class Execute {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("this", "is", "this" , "ankita", "gupta", "good","gupta", "this");
        ShortestWordDistance w = new ShortestWordDistance(list);
        System.out.println(w.shortestDistanceBetweenWords("gupta", "this"));
    }
}
