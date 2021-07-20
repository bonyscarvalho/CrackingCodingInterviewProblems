package LeetCodeMedium;

public class LongestIncreasingPathMatrix {
    //Clean Coding
    private static final int[][] directions ={{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static int rowLen, colLen;    // Assigning as Global so that can be used anywhere in Prog

    public static void main(String[] args)
    {
        int[][]  matrix = {{3,4,5},{3,2,6},{2,2,1}};
        int longestPath = longestIncreasingPath(matrix);
        System.out.println(longestPath);
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)return 0;
        rowLen = matrix.length;
        colLen = matrix[0].length;
        int[][] memo = new int[rowLen][colLen];

        int maxPath = 0;

        for (int r = 0; r < rowLen; r++){
            for (int c = 0; c < colLen; c++){
                maxPath = Math.max(maxPath, longestIncreasingPath(matrix, r, c, memo));
            }
        }

        return maxPath;
    }

    private static int longestIncreasingPath(int[][] matrix, int r, int c, int[][] memo) {
        if(memo[r][c] > 0) return memo[r][c];

        int currMaxPath = 0;
        for(int[] dir : directions){
            int row_dir = dir[0] + r;
            int col_dir = dir[1] + c;

            if(isValidDirection(row_dir, col_dir) && matrix[r][c] < matrix[row_dir][col_dir]){
                currMaxPath = Math.max(currMaxPath , longestIncreasingPath(matrix, row_dir, col_dir, memo));
            }
        }
        memo[r][c] = currMaxPath + 1; //Including self

        return memo[r][c];
    }

    private static boolean isValidDirection(int row_dir, int col_dir) {
        return row_dir >= 0 && row_dir < rowLen && col_dir >= 0 && col_dir < colLen;
    }

}
