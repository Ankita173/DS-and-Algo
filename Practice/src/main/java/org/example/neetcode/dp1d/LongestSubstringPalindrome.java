package org.example.neetcode.dp1d;

public class LongestSubstringPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String longest = "";
        int l = 0;
        //odd palindrome
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; i-j >= 0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j); j++) {
                if (l < 2*j + 1) {
                    l = 2*j + 1;
                    longest = s.substring(i - j, i + j + 1);
                }
            }
        }
        //even palindrome
        for (int i = 0, k = 1; k < s.length(); i++, k++){
            for (int j = 0; i-j >= 0 && k+j < s.length() && s.charAt(i-j) == s.charAt(k+j); j++) {
                if (l < (k+j) - (i-j) + 1) {
                    l = (k+j) - (i-j) + 1;
                    longest = s.substring(i - j, k + j + 1);
                }
            }
        }
        return longest;
    }
}
