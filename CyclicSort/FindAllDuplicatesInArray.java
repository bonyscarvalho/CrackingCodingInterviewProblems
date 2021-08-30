package CyclicSort;

import java.util.ArrayList;
import java.util.List;

//442. Find All Duplicates in an Array
public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1}; // 1 to N :- 4 position is index 3

        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int idx = 0;

        while (idx < nums.length){
            int correctIdx = nums[idx] - 1;

            if(nums[idx] != nums[correctIdx]){
                swapToCorrectIdx(idx, correctIdx, nums);
            }else {
                idx++;
            }
        }

        List<Integer> duplicates = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                duplicates.add(nums[index]);
            }
        }

        return duplicates;
    }

    private static void swapToCorrectIdx(int idx, int actualIdx, int[] nums) {
        int temp = nums[idx];
        nums[idx] = nums[actualIdx];
        nums[actualIdx] = temp;
    }
}
