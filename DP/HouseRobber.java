package DynamicProgramming;

//198. House Robber
public class HouseRobber {
    public static void main(String args[]) {
        int[] nums = {1,2,3,1};//{1,2,3,1};
        Integer[] memo = new Integer[nums.length];
        //System.out.println(robHouse(nums,memo,0));
        int maxProfit = robHouseDP(nums);

       // System.out.println(robNonAdjacentHouse(nums));
    }

    private static int robHouseDP(int[] nums) {
        if(nums.length == 0)return 0;

        int[] dp = new int[nums.length + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//
//        for(int i = 2; i < dp.length; i++){
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//        }
//        System.out.println(dp[nums.length]);
//        return dp[nums.length];


        dp[nums.length] = 0;
        dp[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--){
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        System.out.println(dp[0]);
        return dp[0];
    }

    //memo of Integer as it won't affect if your input is full of 0s
    private static int robHouse(int[] nums, Integer[] memo, int index) {
        if(index >= nums.length) return 0;
        if(memo[index] != null) return memo[index];

        int max = Math.max(robHouse(nums, memo, index + 1), robHouse(nums,memo,index + 2) + nums[index]);

        memo[index] = max;
        return max;
    }

    //if you rob from current house you have to skip the next one(exclusive)
    // and if you don't then take from the inclusive house
    private static int robNonAdjacentHouse(int[] nums) {
        if(nums.length == 0) return 0;

        int inclusive = nums[0];    // current included
        int exclusive = 0;          //excluded

        for(int i = 1; i < nums.length; i++){
            int currHouse = inclusive;
            inclusive = Math.max(exclusive + nums[i], inclusive);
            exclusive = currHouse;
            }

        return inclusive;
    }


}
