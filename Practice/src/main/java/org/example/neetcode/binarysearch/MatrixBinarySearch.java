package org.example.neetcode.binarysearch;

public class MatrixBinarySearch {

    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50},{231,301,341,501},{2312,3012,3412,5012}};
        int[][] matrix = {{1}};
        System.out.println(searchMatrix(matrix, 2));
//        System.out.println(searchMatrix(matrix, 5));
//        System.out.println(searchMatrix(matrix, 7));
//        System.out.println(searchMatrix(matrix, 10));
//        System.out.println(searchMatrix(matrix, 11));
//        System.out.println(searchMatrix(matrix, 31));
//        System.out.println(searchMatrix(matrix, 16));
//        System.out.println(searchMatrix(matrix, 20));
//        System.out.println(searchMatrix(matrix, 231));
//        System.out.println(searchMatrix(matrix, 3012));

    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length) {
            if(matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                break;
            else
                i++;
        }
        if (i >= matrix.length) return false;
        int k = 0;
        while (k <= j) {
            int mid = (k+j)/ 2;
            if(matrix[i][mid] == target)
                return true;
            else if (matrix[i][mid] > target)
                j = mid - 1;
            else
                k = mid + 1;
        }
        return false;
    }

}
