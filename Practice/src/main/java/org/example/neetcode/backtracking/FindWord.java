package org.example.neetcode.backtracking;

public class FindWord {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(exist(board, "ABCB"));
    }

    static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if (nextCharacter(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }



    static boolean nextCharacter(char[][] board, String word, int index, int i, int j) {
        if (index >= word.length())
            return true;
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 ) return false;
        if (word.charAt(index) == board[i][j]) {
            board[i][j] += 100;
            if (nextCharacter(board, word, index+1, i, j+1) || //right
            nextCharacter(board, word, index+1, i, j-1) || //left
            nextCharacter(board, word, index+1, i-1, j) || //up
            nextCharacter(board, word, index+1, i+1, j)) //down
                return true;
            board[i][j] -= 100;
        }
        return false;
    }
}
