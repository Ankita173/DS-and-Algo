package org.example.neetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidGraphTree {
    public static void main(String[] args) {

        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int nodes = 5;
        System.out.println(validTree(nodes, edges));

        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {1, 3}};
        int nodes1 = 5;
        System.out.println(validTree(nodes1, edges1));
    }
    static List<List<Integer>> paths = new ArrayList<>();
    static Set<Integer> visited = new HashSet<>();
    private static boolean validTree(int n, int[][] edges) {
        if (edges.length > n-1) return false;

        for (int i = 0; i < n; i++)
            paths.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++){
            paths.get(edges[i][0]).add(edges[i][1]);
            paths.get(edges[i][1]).add(edges[i][0]);
        }

        if (!dfs(0, -1))
            return false;

        return visited.size() == n;
    }

    private static boolean dfs(int index, int parent) {
        if(visited.contains(index)) return false;

        visited.add(index);
        for (int path : paths.get(index)) {
            if (path == parent) continue;
            if (!dfs(path, index)) return false;
        }
        return true;
    }
}
