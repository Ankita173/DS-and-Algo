package org.example.niro;

import java.util.HashMap;
import java.util.Map;

public class DeckPartition {

//    You are given an integer array deck where deck[i] represents the number written on the ith card.
//    Partition the cards into one or more groups such that:  Each group has exactly x cards where x > 1, and
//    All the cards in one group have the same integer written on them.  Return true if such partition is possible,
//    or false otherwise.   Example 1:  Input: deck = [1,2,3,4,4,3,2,1]  Output: true  Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
//    Example 2:   Input: deck = [1,1,1,2,2,2,3,3]  Output: false  Explanation: No possible partition. /
//   2 3 4

    public static void main(String[] args) {
       int[]  deck = {1,2,3,4,4,3,2,1};
        System.out.println(isPartitionPossible(deck));
        int[]  deck2 = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3};
        System.out.println(isPartitionPossible(deck2));
    }

    static boolean isPartitionPossible(int[] deck) {
        Map<Integer, Integer> freq = new HashMap<>();
        int min = 0;
        for (int i = 0; i < deck.length; i++) {
            freq.put(deck[i], freq.getOrDefault(deck[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            min = gcd(min, entry.getValue());
        }

        if (min > 1) return true;
        return false;
    }

    public static int gcd(int a, int b) { if (b == 0) { return a; } return gcd(b,a%b); }

}
