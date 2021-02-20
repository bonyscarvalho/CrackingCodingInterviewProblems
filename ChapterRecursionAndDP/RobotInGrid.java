package ChapterRecursionAndDP;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class RobotInGrid {
    public static void main(String[] args) {
        int row = 4, col = 4;
        boolean[][] grid = {
                {true,true, true, true},
                {true, true, false, true},
                {true, false, true, true},
                {false, true, false, true}
        };

        boolean pathFromLeftToBottom = isTherePath(grid);
        System.out.println("Path: " + pathFromLeftToBottom);

        ArrayList<Point> path = getPath(grid);
        System.out.println("Path: " + path);    // x-> row y -> col
    }

    //TOP-Down Approach
    private static ArrayList<Point> getPath(boolean[][] grid) {
        if(grid == null || grid.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();

        if(getPaths(grid, grid.length - 1, grid[0].length - 1, path, failedPoints)){
            return path;
        }
        return null;
    }

    private static boolean getPaths(boolean[][] grid, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        if(row < 0 || col < 0 || !grid[row][col]) return false;

        Point p = new Point(row,col);
        if(failedPoints.contains(p)){
            return false;
        }
        boolean isOrigin = (row == 0 && col == 0);

        if(isOrigin || getPaths(grid, row - 1, col, path, failedPoints) || getPaths(grid, row, col - 1, path, failedPoints)){
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }

    private static boolean isTherePath(boolean[][] grid) {
        if (grid == null || grid.length == 0) return false;

        boolean[][] dp = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++){
            dp[i][0] = grid[i][0];
        }
        for (int i = 0; i < grid.length; i++){
            dp[0][i] = grid[0][i];
        }
        //dp[0][0] = true;

        for (int i = 1; i < grid.length; i++){
            for (int j = 1; j < grid[0].length; j++){
                dp[i][j] = grid[i - 1][j] || grid[i][j - 1];
            }
        }

        return dp[grid.length - 1][grid.length - 1];
    }


}
