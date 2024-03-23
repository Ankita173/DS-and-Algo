package org.example.basic.practice;

public class SubArrayMax {
    public static void main(String[] args) {
        int[] array = {9, 4, 1, 6 ,9};
        System.out.println(findMaxSubArray(array, 2));
    }

    static int findMaxSubArray(int[] array, int k) {
        int max = 0;
        for (int i = 0, p = 0; i < array.length; i++) {
            if (i < k)
                max += array[i];
            else {
                max -= array[p];
                int sum = max + array[i];
                if (max < sum)
                    max = sum;
                p++;
            }
        }
        return max;
    }
}
