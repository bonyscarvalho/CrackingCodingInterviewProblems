package LeetCodeMedium.MonotonicQueue;

import java.util.Arrays;
import java.util.Stack;

//1762. Buildings With an Ocean View
public class BuildingsWithOceanView {
    public static void main(String args[]) {
        int[] heights = {4,2,3,1};
        int[] views1 = findBuildings(heights);
        Arrays.stream(views1).forEach(value -> System.out.print(value + " "));
    }

    public static int[] findBuildingsNoSpaceApp(int[] heights) {
        if (heights.length == 0) return new int[0];
            //Marking every viewing building as 0 CHECK constrains for Flat building too(0 height)
        int currMaxHeight = heights[heights.length - 1];
        heights[heights.length - 1] = 0;
        int viewCount = 1;

        for(int idx = heights.length - 2; idx >= 0; idx--){
            if(heights[idx] > currMaxHeight){
                currMaxHeight = heights[idx];
                heights[idx] = 0;
                viewCount++;
            }
        }

        int[] results = new int[viewCount];
        int i = 0;

        for(int idx = 0; idx < heights.length; idx++){
            if(heights[idx] == 0){
                results[i++] = idx;
            }
        }

        return results;
    }

    public static int[] findBuildings(int[] heights) {
        if(heights.length == 0) return new int[0];

        Stack<Integer> buildingViews = new Stack<>();
        buildingViews.push(heights.length - 1);

        for(int idx = heights.length - 2; idx >= 0; idx--){
            if(heights[idx] > heights[buildingViews.peek()]){
                buildingViews.push(idx);
            }
        }

        int[] results = new int[buildingViews.size()];

        int idx = 0;
        while(idx < results.length){
            results[idx++] = buildingViews.pop();
        }

        return results;
    }
}
