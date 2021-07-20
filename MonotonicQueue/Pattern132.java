package LeetCodeMedium.MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pattern132 {
    public static void main(String args[]) {
        int[] nums = {1, 5, 2, 3, 4, 5, 6, 7};
        int[]  numsInvalid = {1, 2, 3, 4, 5};

        System.out.println(find132pattern(nums));
        System.out.println(find132pattern(numsInvalid));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums.length == 0) return false;

        Deque<Integer> deque = new ArrayDeque<>();
        Integer prev = Integer.MIN_VALUE;

        for(int idx = nums.length - 1; idx >= 0; idx--){
            //System.out.println("prev: " + prev);
            if(prev != Integer.MIN_VALUE && nums[prev] > nums[idx]){    //found prev -> 4 now check if prev is greater then currIdx
                return true;
            }

            while (!deque.isEmpty() && (nums[deque.peekLast()] < nums[idx])){
                System.out.println("prev: " + prev);
                prev = deque.removeLast();
            }

            deque.addLast(idx);
        }

        return false;
    }
}
