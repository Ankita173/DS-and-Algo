package org.example.neetcode.math;

import java.util.ArrayList;
import java.util.List;

public class SpiralArray {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}};

        System.out.println(spiralOrder(input));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        List<Integer> spiral = new ArrayList<>();
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) spiral.add(matrix[top][i]);
            top++;
            for (int i = top; i < bottom; i++) spiral.add(matrix[i][right-1]);
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            for (int i = right-1; i >= left; i--) spiral.add(matrix[bottom-1][i]);
            bottom--;
            for (int i = bottom-1; i >= top; i--) spiral.add(matrix[i][left]);
            left++;
        }

        return spiral;

    }
}
