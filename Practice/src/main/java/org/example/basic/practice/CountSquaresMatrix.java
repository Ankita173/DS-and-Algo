package org.example.basic.practice;

public class CountSquaresMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1}, {1,1,1,1},{0,1,1,1}};
        System.out.println(dp(matrix));
    }

    //Method 1 : using 2D DP where you treat every element as bottom right and check min + 1 with all adjacent element
    static int dp(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] square = new int[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0 || i == 0 || matrix[i][j] != 1)
                    square[i][j] = matrix[i][j];
                else {
                    int min = Math.min(square[i-1][j], Math.min(square[i][j-1], square[i-1][j-1]));
                    square[i][j] = min + 1;

                }
                count += square[i][j];
            }
        }
        return count;
    }


    //Method 2 : using recursion where you treat every element as top left and check how many level square is formed
    static int countSquares(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count += 1 + check(matrix, i, j, 1);
                }
            }
        }
        return count;
    }
    static int check(int[][] matrix, int i, int j, int level) {
        if(i+level < matrix.length && j+level < matrix[0].length) {
            for(int k = j; k <= j+level; k++)
                if(matrix[i+level][k] != 1) return 0;
            for(int k = i; k <= i+level; k++)
                if(matrix[k][j+level] != 1) return 0;
            return 1 + check(matrix, i, j, level+1);
        } return 0;
    }
}
