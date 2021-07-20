package LeetCodeMedium.SlidingWindow.SumOfSubArray;

import java.util.HashMap;
import java.util.Map;
//560. Subarray Sum Equals K
public class SubArrayEqualSumK {
    public static void main(String args[]) {
        int[] arr = {3, 4, 7, 2, -3, 1, 4, 2, 1};


        int kSumCount = subarraySum(arr, 7);

       // int kSumWithAtMost = atMostSubArraySum(arr, 7) - atMostSubArraySum(arr, 6);
        System.out.println(kSumCount);
        //AtMost only works when we want the number of subarray
//        System.out.println(atMostSubArraySum(arr, 7));
//        System.out.println(atMostSubArraySum(arr, 6));
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums.length == 0)return 0;

        Map<Integer, Integer> sumToCountMap = new HashMap<>();
       // sumToCountMap.put(0, 1);
        Integer currSum = 0;
        int count = 0;

        for(int num : nums){
            currSum += num;

            if(currSum == k){
                count++;
            }
            //{3, 4, 7, 2, -3, 1, 4, 2, 1}  // 2, -3, 1, 4, 2, 1 --> 7
            //So the map will store the sum it has for k till that currSum
            //{3, 7, 14, 16, 13, 14, 18, 20, 21}

            if(sumToCountMap.containsKey(currSum - k)){
                count += sumToCountMap.get(currSum - k);
            }
            sumToCountMap.put(currSum, sumToCountMap.getOrDefault(currSum, 0) + 1);
        }

        System.out.println(sumToCountMap);
        return count;
    }
}
