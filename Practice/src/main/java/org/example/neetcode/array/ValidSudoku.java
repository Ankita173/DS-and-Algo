package org.example.neetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        List<Set<Character>> row = new ArrayList<>();
        List<Set<Character>> column = new ArrayList<>();
        List<Set<Character>> block = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            column.add(new HashSet<>());
            block.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j= 0; j < 9; j++) {
                Set<Character> rowSet = row.get(i);
                Set<Character> columnSet = column.get(j);
                int blockNo = (2*(i/3))+ i/3 + j/3;
                Set<Character> blockSet = block.get(blockNo); // identify block
                char c = board[i][j];
                if (c != '.') {
                    if (rowSet.contains(c)) return false;
                    else rowSet.add(c);

                    if (columnSet.contains(c)) return false;
                    else columnSet.add(c);

                    if (blockSet.contains(c)) return false;
                    else blockSet.add(c);
                }
            }
        }
        return true;
    }
}
