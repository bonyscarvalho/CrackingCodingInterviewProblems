package LeetCodeMedium.MonotonicQueue;

import java.util.Arrays;

//221. Maximal Square
public class MaximalSquare {
    public static void main(String args[]) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
        System.out.println(maximalSquareOptimizedSpace(matrix));
    }

    public static int maximalSquareOptimizedSpace(char[][] matrix) {
        if(matrix.length == 0)return 0;

        int maxArea = 0;
        int[] prev = new int[matrix[0].length + 1];
        int[] curr = new int[matrix[0].length + 1];

        for(int row = 1; row <= matrix.length; row++){
            for(int col = 1; col <= matrix[0].length; col++){
                if(matrix[row - 1][col - 1] == '1'){
                    curr[col] = 1 + Math.min(curr[col - 1], Math.min(prev[col - 1], prev[col]));
                    maxArea = Math.max(maxArea, curr[col]);
                }else{
                    curr[col] = 0;
                }
            }
            prev = curr;
            curr = new int[matrix[0].length + 1];

        }

        return maxArea * maxArea;
    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0)return 0;

        int maxArea = 0;
        int[][] memo = new int[matrix.length + 1][matrix[0].length + 1];

        for(int row = 1; row < matrix.length; row++){
            for(int col = 1; col < matrix[0].length; col++){
                if(matrix[row - 1][col - 1] == '1'){
                    memo[row][col] = 1 + Math.min(memo[row][col-1], Math.min(memo[row -1][col - 1],memo[row - 1][col]));
                    maxArea = Math.max(maxArea, memo[row][col]);
                }
            }
        }

        return maxArea * maxArea;
    }
}
