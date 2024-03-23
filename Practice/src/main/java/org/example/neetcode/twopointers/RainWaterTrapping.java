package org.example.neetcode.twopointers;

public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];
        for(int i = 1; i < height.length; i++) {
            int j = height.length-1-i;
            left[i] = Math.max(height[i], left[i-1]);
            right[j] = Math.max(height[j], right[j+1]);
        }
        int area = 0;
        for(int i = 0; i < height.length; i++) {
            area += Math.min(left[i], right[i]) - height[i];
        }
        return area;
    }
}
