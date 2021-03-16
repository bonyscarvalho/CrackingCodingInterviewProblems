package DynamicProgramming;

public class MinEditDistance {
    public static void main(String[] args) {
        String str1 = "abcfg";
        String str2 = "adceg";

        int[][] memo = new int[str1.length() + 1][str2.length() + 1];

        computeMinDistanceForConversion(str1, str2, memo);
    }

    private static void computeMinDistanceForConversion(String str1, String str2, int[][] memo) {
        if(str1 == null || str2 == null) return;

        for(int i = 0; i <= str1.length(); i++){
            for (int j = 0; j <= str2.length(); j++){
                if(i == 0 && j == 0) {
                    memo[i][j] = 0;
                }else if(i == 0){
                    memo[i][j] = memo[i][j - 1] + 1;
                }else if(j == 0){
                    memo[i][j] = memo[i - 1][j] + 1;
                }else{
                    if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                        memo[i][j] = memo[i - 1][j - 1];
                    }else {
                        memo[i][j] = 1 + Math.min(memo[i-1][j], Math.min(memo[i - 1][j - 1], memo[i][j - 1])) ;
                    }
                }
            }
        }

        System.out.println("Min Result: " + memo[str1.length()][str2.length()]);
    }
}
