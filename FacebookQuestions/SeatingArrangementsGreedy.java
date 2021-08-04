package FacebookQuestions;

import java.util.Arrays;
import java.util.LinkedList;

public class SeatingArrangementsGreedy {
    public static void main(String[] args) {
        int[] arr_1 = {5, 10, 6, 8};
        int expected_1 = 4;
        //System.out.println(minOverallAwkwardness(arr_1));

        int[] arr_2 = {1, 2, 5, 3, 7};
        int expected_2 = 4;
        //System.out.println(minOverallAwkwardness(arr_2));
        int[] test = {2,4,6,20,40}; //2,4,7,7,7 //1 2 12 23
        System.out.println(minOverallAwkwardness(test));
        System.out.println(arrange(test));
    }

    private static int minOverallAwkwardness(int[] arr) {
        if(arr.length == 0) return 0;

        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;
        int minVal = -1;

        for (int idx = 1; idx < arr.length; idx++){
            int currAbs = Math.abs(arr[idx] - arr[idx - 1]);

            if(currAbs <= minAbsDiff){
                minAbsDiff = currAbs;
                minVal = arr[idx];
            }
        }

        return arr[arr.length - 1] - minVal;
    }
    //my nlogn solution.
    // the idea is that to seat the maximum value alongside the next maximum values only, this way we reduce the absolute difference.
    private static int arrange(int nums[]){
        Arrays.sort(nums);
        int len = nums.length;
        //5, 6, 8, 10
        //1 2 12 23
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = len-1; i >= 0; i--){
            if (i % 2 == 0) {
                list.addLast(nums[i]);
            }else{
                list.addFirst(nums[i]);
            }
            System.out.println("LIST: "+list);
        }
       // List: 6,10,8,5
        System.out.println(list);
        int max = 0;
        int prev = list.get(len-1);
        for (int i=0; i < len; i++){
            max = Math.max(Math.abs(list.get(i)-prev), max);
            prev = list.get(i);
        }

        return max;
    }
}
