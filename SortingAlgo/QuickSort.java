package SortingAlgo;

import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]) {
        int[] input = {9, 5, 2, 6, 8, 3, 7, 23, 11, 5};
        quickSort(input);
    }
    private static void quickSort(int[] input) {
        if(input.length == 0) return;

        quickSort(input, 0, input.length-1);
        //Arrays.stream(input).forEach(value -> System.out.print(value + " " ));
    }

    private static void quickSort(int[] input, int left, int right) {
        if(left >= right) return;

            int pivotVal = input[((left + right) / 2)];     //9, 5, 2, 6, 8, 3, 7, 23, 11, 5

            int pivotIdx = partition(input, left, right, pivotVal);

            quickSort(input,left, pivotIdx - 1);
            quickSort(input, pivotIdx, right);

    }

    private static int partition(int[] input, int left, int right, int pivotVal) {
        System.out.println("PIVOT : " +pivotVal);
        while(left <= right){

            while (input[left] < pivotVal){
                System.out.println("Left: " +left);
                left++;
            }
            while (input[right] > pivotVal){
                System.out.println("Right: " +right);
                right--;
            }

            if(left <= right){
                System.out.println("SWAP left:" +left +" right: "+right);
                swap(input, left, right);
                left++;
                right--;
            }
        }
        Arrays.stream(input).forEach(value -> System.out.print(value + " " ));
        return left;
    }

    private static void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
    
    /*
    public static int[] quickSort(int[] array) {
    // Write your code here.
    quickSort(array, 0, array.length - 1);
		return array;
  }
	
	public static void quickSort(int[] array, int startIdx, int endIdx) {
		if(startIdx >= endIdx){
			return;
		}
		
		int pivotIdx = startIdx;
		int leftIdx = startIdx + 1;
		int rightIdx = endIdx;
		
		while(leftIdx <= rightIdx){
			if((array[leftIdx] > array[pivotIdx]) && (array[rightIdx] < array[pivotIdx])){
				swap(leftIdx, rightIdx, array);
			}
			
			if(array[leftIdx] <= array[pivotIdx]){
				leftIdx++;
			}
			if(array[rightIdx] >= array[pivotIdx]){
				rightIdx--;
			}
		}
		swap(pivotIdx, rightIdx, array);
		
		//Reduce the space complexity from N to logN as you are sorting the smaller side 1st 
		//in tail recursion. Which will be execute fast and less space then other way round
		boolean leftSideLesser = (rightIdx - 1 - startIdx) < (endIdx - rightIdx + 1);
		if(leftSideLesser){
			quickSort(array, startIdx, rightIdx - 1);
			quickSort(array, rightIdx + 1, endIdx);
		}else{
			quickSort(array, rightIdx + 1, endIdx);
			quickSort(array, startIdx, rightIdx - 1);
		}
	}
	
	private static void swap(int first, int second, int[] input) {
        int temp  = input[first];
        input[first] = input[second];
        input[second] = temp;
    }
    */

}
