package org.example.epam;

import java.util.*;
import java.util.stream.Collectors;

public class Question {

    static class Vote {
        List<String> candidates;
        Vote (List<String> candidates) {
            this.candidates = candidates;
        }
    }


    public static void main(String[] args) {
        List<Vote> vote = new ArrayList<>();
        vote.add(new Vote(Arrays.asList("a","b","c")));
        vote.add(new Vote(Arrays.asList("d","b","q")));
        System.out.println(findWinner(vote));
    }

    static List<String> findWinner(List<Vote> votes) {
        Map<String, Integer> result = new HashMap<>();
        int n = 3;
        for(Vote vote : votes)  {
            List<String> v = vote.candidates;
            for(int i = 0; i < n; i++){
                result.put(v.get(i),
                        result.getOrDefault(v.get(i), 0) + n - i);
            }
        }
        return result.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(t -> t.getKey()).collect(Collectors.toList());
    }
}
