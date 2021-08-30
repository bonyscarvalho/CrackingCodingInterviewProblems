package CyclicSort;

import java.util.ArrayList;
import java.util.List;

/*
if Range is from (0 to N) then every element will be at index = value;
if Range is from (1 to N) then every element will be at index = value - 1;
 */

//448. Find All Numbers Disappeared in an Array
public class FindAllNumbersDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1}; // 1 to N :- 4 position is index 3

        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0)return null;

        int idx = 0;

        while (idx < nums.length){
            int actualIdx = nums[idx] - 1;

            if(nums[idx] != nums[actualIdx]){
                swapToCorrectIdx(idx, actualIdx, nums);
            }else {
                idx++;
            }
        }

        List<Integer> disapperedNums = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
            if(nums[index] - 1 != index){
                disapperedNums.add(index + 1);
            }
        }

        return disapperedNums;
    }

    private static void swapToCorrectIdx(int idx, int actualIdx, int[] nums) {
        int temp = nums[idx];
        nums[idx] = nums[actualIdx];
        nums[actualIdx] = temp;
    }
}
