package FacebookQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianStream {
    public static void main(String args[]) {
        int[] arr_1 = {5, 15, 1, 3};
        int[] expected_1 = {5, 10, 5, 4};
        int[] output_1 = findMedianApp(arr_1);
        Arrays.stream(output_1).forEach(value -> System.out.print(value + " "));

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {2, 3, 4, 3, 4, 3};
        int[] output_2 = findMedianApp(arr_2);
        Arrays.stream(output_2).forEach(value -> System.out.print(value + " "));
    }

    private static int[] findMedianApp(int[] arr) {
        int[] output = new int[arr.length];
        if (arr.length == 0) return output;

        //Holds the 1st half of the Array
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //Second half of the array to get min element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for(int idx = 0; idx < arr.length; idx++) {
            int num = arr[idx];

            if(maxHeap.isEmpty() || maxHeap.peek() > num){  //As maxHeap stores elements of 1st half only for 2nd half minheap
                maxHeap.add(num);
            }else {
                minHeap.add(num);
            }

            if(maxHeap.size() - minHeap.size() > 1){
                minHeap.add(maxHeap.poll());
            }else if(minHeap.size() - maxHeap.size() > 1){
                maxHeap.add(minHeap.poll());
            }

            if(minHeap.size() == maxHeap.size()){
                output[idx] = (maxHeap.peek() + minHeap.peek()) /2;
            }else if(minHeap.size() > maxHeap.size()){
                output[idx] = minHeap.peek();
            }else{
                output[idx] = maxHeap.peek();
            }
        }

        return output;
    }

    private static int[] findMedian(int[] arr) {
        int[] output = new int[arr.length];
        if (arr.length == 0) return output;

        //Holds the 1st half of the Array
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //Second half of the array to get min element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for(int idx = 0; idx < arr.length; idx++){
            int num = arr[idx];
            //When Sizes are equal you put it in max to get the top max Value and
            // remove it and put in min to get the top value as the answer
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            } else {
                //When Sizes are unequal you have to make it equal so add it in minHeap as it's size will be always greater
                //and then remove and put it in maxHeap
                //
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }

            if(minHeap.size() > maxHeap.size()){
                output[idx] = minHeap.peek();
            }else {
                output[idx] = (maxHeap.peek() + minHeap.peek()) /2;
            }
        }

        return output;
    }
}
