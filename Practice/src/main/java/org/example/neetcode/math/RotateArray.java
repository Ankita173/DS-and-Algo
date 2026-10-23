package org.example.neetcode.math;

public class RotateArray {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4},{12, 13, 14, 5}, {11, 16, 15, 6},{10, 9, 8, 7}};
        rotate(input);
    }

    public static void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        while (l < r) {
            int n = r - l;
            for (int j = 0; j < n; j++) {
                int temp = matrix[l][l+j];
                matrix[l][l+j] = matrix[r - j][l];
                matrix[r - j][l] = matrix[r][r-j];
                matrix[r][r-j] = matrix[l + j][r];
                matrix[l + j][r] = temp;
            }
            l++;
            r--;
        }
    }
}
