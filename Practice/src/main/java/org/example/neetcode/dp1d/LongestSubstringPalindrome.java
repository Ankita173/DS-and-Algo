package org.example.neetcode.dp1d;

public class LongestSubstringPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("a"));
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


    public static String longestPalindrome2(String s) {
        int maxlen = 0, l, r;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for(l = i, r = i; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) {
                if (maxlen < (r - l + 1)) {
                    maxlen = r - l + 1;
                    result = s.substring(l, r+1);
                }
            }

            for (l = i, r = i+1; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) {
                if (maxlen < (r - l + 1)) {
                    maxlen = r - l + 1;
                    result = s.substring(l, r+1);
                }
            }
        }
        return result;
    }
}
