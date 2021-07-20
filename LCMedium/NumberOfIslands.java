package LeetCodeMedium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char [][] gridDFS = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','1'}};
        char [][] gridBFS = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','1'}};
//        char [][] grid = {
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}};


        int numberOfIslandsBFS = numIslandsBFS(gridBFS);
        int numberOfIslandsDFS =  numberOfIslandsDFS(gridDFS);
        System.out.println("DFS: " + numberOfIslandsDFS);
       System.out.println("BFS: " + numberOfIslandsBFS);
    }

    private static int numberOfIslandsDFS(char[][] grid) {
        if (grid.length == 0)return 0;
        //boolean[][] visitedGrid = new boolean[grid.length][grid[0].length];

        int totalIslands = 0;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};   //Clean Coding

        for(int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1' ){
                    //System.out.println("Row: " + row +" Col: " + col);
                    computeConnectedIslandsDFS(row, col, grid, dir);
                    totalIslands++;
                }
            }
        }

        return totalIslands;
    }

    private static void computeConnectedIslandsDFS(int row, int col, char[][] grid, int[][] dir) {
        if(grid[row][col] != '1') return;

        grid[row][col] = '0';

        for (int d = 0; d < dir.length; d++){
            int r = row + dir[d][0];
            int c = col + dir[d][1];

            if(isValidGrid(r,c, grid) && grid[r][c] == '1'){
                computeConnectedIslandsDFS(r, c, grid, dir);
            }
        }
    }

    public static int numIslandsBFS(char[][] grid) {
        if (grid.length == 0)return 0;
        //boolean[][] visitedGrid = new boolean[grid.length][grid[0].length];

        int totalIslands = 0;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for(int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1' ){ //&& !visitedGrid[row][col]){
                    //System.out.println("Row: " + row +" Col: " + col);
                    computeConnectedIslandsBFS(row, col, grid, dir);
                    totalIslands++;
                }
            }
        }

        return totalIslands;
    }

    private static void computeConnectedIslandsBFS(int row, int col, char[][] grid, int[][] dir) {
        if (grid[row][col] != '1') return;

        grid[row][col] = '0';
        Queue<int[]> connectedGrid = new LinkedList<>();
        connectedGrid.offer(new int[]{row, col});

        while (!connectedGrid.isEmpty()){
            int[] island = connectedGrid.poll();

            for(int d = 0; d < dir.length; d++){
                int r = island[0] + dir[d][0];
                int c = island[1] + dir[d][1];

                if(isValidGrid(r, c, grid) && grid[r][c] == '1'){
                    connectedGrid.offer(new int[]{r, c});
                    grid[r][c] = '0';
                }
            }
        }
    }

    private static boolean isValidGrid(int r, int c, char[][] grid) {
        return (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length);
    }
}
