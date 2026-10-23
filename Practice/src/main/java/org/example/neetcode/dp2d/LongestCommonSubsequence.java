package org.example.neetcode.dp2d;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcd", "bdef"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()+1][text1.length()+1];

        for(int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >=0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) memo[i][j] = 1 + memo[i+1][j+1];
                else memo[i][j] = Math.max(memo[i+1][j], memo[i][j+1]);
            }
        }
        return memo[0][0];
    }
}
