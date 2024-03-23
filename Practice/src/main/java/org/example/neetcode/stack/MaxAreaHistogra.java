package org.example.neetcode.stack;

import java.util.Stack;

public class MaxAreaHistogra {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    static int largestRectangleArea(int[] heights) {
        Stack<Bar> bar = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int backIndex = i;
            while (!bar.isEmpty() && bar.peek().height > heights[i]) {
                Bar b = bar.pop();
                backIndex = b.index;
                int area = b.height * (i - backIndex);
                maxArea = area > maxArea ? area : maxArea;
            }
            bar.push(new Bar(backIndex, heights[i]));
        }

        while (!bar.isEmpty()) {
            Bar b = bar.pop();
            int area = b.height * (heights.length - b.index);
            maxArea = area > maxArea ? area : maxArea;
        }
        return maxArea;
    }
}

class Bar {
    int index;
    int height;
    Bar(int index, int height) {
        this.height = height;
        this.index = index;
    }
}
