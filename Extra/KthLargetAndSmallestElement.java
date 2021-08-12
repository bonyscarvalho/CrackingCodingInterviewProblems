package Extra;

import java.util.Arrays;

public class KthLargetAndSmallestElement {
    //Can be done in HEAP too but time will be N*k*log K
    //this is O(N) in average case
    //Quick Select: Over here to find the kth Index value you have to start from mid and keep arranging the values until you find the kth Idx Value == pivot Value
    //we do it like BST with the kth Idx value greater or lesser then the pivot Idx
    public static void main(String args[]) {
        int[] input = {3, 2, 1, 5, 6, 4};              //{1, 1, 1, 2, 2, 3};
        int k = 2;
        //We use the quick select trick from quick sort.
        //We divide the element according to the pivot value and check if the pivotIdx == kthIdx if yes then we return else we check the returned value and greater and less
        int kthLargestElement = findKthLargestElement(input, k);
        int kthSmallestElement = findKthSmallestElement(input, k);

        System.out.println("Largest: " + kthLargestElement);
        System.out.println("Smallest: " + kthSmallestElement);
        System.out.println("Smallest: " + quickselect(input, k));

    }

    private static int findKthSmallestElement(int[] input, int k) {
        int len = input.length;
        int left = 0;
        int right = len - 1;

        while (left <= right){
            int midIdx = (right + left) / 2;

            int pivotIdx = partitonArr(input, left, right, midIdx);

            if(pivotIdx == k - 1){  //as the 4th smallest element will be on the 3rd Index
                //Arrays.stream(input).forEach(value -> System.out.print(value + " "));
                return input[pivotIdx];
            }else if(pivotIdx > k){
                right = pivotIdx - 1;
            }else {
                left = pivotIdx + 1;
            }
        }

        Arrays.stream(input).forEach(value -> System.out.print(value + " "));
        return -1;
    }

    private static int findKthLargestElement(int[] input, int k) {
        int len = input.length;
        int left = 0;
        int right = len - 1;

        int kthIdxValue = len - k;

        while (left <= right){
            int midIdx = (right + left) / 2;

            int pivotIdx = partitonArr(input, left, right, midIdx);

            if(pivotIdx == kthIdxValue){
                //Arrays.stream(input).forEach(value -> System.out.print(value + " "));
                return input[pivotIdx];
            }else if(pivotIdx > kthIdxValue){
                right = pivotIdx - 1;
            }else {
                left = pivotIdx + 1;
            }

        }

        Arrays.stream(input).forEach(value -> System.out.print(value + " "));
        return -1;
    }

    private static int partitonArr(int[] input, int left, int right, int pivotIdx) {

        int pivotValue = input[pivotIdx];
        int lesserItemsTailIndex = left;    //this will be the exact position of the pivot value

        swap(input, pivotIdx, right);

//        int[] input = {3, 2, 5, 1, 6, 4};              //{1, 1, 1, 2, 2, 3};
//        int k = 2;
        for(int i = left; i < right; i++){
            if(input[i] < pivotValue){
                swap(input, i, lesserItemsTailIndex);   //PUTTING THE ELEMENT TO THE LEFT SIDE OF PIVOT VALUE. If element greater then idx will increase but lesserItemsTailIndex won't
                lesserItemsTailIndex++;     //Incrementing the idx for finding the correct position of pivot
                //incrementing the value if less to find the exact position of pivotVal
            }
        }

        swap(input, right, lesserItemsTailIndex);

        return lesserItemsTailIndex;
    }

    private static void swap(int[] input, int right, int kthValueIndex) {
        int temp  = input[right];
        input[right] = input[kthValueIndex];
        input[kthValueIndex] = temp;
    }

    public static int quickselect(int[] array, int k) {
        // Write your code here.
        int kthPositionIdx = k - 1;

        return quickselect(0, array.length - 1, kthPositionIdx, array);
    }

    public static int quickselect(int startIdx, int endIdx, int positionIdx, int[] array) {
        while(true){
            if(startIdx > endIdx){
                throw new RuntimeException("Your Algo Should Never come here");
            }
            int pivotIdx = startIdx;
            int leftIdx = startIdx + 1;
            int rightIdx = endIdx;

            while(leftIdx <= rightIdx){
                if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]){
                    swap(leftIdx, rightIdx, array);
                }
                if(array[leftIdx] <= array[pivotIdx]){//correct Position
                    leftIdx++;
                }
                if(array[rightIdx] >= array[pivotIdx]){//correct Position
                    rightIdx--;
                }
            }
            swap(rightIdx, pivotIdx, array);
            if(rightIdx == positionIdx){
                return array[rightIdx];
            }else if(rightIdx < positionIdx){
                startIdx = rightIdx + 1;
            }else{
                endIdx = rightIdx - 1;
            }
        }
    }

    private static void swap(int first, int second, int[] input) {
        int temp  = input[first];
        input[first] = input[second];
        input[second] = temp;
    }

}
