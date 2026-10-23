package org.example.google;

public class findSameSqaure {
}

//        1 1 1
//        1 1 0
//        0 0 0
//
//
//        1 1
//        1 1
//
//        1
//
//        0 0 0
//
//        0,0  0,1 0,2
//
//        1,0. 1,1 1,2
//
//        1 1 1
//        1 1 1
//
//
//public List<Coordinate> findSimilarColorBlocks(int[][] grid) {
//    List<Coordinate> result = new ArrayList<>();
//    for (int i = 0; i < grid.length; i++) {
//        for(int j = 0; j < grid[0].length; j++) {
//            if (grid[i][j] != Integer.MAX_VALUE) {
//                Coordinate c = new Coordinate(i, j, i, j);
//                findGrid(grid, i, j, grid[i][j]);
//                result.add(c);
//            }
//        }
//    }
//    return result;
//}
//
//public void findGrid(int[][] grid, int i, int j, int value, Coordinate c) {
//    boolean grow = true;
//    //horizontal grow
//    for(int k = c.topLeft.i+j; k <= j; k++){
//        if(grid[k][j] != value) {
//            grow = false;
//            break;
//        }
//    }
//
//    c.setNew()
//
//}







