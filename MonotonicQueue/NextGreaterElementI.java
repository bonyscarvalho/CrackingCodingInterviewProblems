package LeetCodeMedium.MonotonicQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//496. Next Greater Element I
public class NextGreaterElementI {
    public static void main(String args[]) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        int[] nextGreater = nextGreaterElementStartApp(nums1, nums2);
        Arrays.stream(nextGreater).forEach(value -> System.out.print(value + " "));
        //int[] nextGreater = nextGreaterElement(nums1, nums2);
        //Arrays.stream(nextGreater).forEach(value -> System.out.print(value + " "));
    }

    public static int[] nextGreaterElementStartApp(int[] nums1, int[] nums2) {
        Stack < Integer> stack = new Stack < > ();
        HashMap <Integer, Integer> map = new HashMap < > ();

        for(int idx = 0; idx < nums2.length; idx++){
            int curr = nums2[idx];

            while (!stack.isEmpty() && curr > stack.peek()){
                map.put(stack.pop(), curr);
            }
            stack.push(curr);
        }
        //For remaining greater elements who don't have next greater element
        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        for(int idx = 0; idx < nums1.length; idx++){
            int nextGreater = map.get(nums1[idx]);
            nums1[idx] = nextGreater;
        }

        return nums1;
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];

        Stack<Integer> nextGreater = new Stack<>();
        nextGreater.push(nums2[nums2.length - 1]);

        Map<Integer, Integer> numToGreater = new HashMap<>();
        numToGreater.put(nums2[nums2.length - 1], -1);
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        for(int idx = nums2.length - 2; idx >= 0; idx--){
            int curr = nums2[idx];

            while(!nextGreater.isEmpty() && nextGreater.peek() <= curr){
                nextGreater.pop();
            }

            if(!nextGreater.isEmpty()){
                numToGreater.put(curr, nextGreater.peek());
            }else{
                numToGreater.put(curr, -1);
            }

            nextGreater.push(curr);
        }

        for(int idx = 0; idx < nums1.length; idx++){
            int nextGreaterVal = numToGreater.get(nums1[idx]);

            nums1[idx] = nextGreaterVal;
        }

        return nums1;
    }
}
