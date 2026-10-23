package org.example.neetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] input = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
        System.out.println(pacificAtlantic(input));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int column = heights[0].length;
        boolean[][] atl = new boolean[row][column];
        boolean[][] pac = new boolean[row][column];

        for (int r = 0; r < row; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, column-1, atl, heights);
        }

        for (int c = 0; c < column; c++) {
            dfs(0, c, pac, heights);
            dfs(row-1, c, atl, heights);
        }


        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (atl[i][j] && pac[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static void dfs(int r, int c, boolean[][] ocean, int[][] height) {
        ocean[r][c] = true;

        for (int[] d : direction){
            int rd = r + d[0];
            int cd = c + d[1];
            if (rd >= 0 && rd < height.length &&
                cd >= 0 && cd < height[0].length &&
                !ocean[rd][cd] &&
                height[r][c] <= height[rd][cd])
                dfs(rd, cd, ocean, height);
        }
    }
}
