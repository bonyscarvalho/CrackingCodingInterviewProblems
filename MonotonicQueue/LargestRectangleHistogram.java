package LeetCodeMedium.MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;

//84. Largest Rectangle in Histogram
public class LargestRectangleHistogram {
    public static void main(String args[]) {
        int[] heights = {6, 7, 5, 2, 4, 5, 9, 3};

        System.out.println(largestRectangleArea(heights));
    }


    public static int largestRectangleArea(int[] heights) {
        if(heights.length == 0)return 0;
        Deque<Integer> deque = new ArrayDeque<>();

        int maxArea = 0;
        deque.push(-1); //Adding -1 so that we can use this as the last index on the array saying
        // the len of all the element prior to it were having height greater then it and so our width is start of array

        for(int currIdx = 0; currIdx < heights.length; currIdx++){

            while ((deque.peek() != -1) && (heights[deque.peek()] >= heights[currIdx])){
                int currHeight = heights[deque.pop()];
                int width = currIdx - deque.peek() - 1;
                int currArea = currHeight * width;

                maxArea = Math.max(currArea, maxArea);
            }

            deque.push(currIdx);
        }

        while (deque.peek() != -1){
            int currHeight = heights[deque.pop()];
            int width = heights.length - deque.peek() - 1;
            int currArea = currHeight * width;

            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }
}
