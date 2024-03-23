package org.example.basic;

public class MergeArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if(nums1[i] > nums2[j]) {
                for (int k = m; k > i; k--) {
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j++;
                i++;
                m++;
            } else {
                i++;
            }
        }

        while (j < n) {
            nums1[i] = nums2[j];
            i++;
            j++;
        }
    }
    public static void main(String args[]) {
        int[] x={4,5,6,0,0,0};
        int[] y={1,2,3};

        merge (x, 3, y, 3);
        for (int i = 0; i < 6; i++) {
            System.out.println("x " + x[i]);
        }
    }

}
