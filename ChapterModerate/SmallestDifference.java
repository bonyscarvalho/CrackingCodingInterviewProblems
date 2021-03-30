package ChapterModerate;

import java.util.ArrayList;
import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args)
    {
        int[] arr1 = {1, 3, 15, 11, 2};
        int[] arr2 = {23, 127, 235, 19, 8};
        //int minDiff = computeDifference(arr1, arr2);
        System.out.println(computeDifferenceApproach(arr1, arr2));
    }

    private static ArrayList<Integer> computeDifferenceApproach(int[] arr1, int[] arr2) {
        if(arr1.length == 0 || arr2.length == 0) return null;

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int index2 = 0;
        int index1 = 0;
        int minDiff = Integer.MAX_VALUE;

        ArrayList<Integer> result = new ArrayList<>();

        while (index1 < arr1.length && index2 < arr2.length) {

            if(Math.abs(arr1[index1] - arr2[index2]) < minDiff){

                ArrayList<Integer> tempList = new ArrayList<>();
                minDiff = Math.abs(arr1[index1] - arr2[index2]);
                System.out.println("Inside Loop: "+minDiff);

                tempList.add(arr1[index1]);
                tempList.add(arr2[index2]);
                result = new ArrayList<>();
                result.addAll(tempList);
            }

            if(arr1[index1] < arr2[index2]){
                index1++;
            }else {
                index2++;
            }
        }
        System.out.println(minDiff);
        return result;
    }

    private static int computeDifference(int[] arr1, int[] arr2) {
        if(arr1.length == 0 || arr2.length == 0) return 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int index2 = arr2.length - 1;
        int index1 = arr1.length - 1;
        int minDiff = Integer.MAX_VALUE;


        while (index1 >= 0 && index2 >= 0){
            int currDiff = 0;

            if(arr1[index1] > arr2[index2]){
                currDiff = arr1[index1] - arr2[index2];
                index1--;
            }else if(arr2[index2] > arr1[index1]){
                currDiff = arr2[index2] - arr1[index1];
                index2--;
            }

            minDiff = Math.min(currDiff, minDiff);
        }
        System.out.println(minDiff);
        return minDiff;
    }
}
