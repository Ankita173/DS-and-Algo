package org.example.neetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/word-search/description/
public class WordSearch {
    public static void main(String[] args) {
        char[][] input = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        System.out.println(exist(input, word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += 100;
                if(isWordPossible(board, word, i, j, 1)) return true;
                board[i][j] -= 100;
            }
        }
        return false;
    }

    private static boolean isWordPossible(char[][] board, String word, int i , int j, int p) {
        if (p >= word.length()) return true;
        board[i][j] += 100;
        if (i+1 < board.length && word.charAt(p) == board[i+1][j]) {
            if (isWordPossible(board, word, i+1 , j, p+1)) return true;
        }

        if (i-1 >= 0 && word.charAt(p) == board[i-1][j]) {
            if (isWordPossible(board, word, i-1 , j, p+1)) return true;
        }

        if (j+1 < board[0].length && word.charAt(p) == board[i][j+1]) {
            if (isWordPossible(board, word, i , j+1, p+1)) return true;
        }

        if (j-1 >= 0 && word.charAt(p) == board[i][j-1]) {
            if (isWordPossible(board, word, i , j-1, p+1)) return true;
        }
        board[i][j] -= 100;
        return false;
    }
}
