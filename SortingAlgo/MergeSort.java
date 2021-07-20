package SortingAlgo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        int input[] = {5, -2, 2, -8, 3, -10, -6, -1, 2, -2, 9, 1, 1};
        System.out.println(mergeSort(input));   //O(N) SPACE
        System.out.println(mergeSortApp1(input));   //O(NlogN) SPACE
    }

    public static int[] mergeSort(int[] array) {
        // Write your code here.
        if(array.length <= 1) return array;

        int[] auxiliaryArray = array.clone();	//Just as new array but filled with values
        mergeSort(array, 0, array.length - 1, auxiliaryArray);

        return array;
    }

    public static void mergeSort(int[] mainArr, int startIdx, int endIdx, int[] auxiliaryArray) {
        if(startIdx == endIdx){
            return;
        }

        int midIdx = (startIdx + endIdx) / 2;
        mergeSort(auxiliaryArray, startIdx, midIdx, mainArr);
        mergeSort(auxiliaryArray, midIdx + 1, endIdx, mainArr);

        doMerge(mainArr, startIdx, midIdx, endIdx, auxiliaryArray);
    }

    public static void doMerge(int[] mainArr, int startIdx, int midIdx, int endIdx, int[] auxiliaryArray){
        int k = startIdx, i = startIdx, j = midIdx + 1;

        while((i <= midIdx) && (j <= endIdx)){
            if(auxiliaryArray[i] <= auxiliaryArray[j]){
                mainArr[k++] = auxiliaryArray[i++];
            }else{
                mainArr[k++] = auxiliaryArray[j++];
            }
        }

        while(i <= midIdx){
            mainArr[k++] = auxiliaryArray[i++];
        }
        while(j <= endIdx){
            mainArr[k++] = auxiliaryArray[j++];
        }

    }

    public static int[] mergeSortApp1(int[] array) {
        // Write your code here.
        if(array.length <= 1){
            return array;
        }
        int midIdx = array.length / 2;
        //original − This is the array from which a range is to to be copied.
        //from − This is the initial index of the range to be copied, inclusive.
        //to − This is the final index of the range to be copied, exclusive.
        int[] leftArr = Arrays.copyOfRange(array, 0, midIdx);
        int[] rightArr = Arrays.copyOfRange(array, midIdx, array.length);

        return mergeSortedArrays(mergeSort(leftArr), mergeSort(rightArr));
    }

    public static int[] mergeSortedArrays(int[] leftArr, int[] rightArr) {
        int[] sortedArr = new int[leftArr.length + rightArr.length];

        int leftPtr = 0, rightPtr = 0, idx = 0;

        while((leftPtr < leftArr.length) && (rightPtr < rightArr.length)){
            if(leftArr[leftPtr] <= rightArr[rightPtr]){
                sortedArr[idx++] = leftArr[leftPtr++];
            }else{
                sortedArr[idx++] = rightArr[rightPtr++];
            }
        }

        while(leftPtr < leftArr.length){
            sortedArr[idx++] = leftArr[leftPtr++];
        }
        while(rightPtr < rightArr.length){
            sortedArr[idx++] = rightArr[rightPtr++];
        }

        return sortedArr;
    }
}
