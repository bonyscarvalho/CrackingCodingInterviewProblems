package LeetCodeMedium.MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DailyTemperature {
    public static void main(String args[]) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        int[] warmTemp = dailyTemperatures(temperatures);
        //Arrays.stream(warmTemp).forEach(value -> System.out.print(value + " "));

        System.out.println();
        int[] nearestWarmTemp = dailyTemperaturesNearestApp(temperatures);
        Arrays.stream(nearestWarmTemp).forEach(value -> System.out.print(value + " "));
    }

    //DP way    //Rather then Deque way we will be doing the DP way where we are storing the index of warm days for every element and using it
    private static int[] dailyTemperaturesNearestApp(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        int[] warmIndexes = new int[len];
        if (len == 0) return result;

        for(int currIdx = len - 1; currIdx >= 0; currIdx--){
            int nextWarmTempIdx = currIdx + 1;      //To find the bigger temperature from next Indexes.

            while (nextWarmTempIdx < len && temperatures[nextWarmTempIdx] <= temperatures[currIdx]){
                //if the next warmIndex is lesser then find the next of the arr[nextWarmTempIdx]
                //like if currTemp is greater then next then find the next temp from the arr
                //as every index will have greater temp from curr DP
                nextWarmTempIdx = warmIndexes[nextWarmTempIdx];
            }

            warmIndexes[currIdx] = nextWarmTempIdx; //Memo

            result[currIdx] = warmIndexes[currIdx] == len ? 0 : warmIndexes[currIdx] - currIdx;
            //just validation for len else we will have the normal solution
        }
        Arrays.stream(warmIndexes).forEach(value -> System.out.print(value + " "));
        System.out.println();

        return result;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if (temperatures.length == 0) return result;

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        //73,74,75,71,69,72,76,73
        for (int currIdx = temperatures.length - 1; currIdx >= 0; currIdx--){
            while (!deque.isEmpty() && temperatures[deque.peekLast()] <= temperatures[currIdx]){
                deque.removeLast();
            }

            if(deque.isEmpty()){
                result[currIdx] = 0;
            }else {
                result[currIdx] = deque.peekLast() - currIdx;
            }

            deque.addLast(currIdx);
        }

        return result;
    }
}
