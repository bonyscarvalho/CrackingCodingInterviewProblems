package CyclicSort;

import java.util.Arrays;

//41. First Missing Positive
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4}; //{1,2,0}; // 1 to N :- 4 position is index 3

        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;

        int idx = 0;
        while (idx < nums.length){
//            if(nums[idx] <= 0 || nums[idx] >= nums.length){
//                idx++;
//                continue;
//            }
            int correctIdx = nums[idx] - 1;

            if(nums[idx] > 0 && nums[idx] <= nums.length && nums[idx] != nums[correctIdx]){
                swapToCorrectIdx(idx, correctIdx, nums);
            }else {
                idx++;
            }
        }

        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                return index + 1;
            }
        }

        return nums.length + 1;
    }

    private static void swapToCorrectIdx(int idx, int actualIdx, int[] nums) {
        int temp = nums[idx];
        nums[idx] = nums[actualIdx];
        nums[actualIdx] = temp;
    }
}
