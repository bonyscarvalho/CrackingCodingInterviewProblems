package LeetCodeMedium.MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Arrays;

//239. Sliding Window Maximum
public class SlidingWindowMaximumHARD {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7}; //{4, -2};// {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] maxOfKSize = maxSlidingWindow(nums, k);
        int[] maxOfKSizeDP = maxSlidingWindowDP(nums, k);

    }

    private static int[] maxSlidingWindowDP(int[] nums, int k) {
        int len = nums.length;
        if(len * k == 0) return new int[0];
        if(k == 1) return nums;

        int[] result = new int[len - k + 1];
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = nums[0];
        rightMax[len - 1] = nums[len - 1];

        for(int idx = 1; idx < len; idx++){
            if(idx % k == 0){   //Start of The Block Window so left should be the start of num
                leftMax[idx] = nums[idx];
            }else {
                leftMax[idx] = Math.max(leftMax[idx - 1], nums[idx]);
            }

            int rightIdx = len - idx - 1;
            if(rightIdx % k == 0){
                rightMax[rightIdx] = nums[rightIdx];    //end of block Window
            }else {
                rightMax[rightIdx] = Math.max(rightMax[rightIdx + 1], nums[rightIdx]);
            }
        }

        for(int idx  = 0; idx < result.length; idx++){
            result[idx] = Math.max(rightMax[idx], leftMax[idx + k - 1]);
        }
        Arrays.stream(result).forEach(value -> System.out.print(value + " "));

        return result;

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len * k == 0) return new int[0];
        if(k == 1) return nums;

        //Double Sided queue
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] maxResult = new int[len - k + 1];

        //for 1st k elements
        for(int idx = 0; idx < k; idx++){
            //Removing the element lesser then curr number.
            //Only storing the max Idx
            while (!deque.isEmpty() && (nums[idx] > nums[deque.getLast()])){
                deque.removeLast();
            }
            deque.addLast(idx);
        }

//        1,3,-1,-3,5,3,6,7 //DEQUE -> 7      //ANS: 3, 3, 5, 5, 6, 7
                                //     7
        int ansIdx = 0;
        for(int idx = k; idx < len; idx++){
            maxResult[ansIdx] = nums[deque.getFirst()]; //as only 1st will be the max element from k elements
            ansIdx++;

            //Removing the first Idx so that the window size is k and
            // the first Idx is removed which is start of idx of the window
            if(!deque.isEmpty() && deque.getFirst() == idx - k){
                deque.removeFirst();
            }

            //in deque we store the IDX so need to be careful with this.
            while (!deque.isEmpty() && (nums[idx] > nums[deque.getLast()])){
                deque.removeLast();
            }
            deque.addLast(idx);
        }

        maxResult[ansIdx] = nums[deque.getFirst()];

        Arrays.stream(maxResult).forEach(value -> System.out.print(value + " "));

        return maxResult;
    }
}
