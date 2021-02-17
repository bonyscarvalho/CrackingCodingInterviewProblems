package Extra;

import ChapterBitManipulation.Insertion;

import java.util.Arrays;
import java.util.HashSet;

public class ConsecutiveArray {
    public static void main(String args[]) {
        int[] arr = {4, 2, 1, 6, 5};
        int[] arr1 = {5, 5, 1, 3, 5};

        int consecutiveCount = getConsecutiveIntCount(arr1);
        int consecutiveCount1 = getConsecutiveSortAndCount(arr);

        System.out.println("Consecutive Count: " +consecutiveCount1);
    }

    private static int getConsecutiveSortAndCount(int[] arr1) {
        if(arr1.length == 0) return 0;
        Arrays.sort(arr1);

        int maxCount = 1;
        int currCount = 1;
        for (int i = 0; i < arr1.length - 1; i++){
            if((arr1[i] + 1) == arr1[i + 1]){
                currCount++;
            }else {
                currCount = 1;
            }
            if(currCount > maxCount){
                maxCount = currCount;
            }
        }

        System.out.println("Max Count: " + maxCount);
        return maxCount;
    }

    private static int getConsecutiveIntCount(int[] arr) {
        if(arr.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr){
            set.add(num);
        }
        int maxConsecutiveCount = 0;
        for (int num : set){
            if(set.contains(num - 1)) continue; //No Need to count if there is a previous Num of the curr Num
            int count = 0;
            while (set.contains(num++)){
                count++;
            }
            maxConsecutiveCount = Math.max(count, maxConsecutiveCount);
        }

        return maxConsecutiveCount;
    }
}
