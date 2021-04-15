package ChapterModerate;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PondSizes {
    public static void main(String[] args)
    {
        int[][] pond = {{0, 2, 1, 0},
                        {0, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 0, 1}};

        //boolean[][] visited = new boolean[pond.length][pond[0].length];
        ArrayList<Integer> results = new ArrayList<>();

        for (int row = 0; row < pond.length; row++){
            for (int col = 0; col < pond[0].length; col++){
                int size = computePondSize(row, col, pond);     //computePondSize(row, col, pond, visited);
                if (size > 0) results.add(size);
            }
        }

        System.out.println("Result: " +results);


//        Arrays.stream(memo).forEach(val -> Arrays.stream(val).forEach(va -> System.out.println(va)));
    }

    private static int computePondSize(int row, int col, int[][] pond) {
        if(row < 0 || row >= pond.length || col < 0 || col >= pond[0].length || pond[row][col] != 0){   //visited[row][col]
            return 0;
        }

        int size = 1;
        pond[row][col] = -1;
        //visited[row][col] = true;

        for(int dr = -1; dr <= 1; dr++){
            for (int dc = -1; dc <= 1; dc++){
                size += computePondSize(row + dr, col+dc, pond);
            }
        }
        return size;
    }

//    private static void computePondSize(int[][] pond, int[][] memo) {
//        if(pond.length == 0) return;
//
//        for (int i = 0; i < pond.length; i++){
//            for (int j = 0; j < pond.length; j++){
//                if(pond[i][j] != 0){
//                    memo[i][j] = 0;
//                }else {
//                    memo[i][j] = 1 + maxVal(pond,memo, i, j);
//                }
//            }
//        }
//    }
//
//    private static int maxVal(int[][] pond, int[][] memo, int i, int j) {
//        int upperVal = (i-1 < 0) ? 0 : memo[i-1][j];
//        int diagonalVal = (i-1 < 0 || j-1 < 0) ? 0 : memo[i-1][j-1];
//        int leftVal = (j-1 < 0) ? 0 : memo[i][j-1];
//        int upperRightVal  = (i - 1 < 0 || j + 1 >= pond.length) ? 0 : memo[i-1][j+1];
//
//        return Math.max(upperVal, Math.max(diagonalVal, Math.max(leftVal, upperRightVal)));
//    }
}
