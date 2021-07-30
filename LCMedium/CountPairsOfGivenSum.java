package LeetCodeMedium;

import java.util.HashMap;
import java.util.Map;
//https://www.geeksforgeeks.org/count-pairs-with-given-sum/
public class CountPairsOfGivenSum {
    public static void main(String[] args) {
//        int arr[] = new int[] { 10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
//        int sum = 11;
        int arr[] = {1, 1};
        int sum = 2;
        System.out.println("Count of pairs is " + getPairsCount(arr, sum));
    }

    private static int getPairsCount(int[] arr, int sum) {
        if(arr.length == 0) return 0;

        int totalSumCount = 0;
        Map<Integer, Integer> freqCount = new HashMap<>();

        for(int num : arr){
            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
        }

        for(int num : arr){
            if(freqCount.containsKey(sum - num)){
                totalSumCount += freqCount.get(num);    //as we will be adding that many times to the decreased number
            }

            if((sum - num) == num){
                totalSumCount--;    //as if both digits are same count will be reduced by 1
            }
        }

        return totalSumCount/2; //as we have counted the nums twice so half is the answer
    }
}
