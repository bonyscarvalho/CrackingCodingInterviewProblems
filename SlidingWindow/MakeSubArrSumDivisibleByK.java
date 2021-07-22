package LeetCodeMedium.SlidingWindow.SumOfSubArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1590. Make Sum Divisible by P
public class MakeSubArrSumDivisibleByK {
    public static void main(String args[]) {

        int [] nums = {3,1,4,2}; int p = 6;
        int[] nums1 = {6,3,5,2}; int p1 = 9;
        System.out.println(minSubarray(nums, p));
        System.out.println(minSubarray(nums1, p1));
    }
    public static int minSubarray(int[] nums, int p) {
        if(nums.length == 0) return -1;
        int totalSum = Arrays.stream(nums).sum();   //Doesn't work for long numbers
        if(totalSum % p == 0)return 0;
        if(totalSum < p)return -1;
        int requiredMod = totalSum % p; //Extra value which we need to find in the subarray like K subarr

        int prefixSum = 0;
        Map<Integer, Integer> idxToSumMap = new HashMap<>();
        idxToSumMap.put(0, -1);
        int minSubArr = Integer.MAX_VALUE;

        for(int idx = 0; idx < nums.length; idx++){
            prefixSum += nums[idx];
            int remainder = prefixSum % p;

            int targetMod = ((remainder - requiredMod + p) % p);
            //System.out.println(remMod);
            if(idxToSumMap.containsKey(targetMod)){
                minSubArr = Math.min(minSubArr, idx - idxToSumMap.get(targetMod));
            }
            idxToSumMap.put(remainder , idx);
        }
        //System.out.println(idxToSumMap);

        return (minSubArr == Integer.MAX_VALUE) ? -1 : minSubArr;
    }
}
