package ChapterRecursionAndDP;

import java.util.Arrays;

public class TripleSteps {
    public static void main(String[] args) {
        int [] stepsWays = {1, 2, 3};
        int possibleWays = computeStepsForKGivenWays(4, stepsWays);
        System.out.println("Steps Count: " + possibleWays);

        int n = 10;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int numOfWays = countWays(n, memo);
        System.out.println("Memo- Count Ways: " + numOfWays);


    }

    private static int countWays(int n, int[] memo) {
        if(n < 0){
            return 0;
        }else if(n == 0){
            return 1;
        }else if(memo[n] > -1){
            return memo[n];
        }else {
            memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
            return memo[n];
        }
    }

    private static int computeStepsForKGivenWays(int steps, int[] stepsWays) {
        if(stepsWays.length == 0) return 0;

        int[] stepCache = new int[steps + 1];
        stepCache[1] = 1;
        stepCache[2] = 2;

        for (int i = 3; i <= steps; i++){
            for (int step : stepsWays){
                if(i - step >= 0){
                    stepCache[i] += stepCache[i - step];
                }
            }
        }

        return stepCache[steps];
    }
}
