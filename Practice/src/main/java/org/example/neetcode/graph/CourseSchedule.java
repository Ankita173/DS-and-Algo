package org.example.neetcode.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule {
    static Set<Integer> visited;
    public static void main(String[] args) {
        int course1 = 3;
        int[][] prereq1 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(canFinish(course1, prereq1));

        int course2 = 5;
        int[][] prereq2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};
        System.out.println(canFinish(course2, prereq2));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        visited = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = courseMap.getOrDefault(prerequisites[i][0], new ArrayList<>());
            list.add(prerequisites[i][1]);
            courseMap.put(prerequisites[i][0], list);
            if (!courseMap.containsKey(i)) courseMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, courseMap))
                return false;
        }
        return true;
    }


    private static boolean dfs(int index, Map<Integer, List<Integer>> courseMap) {
        if(visited.contains(index)) return false;
        List<Integer> prereq = courseMap.get(index);
        if (prereq.isEmpty()) return true;

        visited.add(index);
        for (int i = 0; i < prereq.size(); i++) {
            if(dfs(prereq.get(i), courseMap)) prereq.remove(i);
            else return false;
        }
        visited.remove(index);
        return true;
    }
}
