package LeetCodeMedium.SlidingWindow.SumOfSubArray;

import java.util.HashMap;
import java.util.Map;

//974. Subarray Sums Divisible by K
//return the number of (contiguous, non-empty) subarrays that have a sum divisible by k.
public class SubarraySumsDivisibleByK {
    public static void main(String args[]) {
        int[] nums = {4, 5, 0, -2, -3, 1}; int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        if(nums.length == 0)return 0;

        //Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int[] prefixCountArr = new int[k];
        prefixCountArr[0] = 1;
        //prefixSumCount.put(0, 1);   //initial Sum
        int remainder = 0;  // prefixSum
        int totalCount = 0;

        for(int num : nums){
            remainder += num;
            while (remainder < 0){
                remainder += k; //VERY IMPORTANT STEP:-   if the prefix sum is negative to make it positive on a number line you find its pair
            }
            remainder = remainder % k;

            totalCount += prefixCountArr[remainder];

            prefixCountArr[remainder]++;

//            if(prefixSumCount.containsKey(remainder)){
//                totalCount += prefixSumCount.get(remainder);
//            }
//
//            prefixSumCount.put(remainder, prefixSumCount.getOrDefault(remainder, 0) + 1);
        }

        return totalCount;
    }
}
