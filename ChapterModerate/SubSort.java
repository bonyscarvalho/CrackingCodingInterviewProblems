package ChapterModerate;

import java.util.ArrayList;
import java.util.List;

public class SubSort {
    public static void main(String[] args) {
        int[] input = {1, 2, 4, 7, 10, 11, 8, 12, 3, 6, 16, 18, 19};//{1,2,3,4, 5,6,7,8};//{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};

        List<Integer> result = findTheIndexForSubSort(input);
    }

    private static List<Integer> findTheIndexForSubSort(int[] input) {
        if(input.length == 0)return null;

        int endLeftMaxIdx = findEndLeftMaxIdx(input);
        if(endLeftMaxIdx >= input.length - 1) return null; //sorted Array

        int startRightMinIdx = findStartRightMinIdx(input);
        if(startRightMinIdx == 0)return null; //sorted

        int minIdx = startRightMinIdx;  //right min Value
        int maxIdx = endLeftMaxIdx; //left Max value
        for (int i = endLeftMaxIdx + 1; i < startRightMinIdx; i++){
            if(input[i] < input[minIdx]){
                minIdx = i;
            }
            if(input[i] > input[maxIdx]){
                maxIdx = i;
            }
        }

        int leftIdx = shrinkLeft(input, minIdx, endLeftMaxIdx);
        int rightIdx = shrinkRight(input, maxIdx, startRightMinIdx);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(leftIdx);res.add(rightIdx);
        System.out.println(res);
        return res;
    }

    private static int shrinkRight(int[] input, int maxIdx, int start) {
        int maxVal = input[maxIdx];
        for (int i = start; i < input.length; i++){
            if(input[i] >= maxVal){
                return i - 1;
            }
        }
        return input.length - 1;
    }

    private static int shrinkLeft(int[] input, int minIdx, int start) {
        int minVal = input[minIdx];
        for(int i = start; i >= 0; i--){
            if(input[i] <= minVal){
                return i + 1;
            }
        }
        return 0;
    }

    private static int findEndLeftMaxIdx(int[] input) {
        for(int i = 1; i < input.length; i++){
            if(input[i-1] > input[i]){
                return i-1;
            }
        }
        return input.length - 1;
    }

    private static int findStartRightMinIdx(int[] input) {
        for (int i = input.length - 2; i >= 0; i--){
            if(input[i] > input[i + 1]) return i+1;
        }
        return 0;
    }




    //this won't work due as we were comparing the last Idx Val from the start of the Arr
    // but if before that value you had values less then the previous ones it wil cause an issue
//    private static List<Integer> findTheIndexForSubSort(int[] input) {
//        if(input.length == 0)return null;
//
//        int endIdx = 0;
//        int minVal = input[0];
//        int maxVal = input[0];
//
//        for (int i = 1; i < input.length; i++){
//            if(input[i] > maxVal){
//                maxVal = input[i];
//            }
//
//            if(input[i] < maxVal){
//                minVal = input[i];
//                endIdx = i;
//            }
//        }
//
//        System.out.println(endIdx);
//        int endVal = input[endIdx];
//
//        int startIdx = 0;
//        for (int i = 0; i < input.length; i++){
//            if(input[i] >= endVal){
//                startIdx = i;
//                break;
//            }
//        }
//
//
//        System.out.println(startIdx);
//
//
//        return null;
//    }

    private static int binarySearch(int[] input, int targetVal) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end){
            int mid = (end - start) / 2;

            if(input[mid] <= targetVal){
                return mid;
            }else if(input[mid] > targetVal){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
