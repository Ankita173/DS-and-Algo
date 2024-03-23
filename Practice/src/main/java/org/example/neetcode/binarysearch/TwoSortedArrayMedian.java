package org.example.neetcode.binarysearch;

public class TwoSortedArrayMedian {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] merged = new int[total];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                merged[k] = nums2[j];
                j++;
                k++;
            } else {
                merged[k] = nums1[i];
                i++;
                k++;
            }
        }
        while(i < nums1.length) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while(j < nums2.length) {
            merged[k] = nums2[j];
            j++;
            k++;
        }
        int med = total/2;
        if(total % 2 == 0) {
            return (merged[med] + merged[med-1]) / 2d;
        }
        return merged[med];

    }
}
