package org.example;

public class MostVisitedTrack {
    public static void main(String[] args) {
        int[] sprints = {1, 5, 4, 2};
        System.out.println(mostVisitedTrack(5, sprints));
    }

    static int mostVisitedTrack(int n, int[] sprints) {
        int[] visitedTrack = new int[n];
        for (int i = 0; i < sprints.length - 1; i++) {
            int start = sprints[i] > sprints[i+1] ? sprints[i] : sprints[i+1];
            int end = (sprints[i] < sprints[i+1] ? sprints[i] : sprints[i+1]) - 1;
            while(--start >= end) {
                visitedTrack[start] += 1;
            }
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (visitedTrack[max] < visitedTrack[i])
                max = i;
        }
        return max+1;
    }
}
