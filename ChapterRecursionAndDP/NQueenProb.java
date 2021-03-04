package ChapterRecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueenProb {
    static int numOfQueens = 4;
    public static void main(String[] args) {
        int[][] chessBoard = new int[4][4];
        Integer[] colums = new Integer[4];
        ArrayList<Integer[]> results = new ArrayList<>();

        placeQueens(0, colums, results);
        System.out.println("Results: "+ results);

    }

    private static void placeQueens(int rowNum, Integer[] colums, ArrayList<Integer[]> results) {
        if(rowNum == numOfQueens){
            System.out.println("Result: ");
            Arrays.stream(colums).forEach(System.out::println);
            results.add(colums.clone());
            System.out.println("-------------------------------------------");
        }else {
            for(int col = 0; col < numOfQueens; col++){
                System.out.println("ALL---- Row: " + rowNum +" Col: "+ col);
                if(checkQueensValidPosition(colums, col, rowNum)){
                    //System.out.println("Valid---- Row: " + rowNum +" Col: "+ col);
                    colums[rowNum] = col;
                    placeQueens(rowNum + 1, colums, results);
                }
            }
        }

    }

    private static boolean checkQueensValidPosition(Integer[] colums, int col1, int row1) {
        //check if col2 and row2 invalidates col1 and row1
        for(int row2 = 0; row2 < row1; row2++){
            int col2 = colums[row2];   //check for every value what is pasted from 0 to row1. For 1st case it will be always true

            if(col2 == col1) return false;  // you are checking for columns as you are adding one by one columns

            int rowDistance = Math.abs(row1 - row2);
            int colDistance = Math.abs(col1 - col2);

            if(rowDistance == colDistance){     //Slope of a line if they are diagonal then the differnce of rows and columns will be always same
                return false;
            }
        }
        return true;
    }
}
