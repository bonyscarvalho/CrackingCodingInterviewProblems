package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DecodingWays {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String args[]) {
        String str = "9999" ;//"02";//"1111";
        System.out.println(decodeStringWaysIterative(str));
        System.out.println(decodeStringWaysRecursive(str));


    }

    private static int decodeStringWaysRecursive(String str) {
        if(str.length() == 0 || str.charAt(0) == '0') return 0;
        return decodeStringWaysRecursive(str, 0);
    }

    private static int decodeStringWaysRecursive(String str, int index) {
        if(memo.containsKey(index)) return memo.get(index);

        if(str.length() == index) return 1;
        if(str.length() - 1 == index) return 1;
        if(str.charAt(index) == '0') return 0;

        int ans = decodeStringWaysRecursive(str, index + 1);
        if(Integer.parseInt(str.substring(index, index + 2)) >= 10 && Integer.parseInt(str.substring(index, index + 2)) <= 26){
            ans += decodeStringWaysRecursive(str, index + 2);
        }
        memo.put(index, ans);
        return ans;
    }

    private static int decodeStringWaysIterative(String str) {
        if(str.length() == 0 || str.charAt(0) == '0') return 0;
        int[] dp = new int[str.length() + 1];

        dp[0] = 1;
        dp[1] = str.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= str.length(); i++){

            dp[i] = str.charAt(i - 1) == '0' ? 0 : dp[i - 1];

            String twoLetters = str.substring(i-2, i);
            if(Integer.valueOf(twoLetters) >= 10 && Integer.valueOf(twoLetters) <= 26){
                dp[i] += dp[i - 2];
            }
        }
        //System.out.println(dp[str.length()]);
        return dp[str.length()];
    }
}
