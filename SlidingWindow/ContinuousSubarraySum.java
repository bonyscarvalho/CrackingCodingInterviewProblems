package LeetCodeMedium.SlidingWindow.SumOfSubArray;

import java.util.HashMap;
import java.util.Map;

//523. Continuous Subarray Sum
public class ContinuousSubarraySum {
    public static void main(String args[]) {
        int[] valid1 = {23,2,4,6,7};
        int kValid = 6;
        int[] valid2 = {23,2,6,4,7};
        int[] edgeCase = {5,0,0,0,0};

        int[] inValid = {23,2,6,4,7};
        System.out.println(checkSubarraySum(valid1, kValid));
        System.out.println(checkSubarraySum(valid2, kValid));
        System.out.println(checkSubarraySum(inValid, 13));
        System.out.println(checkSubarraySum(edgeCase, 3));

    }


    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 0)return false;

        Integer prefixSum = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);

        //23,2,6,4,7
        //5, 1, 1, 5,
        for(int idx = 0; idx < nums.length; idx++){
            prefixSum += nums[idx];
            //reducung to the actual value rather then bigger value which is no use
            prefixSum =  prefixSum % k; //you mod the prefix sum by k so that you have the less value than k in the Map to find

            if(sumToIndex.containsKey(prefixSum)){
                if(idx - sumToIndex.get(prefixSum) > 1){
                    System.out.println(sumToIndex);
                    return true;
                }
            }else{
                sumToIndex.put(prefixSum, idx);
            }
        }

        return false;
    }
}
