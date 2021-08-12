package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumJMinusIVIP {
    public static void main(String[] args)
    {
        int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
        int n = arr.length;
        int maxDiff = maxIndexDiff(arr, n);
        System.out.println(maxDiff);
        int maxDiffHashApp = maxIndexDiffHashAndSort(arr, n);
        System.out.println(maxDiffHashApp);
    }

    private static int maxIndexDiff(int[] arr, int n) {
        if(arr.length == 0) return 0;

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int maxDiff = -1;

        leftMin[0] = arr[0];
        for(int idx = 1; idx < n; idx++){
            leftMin[idx] = Math.min(arr[idx], leftMin[idx - 1]);    //keeping track of all mins till Idx like 0 to idx
        }

        rightMax[n - 1] = arr[n - 1];
        for (int idx = n - 2; idx >= 0; idx--){
            rightMax[idx] = Math.max(arr[idx], rightMax[idx + 1]);  // track of all max from idx to len-1
        }

        int minIdx = 0, maxIdx = 0;
        while (maxIdx < n && minIdx < n){
            if(leftMin[minIdx] <= rightMax[maxIdx]){
                maxDiff = Math.max(maxDiff, maxIdx - minIdx);
                maxIdx++;
            }else {
                minIdx++;
            }
        }

        return maxDiff;
    }

    private static int maxIndexDiffHashAndSort(int[] arr, int n) {
        if(arr.length == 0) return 0;

        Map<Integer, ArrayList<Integer>> numToIdxMap = new HashMap<>(); //created a list to handle duplicates

        for(int idx = 0; idx < n; idx++){
            if(numToIdxMap.containsKey(arr[idx])){
                numToIdxMap.get(arr[idx]).add(idx); //for duplicates you add the num to the idx
            }else {
                numToIdxMap.put(arr[idx], new ArrayList<>());
                numToIdxMap.get(arr[idx]).add(idx);
            }
        }

        Arrays.sort(arr);   //sort for being in ordered
        int maxDiff = -1;
        int minSumIdx = n;

        for (int idx = 0; idx < n; idx++){
            //Check if the num's idx is less then the curr minSumIdx we had
            if (numToIdxMap.get(arr[idx]).get(0) < minSumIdx){
                //getting the 1st val of the min Idx as we had added the list in idx increasing order
                //so we get the smallest Idx
                minSumIdx = numToIdxMap.get(arr[idx]).get(0);
            }
            int currMaxIdx = numToIdxMap.get(arr[idx]).get(numToIdxMap.get(arr[idx]).size() - 1);  //last Idx as it will be max
            maxDiff = Math.max(maxDiff, currMaxIdx - minSumIdx);
        }

        return maxDiff;
    }
}
