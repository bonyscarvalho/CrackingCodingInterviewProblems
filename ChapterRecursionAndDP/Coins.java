package ChapterRecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;

public class Coins {
    public static void main(String[] args) {
        int n = 10;
        int[] coins = {25, 10, 5, 1};

        int[] coinsBottomUp = {1, 5, 6, 9};
//        makeChangeBottomUp(n, coinsBottomUp);

        int minCOins = minNumOfCoinsNeeded(n, coinsBottomUp);

//
//        int[][] memo = new int[n + 1][coins.length];
//        int waysMemo = makeChangeMemo(n, coins, 0, memo);
//        System.out.println("Memo Ways: " + waysMemo);
//        int ways = makeChange(n, coins, 0);
//        System.out.println("Results: " +ways);
    }

    private static int minNumOfCoinsNeeded(int n, int[] coins) {
        int[][] memo = new  int [coins.length][n + 1];

        for(int i = 0; i < coins.length; i++){      //for ZERO the min is ZERO coins
            memo[i][0] = 0;
        }
        for(int j = 0; j <= n; j++){        //for coin 1 we know we require same number of coins as told
            memo[0][j] = j;
        }

        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j <= n; j++){
                if(coins[i] > j){
                    memo[i][j] = memo[i - 1][j];
                }else {
                    memo[i][j] = Math.min(memo[i - 1][j],  1 + memo[i][j - coins[i]]);
                }
            }
        }
        System.out.println(memo[coins.length - 1][n]);

        ArrayList<Integer> coinsDeno = new ArrayList<>();

        int index = coins.length - 1;

        while (index > 0){
            while (index > 0 && memo[index][n] == memo[index - 1][n]){
                index--;
            }
            coinsDeno.add(coins[index]);
            n = n - coins[index];
            if(n == 0){
                break;
            }
        }
        System.out.println(coinsDeno);

        return memo[coins.length - 1][n];

    }

    private static void makeChangeBottomUp(int n, int[] coins) {
        int[][] memo = new  int [coins.length][n + 1];

        for(int i = 0; i < coins.length; i++){
            memo[i][0] = 1;
        }
        for(int j = 0; j <= n; j++){
            memo[0][j] = 1;
        }

        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j <= n; j++){
                if(coins[i] > j){
                    memo[i][j] = memo[i - 1][j];
                }else {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - coins[i]];
                }
            }
        }
        System.out.println(memo[coins.length - 1][n]);
    }

    private static int makeChangeMemo(int n, int[] coins, int coinIdx, int[][] memo) {
        if(memo[n][coinIdx] > 0){
            System.out.println("Memo");
            System.out.println("-------------------------------");
            return memo[n][coinIdx];
        }
        if(coinIdx >= coins.length - 1){
            return 1;
        }
        int coinAmt = coins[coinIdx];
        int ways = 0;

        for(int i = 0; i * coinAmt <= n; i++){
            int remaining = n - i * coinAmt;
            ways += makeChangeMemo(remaining, coins, coinIdx + 1, memo);
        }
        memo[n][coinIdx] = ways;
        return ways;
    }

    private static int makeChange(int n, int[] coins, int coinIdx) {
        if(coinIdx >= coins.length - 1){
            System.out.println("Coin Amount in Result: " + coins[coinIdx]  + " coinIdx: " + coinIdx);
            System.out.println("Value of N: " + n);
            System.out.println("-------------------------------------------");
            return 1;
        }
        int coinAmt = coins[coinIdx];
        int ways = 0;
        for (int i = 0; i * coinAmt <= n; i++){
            System.out.println("Coin Amount: " + coins[coinIdx] + " coinIdx: " + coinIdx);
            int amountRemain = n - coinAmt * i;
            System.out.println("Remaining Amout: " + amountRemain +" for i: "+i);
            ways += makeChange(amountRemain, coins, coinIdx + 1);
        }

        return ways;

    }
}
