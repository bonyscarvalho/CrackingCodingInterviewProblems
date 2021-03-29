package ChapterRecursionAndDP;

import java.util.ArrayList;

public class Parenthesis {
    public static void main(String[] args) {
        int numOfParens = 3;
        char [] str = new char[numOfParens * 2];
        ArrayList<String> results = new ArrayList<>();
        generateParens(numOfParens, numOfParens, 0, str, results);
        System.out.println("Results: " + results);
    }

    private static void generateParens(int leftParen, int rightParen, int totalIdx, char[] str, ArrayList<String> results) {
        if(leftParen < 0 || rightParen < leftParen) return;

        if(leftParen == 0 && rightParen == 0){
            results.add(String.copyValueOf(str));
            return;
        }else {
            str[totalIdx]  = '(';
            generateParens(leftParen - 1, rightParen, totalIdx + 1, str, results);

            str[totalIdx] = ')';
            generateParens(leftParen, rightParen - 1, totalIdx + 1, str, results);
        }

    }
}
