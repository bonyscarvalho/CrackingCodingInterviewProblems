package SortingAlgo;

import java.util.Arrays;

public class HeapSort {
    public static void main(String args[]) {
        int input[] = { 12, 11, 13, 5, 6, 7 };

        heapSortAscending(input);
        heapSortDescending(input);
    }

    private static void heapSortDescending(int[] input) {
        int n = input.length;

        for(int index = n/2; index >=0; index--){       //As Root is N/2
            heapifyDescending(input, index, n);   // Building MinHeap
        }

        for(int index = n - 1; index >= 0; index--){
            swap(input, 0, index);
            heapifyDescending(input, 0, index);
        }

        System.out.print("Descending Order: ");
        Arrays.stream(input).forEach(value -> System.out.print(value + " "));
    }

    private static void heapSortAscending(int[] input) {
        int n = input.length;

        for(int index = n/2; index >=0; index--){       //As Root is N/2
            heapifyAscending(input, index, n);   // Building MaxHeap
        }

        for(int index = n - 1; index >= 0; index--){
            swap(input, 0, index);
            heapifyAscending(input, 0, index);
        }

        System.out.print("Ascending Order: ");
        Arrays.stream(input).forEach(value -> System.out.print(value + " "));
    }

    private static void heapifyDescending(int[] input, int index, int n) {
        int largest = index;    //root
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < n && input[left] < input[largest]){
            largest = left;
        }
        if(right < n && input[right] < input[largest]){
            largest = right;
        }

        if(index != largest){
            swap(input, index, largest);
        }
    }

    private static void heapifyAscending(int[] input, int index, int n) {
        int largest = index;    //root
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < n && input[left] > input[largest]){
            largest = left;
        }
        if(right < n && input[right] > input[largest]){
            largest = right;
        }

        if(index != largest){
            swap(input, index, largest);
        }
    }

    private static void swap(int[] input, int index, int largest) {
        int temp = input[index];
        input[index] = input[largest];
        input[largest] = temp;
    }
}
