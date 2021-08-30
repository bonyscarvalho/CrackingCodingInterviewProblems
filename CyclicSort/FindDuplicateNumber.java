package CyclicSort;
//287. Find the Duplicate Number
public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2}; // 1 to N :- 4 position is index 3

        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int idx = 0;

        while (idx < nums.length){
            if(nums[idx] != idx + 1){
                int correctIdx = nums[idx] - 1;

                if(nums[idx] != nums[correctIdx]){
                    swapToCorrectIdx(idx, correctIdx, nums);
                }else {
                    return nums[idx];
                }
            }else {
                idx++;
            }

        }

//        for(int index = 0; index < nums.length; index++){
//            if(nums[index] != index + 1){
//                return nums[index];
//            }
//        }

        return -1;
    }

    private static void swapToCorrectIdx(int idx, int actualIdx, int[] nums) {
        int temp = nums[idx];
        nums[idx] = nums[actualIdx];
        nums[actualIdx] = temp;
    }
}
