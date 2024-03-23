package org.example.microsoft;

import java.util.HashSet;
import java.util.Set;

public class Question {

    public static void main(String[] args) {
        System.out.println(solution("aaAbcCABBc"));
    }

    static int solution(String letters) {
        Set<Character> answer = new HashSet<>();
        Set<Character> smallSeen = new HashSet<>();
        Set<Character> invalid = new HashSet<>();
        for (int i = 0; i < letters.length(); i++){
            if (invalid.contains(letters.charAt(i))) continue;
            if(letters.charAt(i) <= 'z' && letters.charAt(i) >= 'a') {
                if (invalid.contains(Character.toUpperCase(letters.charAt(i))) && answer.contains(letters.charAt(i))) {
                    answer.remove(letters.charAt(i));
                }
                smallSeen.add(letters.charAt(i));
            }
            else if (smallSeen.contains((char)(letters.charAt(i) + 32))) {
                answer.add((char)(letters.charAt(i) + 32));
                invalid.add(letters.charAt(i));
                smallSeen.remove((char)(letters.charAt(i) + 32));
            }
        }
        return answer.size();
    }


}
