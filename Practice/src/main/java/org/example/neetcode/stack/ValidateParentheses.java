package org.example.neetcode.stack;

import java.util.Stack;

public class ValidateParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
        System.out.println(isValid("]["));
        System.out.println(isValid("{}[]()"));
        System.out.println(isValid("[{}]({}[])"));
    }
    static boolean isValid(String s) {
        Stack<Character> pts = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!pts.isEmpty()) {
                switch(c) {
                    case ')':
                        if (pts.peek() == '(')
                            pts.pop();
                        else return false;
                        continue;
                    case '}':
                        if (pts.peek() == '{')
                            pts.pop();
                        else return false;
                        continue;
                    case ']':
                        if (pts.peek() == '[')
                            pts.pop();
                        else return false;
                        continue;
                }
            }
            pts.push(c);
        }
        if(!pts.isEmpty()) return false;
        return true;
    }
}
