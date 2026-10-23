package org.example.neetcode.graph;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(findIslands(grid1));

        char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(findIslands(grid2));
    }

    private static int findIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    fillIsland(grid, i, j);
                }
            }
        }
        return islands;
    }
    private static void fillIsland(char[][] grid, int i , int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        fillIsland(grid, i+1, j);
        fillIsland(grid, i-1, j);
        fillIsland(grid, i, j+1);
        fillIsland(grid, i, j-1);
    }
}
