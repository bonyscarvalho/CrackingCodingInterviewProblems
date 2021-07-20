package LeetCodeMedium.MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
//Sliding Window + Prefix Sum
//HARD: 862. Shortest Subarray with Sum at Least K
/*
1)What is the problem that we have to solve?
Ans - find smallest subarray with atleast sum == k.
2) What if there were only postive numbers?
Ans - I can solve it using two pointer approach directly
3) What problem negative numbers have induced?
Ans - I am not sure if reducing window will increase or decrease the sum between two pointers.
4) How cumulative sum solved the problem?
Ans - I was poping from last if current cumulative is lesser or equal. Because I want to know the ans including all the numbers and excluding numbers when I saw a negative number.
 */
public class HARDShortestSubarraySumAtLeastKNegative {

    public static void main(String args[]) {
        int[] nums1 = {2, -3, 0, 10, -2, 4, 3};
        int k1 = 7;
        System.out.println(shortestSubarray(nums1, k1));
        int[] nums2 = {2, -1, 2, 1};
        int k2 = 3;
        System.out.println(shortestSubarray(nums2, k2));
    }

    public static int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        if(len == 0)return 0;

        int[] tillIndexSum = new int[len + 1];
        int minLen = len + 1;   //as this won't be possible but it will be good to track the value and can be the MAX available value
        //can also be MAX_VALUE
        Deque<Integer> deque = new ArrayDeque<>();

        //Sum of all the values till that Idx
        //PREFIX SUM
        for(int idx = 0; idx < len; idx++){
            tillIndexSum[idx + 1] = nums[idx] + tillIndexSum[idx];
        }

        for(int end = 0; end <= len; end++){
            //Removing all the greater elements from queue as we want P[start] value as small as possible and startIdx as greater as possible
            //P[end] - P[start] >= K
            while (!deque.isEmpty() && tillIndexSum[end] <= tillIndexSum[deque.peekLast()]){
                deque.removeLast();
            }

            //P[end] - P[start] >= K
            //Shrink Stage
            //SUM Till END - SUM TILL START >=(AT LEAST) K
            while (!deque.isEmpty() && (tillIndexSum[end] - tillIndexSum[deque.peekFirst()] >= k)){
                int start = deque.removeFirst();
                minLen = Math.min(minLen, end - start); //no need of end-start-1 as we have take the prefix sum till IDX and not IDX
            }

            deque.addLast(end);
        }

        return (minLen == len + 1) ? -1 : minLen;

    }
}
