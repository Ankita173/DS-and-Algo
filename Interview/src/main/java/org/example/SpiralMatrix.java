package org.example;

public class SpiralMatrix {

    public static void main(String[] args) {
        int n = 5;
        int[][] spiral = generateMatrix(n);
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.println(spiral[i][j]);
        }

    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (top <= bottom || left <= right) {
            for (int i = left; i <= right; i++, count++) {
                matrix[top][i] = count;
            }
            top++;
            for (int i = top; i <= bottom; i++, count++) {
                matrix[i][right] = count;
            }
            right--;
            for (int i = right; i >= left; i--, count++) {
                matrix[bottom][i] = count;
            }
            bottom--;
            for (int i = bottom; i >= top; i--, count++) {
                matrix[i][left] = count;
            }
            left++;
        }
        return matrix;
    }
}
