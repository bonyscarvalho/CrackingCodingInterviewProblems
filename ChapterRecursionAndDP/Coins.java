package ChapterRecursionAndDP;

import java.util.Arrays;

public class Coins {
    public static void main(String[] args) {
        int n = 25;
        int[] coins = {25, 10, 5, 1};
//        int[][] memo = new int[n + 1][coins.length];
//        int waysMemo = makeChangeMemo(n, coins, 0, memo);
//        System.out.println("Memo Ways: " + waysMemo);
        int ways = makeChange(n, coins, 0);
        System.out.println("Results: " +ways);
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
