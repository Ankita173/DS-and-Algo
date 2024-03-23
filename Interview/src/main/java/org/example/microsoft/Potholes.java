package org.example.microsoft;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Potholes {
    public static void main(String[] args) {
        System.out.println(solution("..xxxx", 4));
    }
    static int solution(String S, int B) {
        List<Integer> potholes = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            int count = 0;
            if (S.charAt(i) == 'x') {
                while(i < S.length() && S.charAt(i) == 'x') {
                    count++;
                    i++;
                }
                potholes.add(count);
            }
        }
        potholes.sort(Collections.reverseOrder());
        int fixed = 0;
        for (int i = 0; i < potholes.size() && B > 0; i++) {
            int poth = potholes.get(i);
            while (poth + 1 > B) poth--;
            fixed += poth;
            B = B - poth - 1;
        }
        return fixed;
    }
}
