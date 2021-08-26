package LeetCodeMedium;
//419. Battleships in a Board
public class BattleshipsInBoard {
    public static void main(String[] args) {
        char[][] board1 = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        char[][] board2 = {{'.'}};
        System.out.println(countBattleships(board1));
        //System.out.println(countBattleships(board2));
        System.out.println(countBattleshipsDFS(board1));
    }

    private static int countBattleshipsDFS(char[][] board) {
        if(board.length == 0) return 0;

        int battleShipCount = 0;
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X'){
                    battleShipCount++;
                    dfs(i, j, board);
                }
            }
        }

        return battleShipCount;
    }

    private static void dfs(int i, int j, char[][] board) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.'){
            return;
        }

        board[i][j] = '.';
        dfs(i - 1,j, board);
        dfs(i + 1,j, board);
        dfs(i,j - 1, board);
        dfs(i,j + 1, board);
    }

    public static int countBattleships(char[][] board) {
        if(board.length == 0) return 0;

        int battleShipCount = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(i > 0 && board[i - 1][j] == 'X'){
                    continue;
                }
                if(j > 0 && board[i][j-1] == 'X'){
                    continue;
                }
                battleShipCount++;
            }
        }

        return battleShipCount;
    }
}
