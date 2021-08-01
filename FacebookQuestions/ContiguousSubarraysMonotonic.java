package FacebookQuestions;

import java.util.Arrays;
import java.util.Stack;

public class ContiguousSubarraysMonotonic {
    public static void main(String args[]) {
        int[] arr = {3, 4, 1, 6, 2};
        int[] counts = countSubarrays(arr);
        Arrays.stream(counts).forEach(value -> System.out.print(value + " "));
    }

    public static int[] countSubarrays(int[] arr) {
        if(arr.length == 0) return arr;
        Stack<Integer> monotonic = new Stack<>();
        int[] result = new int[arr.length];

        result[0] = 1;
        monotonic.push(0);
        for(int idx = 1; idx < arr.length; idx++){
            int curr = arr[idx];
            while (!monotonic.isEmpty() && arr[monotonic.peek()] < curr){
                monotonic.pop();
            }
            if(monotonic.isEmpty()){
                result[idx] = idx + 1;
            }else {
                result[idx] = idx - monotonic.peek();
            }
            monotonic.push(idx);
        }

        monotonic.clear();
        monotonic.push(arr.length - 1);
        for (int idx = arr.length - 2; idx >= 0; idx--){
            int curr = arr[idx];
            while (!monotonic.isEmpty() && arr[monotonic.peek()] < curr){
                monotonic.pop();
            }
            if(monotonic.isEmpty()){
                int leftRes = result[idx];
                result[idx] = arr.length - idx - 1 + leftRes;
            }else {
                int leftRes = result[idx];
                result[idx] = monotonic.peek() - idx - 1 + leftRes;
            }
            monotonic.push(idx);
        }

        return result;
    }
}
