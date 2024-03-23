package org.example.neetcode.dp1d;

//duplicated allowed
public class SubStringPalindromeCount {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa")); //a a a aa aa aaa = 6
    }

    public static int countSubstrings(String s) {
        int count = 0;
        //odd palindrome
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; i-j >= 0 &&
                    i+j < s.length() &&
                    s.charAt(i-j) == s.charAt(i+j); j++) {
                count++;
            }
        }
        //even palindrome
        for (int i = 0, k = 1; k < s.length(); i++, k++){
            for (int j = 0; i-j >= 0 &&
                    k+j < s.length() &&
                    s.charAt(i-j) == s.charAt(k+j); j++) {
                count++;
            }
        }
        return count;
    }
}
