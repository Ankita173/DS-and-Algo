package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{2,5,8},{4,0,-1}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        boolean skip = true;
        while (top <= bottom || left <= right) {
            skip = true;
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
                skip = false;
            }
            top++;
            if (skip) break;
            skip = true;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
                skip = false;
            }
            right--;
            if (skip) break;
            skip = true;
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
                skip = false;
            }
            bottom--;
            if (skip) break;
            skip = true;
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
                skip = false;
            }
            left++;
            if (skip) break;
        }
        return list;
    }
}
