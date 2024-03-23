package org.example.basic;

public class ReverseString {

    public static void main(String[] args) {

        String name = "sarankita";
        printString(name);
        printReverseString(name);
    }

    private static void printReverseString(String name) {
        StringBuilder sb = new StringBuilder();
        for (int index = name.length() - 1; index >=0; index--) {
            sb.append(name.charAt(index));
        }
        printString(sb.toString());
    }

    private static void printString(String name) {
        for (char c : name.toCharArray()) {
            System.out.print(c);
        }
        System.out.println();
    }
}
