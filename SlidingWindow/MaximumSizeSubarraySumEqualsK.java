package LeetCodeMedium.SlidingWindow.SumOfSubArray;

import java.util.HashMap;
import java.util.Map;
//325. Maximum Size Subarray Sum Equals k
public class MaximumSizeSubarraySumEqualsK {
    public static void main(String args[]) {
        int[] arr = {1,-1,5,-2,3};
        int k = 3;
        System.out.println(maxSubArrayLen(arr, k)); //1, -1, 5, 2
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        if(nums.length == 0) return 0;

        int prefixSum = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int maxLen = 0;

        for(int idx = 0; idx < nums.length; idx++){
            prefixSum += nums[idx];

            // if (prefixSum == k) {
            //     maxLen = idx + 1;
            // }

            if(sumMap.containsKey(prefixSum - k)){
                maxLen = Math.max(maxLen, idx - sumMap.get(prefixSum - k));
            }

            //if(!sumMap.containsKey(prefixSum)){
            //sumMap.put(prefixSum, idx);
            sumMap.putIfAbsent(prefixSum, idx); //As you want the maxminum size of it you only put the new SUM and not the already inserted ones
            //}
        }

        return maxLen;
    }
}
