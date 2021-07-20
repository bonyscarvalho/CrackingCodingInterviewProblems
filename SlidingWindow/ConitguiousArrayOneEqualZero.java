package LeetCodeMedium.SlidingWindow.SumOfSubArray;

import java.util.HashMap;
import java.util.Map;

public class ConitguiousArrayOneEqualZero {
    public static void main(String[] args) {

        //int[] nums =  {0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1};
        int[] nums =  {1, 0, 1, 1, 0, 0};
        System.out.println(findMaxLengthWithEqualsOnesAndZeros(nums));

        System.out.println(findLongestSubWithMoreOnesThanZero(nums));
    }

    private static int findLongestSubWithMoreOnesThanZero(int[] nums) {
        if(nums.length == 0)return 0;

        Map<Integer, Integer> sumToIdxMap = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] == 1){
                sum++;
            }else {
                sum--;
            }

            if(sum > 0){    //if the sum is greater then zero means the count of 1s are always greater
                maxLen = idx + 1;
            }else {
                //as the count of 1s and 0s will be same if the sum is found in the map
                //so if you say sum -1 that will be next element in the array with counts of 1s more then zero
                //so you are trying to find the next idx of zero and not the current 1
                if(sumToIdxMap.containsKey(sum - 1)){   //sumToIdxMap.containsKey(sum) will return the count of equals 1s and 0s
                    //you get the index of next 0 as this zero will be 1 lesser then One's as currently you found same count of 1's and 0's
                    //YOU FIND THE NEXT INDEX OF ZERO IN THE MAP IF SUM -1 THEN YOU TRY TO FIND FOR -2 AS THAT INDEX WILL HAVE LESS ZERO AND MORE 1 FROM THE CURR FOUND
                    //{0,  0,  1,  0,  1,  0,  1, 1,  0,  0,  1};
                    //-1, -2, -1, -2, -1, -2, -1, 0, -1, -2, -1
                    int currLen = idx - sumToIdxMap.get(sum - 1);
                    maxLen = Math.max(currLen, maxLen);
                }
            }

            if(!sumToIdxMap.containsKey(sum)){
                sumToIdxMap.put(sum, idx);
            }
        }

        return maxLen;
    }

    public static int findMaxLengthWithEqualsOnesAndZeros(int[] nums) {
        if(nums.length == 0)return 0;

        Map<Integer, Integer> sumToIdxMap = new HashMap<>();
        sumToIdxMap.put(0, -1); //ForInitialStoring start will be sum 0
        int maxLen = 0;
        int sum = 0;

        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] == 1){
                sum++;
            }else{
                sum--;
            }

            if(sumToIdxMap.containsKey(sum)){
                int prevSumIdx = sumToIdxMap.get(sum);

                int currLen = idx - prevSumIdx;
                System.out.println("IDX: " + idx + " currLen: " + currLen);
                if(currLen > maxLen){
                    maxLen = currLen;
                }
            }else {
                sumToIdxMap.put(sum, idx);
            }
        }

        System.out.println(sumToIdxMap);


        return maxLen;
    }
}
