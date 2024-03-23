package org.example.neetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        backtrack(3, 3, new StringBuilder(), list);
        System.out.println(list);
    }

    static void backtrack(int open, int close, StringBuilder sb, List<String> list) {
        if (close == 0) {
            list.add(sb.toString());
            return;
        }
        if (open > 0) {
            backtrack(open-1, close, sb.append("("), list);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close > 0 && open != close) {
            backtrack(open, close-1, sb.append(")"), list);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}