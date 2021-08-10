package LeetCodeEasy;

import java.util.Arrays;

//1013. Partition Array Into Three Parts With Equal Sum
public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String args[]) {
       int[] arrT = {3,3,6,5,-2,2,5,1,-9,4};
       //int[] arrF = {0,2,1,-6,6,7,9,-1,2,0,1};
       System.out.println(canThreePartsEqualSum(arrT));
       // System.out.println(canThreePartsEqualSum(arrF));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum(); //Stream can be slow sometime. 
        if(sum%3 != 0){
            return false;
        }

        int targetSum = sum/3;
        int numOfPartition = 0;
        int currSum = 0;
        int idx = 0;

        while (idx < arr.length){
            if(numOfPartition == 3){
                break;
            }
            currSum += arr[idx];

            if(currSum == targetSum){
                numOfPartition++;
                currSum = 0;
            }
            idx++;
        }

        if(numOfPartition != 3){
            return false;
        }
        //Keeping an extra check here so that we can verify if the remaining sum is zero
        if(idx != arr.length){
            int remainingSum = 0;
            for(int j = idx; j < arr.length; j++){
                remainingSum += arr[j];
            }

            if(remainingSum != 0){
                return false;
            }
        }

        return true;
    }
}
