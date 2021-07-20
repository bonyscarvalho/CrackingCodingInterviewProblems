package DynamicProgramming;

import java.util.Arrays;

//343. Integer Break
public class IntegerBreak {
    public static void main(String[] args) {
        int maxProd =  integerBreak(10);
       // int maxProdByMath = integerBreakByMath(30);
        System.out.println("maxProd: " +maxProd);
        //System.out.println("maxProdByMath: " +maxProdByMath);
    }

    private static int integerBreakByMath(int num) {
        if(num <= 3) return num;

        int numOf3 = num / 3;
        int remainder = num % 3;
        int numOf2 = 0;

        if(remainder == 1){
            numOf2 = 2;
            numOf3 -= 1;
        }else if(remainder == 2){
            numOf2 = 1;
        }

        return (int) (Math.pow(3, numOf3) * Math.pow(2, numOf2));
    }

    private static int integerBreak(int num) {
        int[] dp = new int[num + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= num; i++) {
            int max = i;
            // as for some numbers max can be itself eg for 2 max is 2 as the prod 1*1 is 1. So we have to assign max as 0
            if(i == num){
                max = 0;
            }
            //j is i/2 so that only half values are covered as you dont want to repeat for the same result. 2,3 will be same as 3,2.
            //same as 4,1 prod result will be same as 1, 4. So half will just dont calculate again.
            for(int j = 1; j <= i/2; j++){
                max = Math.max(max, dp[j] * dp[i-j]);
            }
            dp[i] = max;
            //System.out.println("MAX for i: " +i+" is: "+max);
        }
        //System.out.println("MAX for num: " +num+ " is: "+dp[num]);
        Arrays.stream(dp).forEach(value -> System.out.print(value + " "));
        return dp[num];
    }
}
