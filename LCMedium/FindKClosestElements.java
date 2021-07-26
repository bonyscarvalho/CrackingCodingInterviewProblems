package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

//658. Find K Closest Elements
public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;

        System.out.println(findClosestElements(arr, k, x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length == 0) return null;

        //Finding the index of the closest val so that we can extend from both sides like len of Peak soln
        //and find the starting and ending index of the subarray
        int closestPosition = binarySearch(arr, x);
        int leftPtr = closestPosition;
        int rightPtr = closestPosition;

        while((rightPtr - leftPtr + 1 < k) && (leftPtr > 0) && (rightPtr < arr.length - 1)){
            if(Math.abs(arr[leftPtr - 1] - x) <= Math.abs(arr[rightPtr + 1] - x)){
                leftPtr--;
            }else {
                rightPtr++;
            }
        }

        //Checking if still it is less then K as we want equal to k
        while (rightPtr - leftPtr + 1 < k){
            if(leftPtr > 0){
                leftPtr--;
            }else{
                rightPtr++;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (leftPtr <= rightPtr){
            result.add(arr[leftPtr]);
            leftPtr++;
        }

        return result;

    }

    private static int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1, minDiff = Integer.MAX_VALUE, closest = -1;

        while (low <= high){
            int mid = (low + high) / 2;
            int currMidVal = arr[mid];

            if(Math.abs(currMidVal - x) < minDiff){
                minDiff = Math.abs(currMidVal - x);
                closest = mid;
            }

            if(currMidVal == x){
                return mid;
            }else if(currMidVal < x){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return closest;
    }
}
