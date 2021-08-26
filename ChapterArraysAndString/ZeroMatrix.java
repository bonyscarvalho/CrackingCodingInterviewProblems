
//73. Set Matrix Zeroes
public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        boolean rowsHasZero = false;
        boolean colHasZero = false;

        for(int idx = 0; idx < matrix.length; idx++){
            if(matrix[idx][0] == 0){
                colHasZero = true;
                break;
            }
        }
        for(int idx = 0; idx < matrix[0].length; idx++){
            if(matrix[0][idx] == 0){
                rowsHasZero = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                nullifyRow(matrix, i);
            }
        }
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                nullifyCol(matrix, i);
            }
        }

        if(rowsHasZero){
            nullifyRow(matrix, 0);
        }
        if (colHasZero) {
            nullifyCol(matrix, 0);
        }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for(int i = 0; i < matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }
    private static void nullifyCol(int[][] matrix, int col) {
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
}
