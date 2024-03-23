package org.example.neetcode.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while(l<r) {
            int area = (r-l) * Math.min(height[l], height[r]);
            max = area > max ? area : max;
            if (height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }

}
