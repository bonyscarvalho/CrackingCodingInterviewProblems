package ChapterSortingAndSearching;

import java.util.Arrays;
import java.util.Stack;

public class PeakAndValley {
    public static void main(String args[])
    {
        int[] input = {5, 3, 1, 2, 3};
        //int[] input = {5, 8, 6, 2, 3, 4, 6};

        computeByPeakValleyApproach(input);

        //computePeakAndValley(input);
        //computeBySorting(input);
    }

    private static void computeByPeakValleyApproach(int[] input) {
        if(input.length == 0) return;

        for(int i = 1; i < input.length; i += 2){
            int maxIndex = findMaxIndex(input, i-1, i, i+1);
            if(maxIndex != i){
                swap(input, i, maxIndex);
            }
        }
        Arrays.stream(input).forEach(value -> System.out.print(value + " "));
    }

    private static int findMaxIndex(int[] input, int prev, int curr, int next) {
        int prevVal = prev >= 0 && prev < input.length ? input[prev] : Integer.MIN_VALUE;
        int currVal = curr >= 0 && curr < input.length ? input[curr] : Integer.MIN_VALUE;
        int nextVal = next >= 0 && next < input.length ? input[next] : Integer.MIN_VALUE;

        int maxVal = Math.max(prevVal, Math.max(currVal, nextVal));

        if(maxVal == prevVal) return prev;
        if(maxVal == currVal) return curr;
        return next;
    }


    private static void computeBySorting(int[] input) {
        if(input.length == 0) return;

        Arrays.sort(input);
        for(int i = 1; i < input.length; i += 2){
            swap(input, i, i-1);
        }

        Arrays.stream(input).forEach(value -> System.out.print(value + " "));
    }

    private static void swap(int[] input, int curr, int prev) {
        int temp = input[curr];
        input[curr] = input[prev];
        input[prev] = temp;

    }

    private static void computePeakAndValley(int[] input) {
        if(input.length == 0) return;

        Stack<Integer> peak = new Stack<>();
        Stack<Integer> valley = new Stack<>();

        int i = 0;
        while (i < input.length){
            int j = i + 1;
            if(j < input.length){
                if(input[i] <= input[j]){
                    if(peak.empty()){
                        peak.push(input[j]);
                    }else if(peak.peek() == input[i]){
                        peak.pop();
                        peak.push(input[j]);
                    }else {
                        peak.push(input[j]);
                    }

                    if(valley.empty()) {
                        valley.push(input[i]);
                    }
                }else {
                    if(valley.empty()){
                        valley.push(input[j]);
                    }else if(valley.peek() == input[i]){
                        valley.pop();
                        valley.push(input[j]);
                    }else{
                        valley.push(input[j]);

                    }

                    if(peak.empty()){
                        peak.push(input[i]);
                    }
//                    if(peak.peek() != input[i]){
//                        peak.push(input[i]);
//                    }
                }
            }
            i++;
        }
        System.out.println("Peak: " + peak);
        System.out.println("Valley: " + valley);
    }
}
