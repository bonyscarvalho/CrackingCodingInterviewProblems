package LeetCodeMedium.SlidingWindow.SumOfSubArray;
//209. Minimum Size Subarray Sum
//Very Important Approach

import java.util.HashMap;
import java.util.Map;

/*
Similar Sliding Window questions:
1248. https://leetcode.com/problems/count-number-of-nice-subarrays/
992. https://leetcode.com/problems/subarrays-with-k-different-integers/
340,
159,
76,
1234,
1004,
930,
904,
862,
209,
 */
public class MinimumSizeSubarraySumVIP {
    public static void main(String args[]) {
        int[] arr = {1,1,1,1,1,1,1,1};    //target = 11, nums = [1,1,1,1,1,1,1,1]
        int target = 11;

        int kSumCount = minSubArrayLen(target, arr);
        System.out.println(minSubArrayLen(target, arr));
        System.out.println(minSubArrayLenApp2(target, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if(len == 0)return 0;

        int start = 0;
        int minLenSubArray = len + 1;   //initial Len as it will be best to return and result won't exceed Len
        int sum = 0;

        for(int end = 0; end < len; end++){
            sum += nums[end];

            while (start <= end && sum >= target){
                minLenSubArray = Math.min(minLenSubArray, end - start + 1);  // this is the window len for which the target was greater then or equal

                sum -= nums[start];
                start++;
            }
        }

        return minLenSubArray % (len + 1);    //as if no result found then it will return 0;
    }

    public static int minSubArrayLenApp2(int k, int[] nums) {
        if(nums.length == 0) return 0;

        int prefixSum = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int maxLen = nums.length;

        for(int idx = 0; idx < nums.length; idx++){
            prefixSum += nums[idx];

            // if (prefixSum == k) {
            //     maxLen = idx + 1;
            // }

            if(sumMap.containsKey(prefixSum - k)){
                maxLen = Math.min(maxLen, idx - sumMap.get(prefixSum - k));
            }

            //if(!sumMap.containsKey(prefixSum)){
            //sumMap.put(prefixSum, idx);
            sumMap.put(prefixSum, idx);
            //}
        }

        return maxLen == nums.length ? 0 : maxLen;
    }


}
