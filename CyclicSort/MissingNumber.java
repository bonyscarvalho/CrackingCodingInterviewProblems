package CyclicSort;
//268. Missing Number
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};

        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        if(nums.length == 0) return 0;

        int idx = 0;
        while(idx < nums.length){
            int actualIdx = nums[idx];

            if(nums[idx] < nums.length && nums[idx] != nums[actualIdx]){
                swapToCorrectIdx(idx, actualIdx, nums);
            }else {
                idx++;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }

        return nums.length;
    }

    private static void swapToCorrectIdx(int idx, int actualIdx, int[] nums) {
        int temp = nums[idx];
        nums[idx] = nums[actualIdx];
        nums[actualIdx] = temp;
    }
}
