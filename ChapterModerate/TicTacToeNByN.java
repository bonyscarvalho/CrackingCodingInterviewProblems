package ChapterModerate;

import java.util.ArrayList;

import static java.lang.System.*;

public class TicTacToeNByN {

    static class Check{
        public int row, column;
        private int rowIncrement, colIncrement;

        public Check(int row, int column, int rowIncrement, int colIncrement){
            this.row = row;
            this.column = column;
            this.rowIncrement = rowIncrement;
            this.colIncrement = colIncrement;
        }

        public void increment(){
            row += rowIncrement;
            column += colIncrement;
        }

        public boolean isBounds(int size){
            return row >=0 && column >= 0 && row < size && column < size;
        }
    }

    public static void main(String args[]) {
        String[][] board = {{"0","X","X","X"},
                            {"X","0","0","0"},
                            {"X","0","0","0"},
                            {"0","X","X","0"}};
        out.println("Winner: "+computeWinner(board));
    }

    private static String computeWinner(String[][] board) {
        if(board.length != board[0].length) return "Not Valid";
        int size = board.length;

        ArrayList<Check> instructions = new ArrayList<>();
        for (int i = 0; i < size ; i++){
            instructions.add(new Check(0, i, 1,0)); //Col: i : ROw 0, 1, 2, 3
            instructions.add(new Check(i,0,0,1)); //ROw: i  Col: 0, 1, 2, 3
        }
        instructions.add(new Check(0,0,1,1)); //Diagonal
        instructions.add(new Check(size - 1, 0, -1, 1)); // Other Diagonal

        for (Check check : instructions){
            String winner = hasWon(board, check);
            if(!winner.equals("No Winner")){
                return winner;
            }
        }
        return "No Winner";
    }

    private static String hasWon(String[][] board, Check check) {
        String firstVal = board[check.row][check.column];
        while (check.isBounds(board.length)){
            if(!board[check.row][check.column].equals(firstVal)){
                return "No Winner";
            }
            check.increment();
        }
        return firstVal;
    }
}
