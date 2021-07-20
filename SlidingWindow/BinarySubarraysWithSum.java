package LeetCodeMedium.SlidingWindow.Count_NumberOfSubarray;

import java.util.HashMap;
import java.util.Map;

//930. Binary Subarrays With Sum
// return the NUMBER OF NON-EMPTY SUBARRAY with a sum goal
public class BinarySubarraysWithSum {

    public static void main(String args[]) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSumVIPApproach(nums, goal));
        //System.out.println(numSubarraysWithSum(nums, goal));
    }

    private static int numSubarraysWithSumVIPApproach(int[] nums, int goal) {
        if(nums.length == 0)return 0;

        //AtMost returns the sum for goal from 0, 1 and 2 for goal 2 and for goal 1 will be 0 and 1.
        //so if we minus it we will get the exact value you goal 2.
        //First you may have feeling of using sliding window.
        //Then this idea get stuck in the middle.
        //
        //This problem will be a very typical sliding window,
        //if it asks the number of subarrays with at most K distinct elements.
        //
        //Just need one more step to reach the folloing equation:
        //exactly(K) = atMost(K) - atMost(K-1)
        return numSubarraysWithSumAtMostGoal(nums, goal) - numSubarraysWithSumAtMostGoal(nums, goal - 1);
    }

    private static int numSubarraysWithSumAtMostGoal(int[] nums, int goal) {
        if(goal < 0) return 0;  //Very Important as at most sum for negative will be 0

        int start = 0;
        int result = 0;
        int sum = 0;

        for(int end = 0; end < nums.length; end++){
            sum += nums[end];

            while (start < end && sum > goal){
                sum -= nums[start];
                start++;
            }

            result += end - start + 1;
        }

        return result;
    }

//    public int numSubarraysWithSum(int[] A, int S) {
//        if (A == null || A.length == 0) return 0;
//        // because A consist of only 1 and 0, the maximum possible prefix sum
//        // value is A.length, add 1 to make room for the value of 0
//        int[] preSum = new int[A.length + 1];
//        preSum[0] = 1;  // subarray of length 0 will have sum of 0
//        int ans = 0, sum = 0;
//        for (int num : A) {
//            sum += num;
//            // don't forget to validate the index
//            if (sum - S >= 0) ans += preSum[sum - S];
//            preSum[sum] += 1;
//        }
//        return ans;
//    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        if(nums.length == 0)return 0;

        int sum = 0;
        int noOfSubArrayCount = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();

        for(int idx = 0; idx < nums.length; idx++){
            sum += nums[idx];
            int target = sum - goal;

            if(sum == goal){
                noOfSubArrayCount++;
            }

            if(sumCount.containsKey(target)){
                noOfSubArrayCount += sumCount.get(target);
            }

            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }

        return noOfSubArrayCount;
    }
}
