package org.example.neetcode.stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    static int evalRPN(String[] tokens) {
        Stack<Integer> digits = new Stack<>();
        for(String t : tokens) {
            try {
                digits.push(Integer.parseInt(t));
            } catch (Exception e) {
                int second = digits.pop();
                int first = digits.pop();
                switch (t) {
                    case "+":
                        digits.push(first+second);
                        break;
                    case "-":
                        digits.push(first-second);
                        break;
                    case "*":
                        digits.push(first*second);
                        break;
                    case "/":
                        digits.push(first/second);
                        break;
                }
            }
        }
        return digits.pop();
    }
}
