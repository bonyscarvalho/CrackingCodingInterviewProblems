package CyclicSort;

import java.util.Arrays;

//645. Set Mismatch
public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4}; // 1 to N :- 4 position is index 3

        int[] errorNums = findErrorNums(nums);
        Arrays.stream(errorNums).forEach(value -> System.out.print(value + " "));
    }

    public static int[] findErrorNums(int[] nums) {
        int idx = 0 ;
        while (idx < nums.length){
            int correctIdx = nums[idx] - 1;

            if(nums[idx] != nums[correctIdx]){
                swapToCorrectIdx(idx, correctIdx, nums);
            }else {
                idx++;
            }
        }

        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                return new int[]{nums[index], index + 1};
            }
        }

        return new int[0];
    }

    private static void swapToCorrectIdx(int idx, int actualIdx, int[] nums) {
        int temp = nums[idx];
        nums[idx] = nums[actualIdx];
        nums[actualIdx] = temp;
    }
}
