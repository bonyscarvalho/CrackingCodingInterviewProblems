package FacebookQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ElementSwappingGreedy {
    public static void main(String[] args) {
        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
        int[] expected_1 = {1, 5, 3};
        int[] output_1 = findMinArray(arr_1,k_1);
        Arrays.stream(output_1).forEach(value -> System.out.print(value + " "));

        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
        int[] expected_2 = {2, 8, 9, 11, 1};
        int[] output_2 = findMinArray(arr_2,k_2);
        System.out.println("NEXT: ");
        Arrays.stream(output_2).forEach(value -> System.out.print(value + " "));
    }

    public static class NumIdxPair{
        int idx, val;
        public NumIdxPair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }

    private static int[] findMinArray(int[] arr, int k) {
        if(arr.length == 0) return arr;
        int len = arr.length;
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        for(int idx = 0; idx <= Math.min(k, len - 1); idx++){
            int val = arr[idx];
            if(val < minVal){
                minVal = val;
                minIdx = idx;
            }
        }

        for(int idx = minIdx; idx > 0; idx--){
            int temp = arr[idx];
            arr[idx] = arr[idx - 1];
            arr[idx - 1] = temp;
        }

//        PriorityQueue<NumIdxPair> pairs = new PriorityQueue<NumIdxPair>(Comparator.comparingInt((NumIdxPair pair) -> pair.val));
//
//        for(int idx = 0; idx < Math.min(k, len); idx++){
//            NumIdxPair numIdxPair = new NumIdxPair(idx, arr[idx]);
//            pairs.add(numIdxPair);
//        }

        return arr;
    }
}
