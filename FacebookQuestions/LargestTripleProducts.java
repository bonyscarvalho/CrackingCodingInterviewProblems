package FacebookQuestions;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class LargestTripleProducts {
    public static void main(String args[]) {
        int[] arr_1 = {1, 2, 3, 4, 5};
        int[] expected_1 = {-1, -1, 6, 24, 60};
        int[] output_1 = findMaxProduct(arr_1);
        Arrays.stream(output_1).forEach(value -> System.out.print(value + " "));


        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {-1, -1, 56, 56, 140, 140};
        int[] output_2 = findMaxProduct(arr_2);
        Arrays.stream(output_2).forEach(value -> System.out.print(value + " "));
    }

    private static int[] findMaxProduct(int[] arr) {
        if(arr.length == 0) return new int[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[arr.length];

        for(int idx = 0; idx < arr.length; idx++){
            queue.add(arr[idx]);
            if(idx < 2){
                result[idx] = -1;
            }else {
                int firstNum = queue.poll(); int secondNum = queue.poll(); int thirdNum = queue.poll();
                result[idx] = firstNum * secondNum * thirdNum;
                queue.add(firstNum); queue.add(secondNum); queue.add(thirdNum);
            }
        }

        return result;
    }
}
