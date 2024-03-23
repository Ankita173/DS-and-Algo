package org.example.neetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public static void main(String[] args) {
        int target = 10;
        int[] position = {6,8}, speed = {3,2};
        System.out.println(carFleet(target, position, speed));
    }

    static int carFleet(int target, int[] position, int[] speed) {
        int c = position.length;
        if (c < 2) return c;
        int[][] cars = new int[c][2];
        for(int i = 0; i < c; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, java.util.Comparator.comparingInt(o -> o[0]));

        Stack<Double> fleet = new Stack<>();
        for (int i = c-1; i >= 0; i--){
            double cTime = (double)(target - cars[i][0])/cars[i][1];
            if (!fleet.isEmpty() && fleet.peek() >= cTime)
                continue;
            else
                fleet.push(cTime);
        }
        return fleet.size();
    }
}