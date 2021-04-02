package ChapterModerate;

public class TicTacToe {
    public static void main(String args[]) {
        String[][] board = {{"","X","X"},
                            {"X","0","0"},
                            {"0","X","X"}};
        System.out.println("Winner: "+computeWinner(board));
    }

    private static String computeWinner(String[][] board) {
        if(board.length != board[0].length) return "Not Valid";

        for(int i = 0; i < board.length; i++){
            if(hasWinner(board[i][0], board[i][1], board[i][2])){   //Row
                return board[i][0];
            }
            if(hasWinner(board[0][i], board[1][i], board[2][i])){
                return board[0][i];
            }
        }

        if(hasWinner(board[0][0], board[1][1], board[2][2])){
            return board[0][0];
        }
        if(hasWinner(board[2][0], board[1][1], board[0][2])){
            return board[2][0];
        }
        return "No Winner";
    }

    private static boolean hasWinner(String p1, String p2, String p3) {
        if(p1.equals("")) return false;

        return p1.equals(p2) && p2.equals(p3);
    }
}
