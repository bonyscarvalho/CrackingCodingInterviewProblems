package LeetCodeMedium;

import java.util.Arrays;

//16. 3Sum Closest
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4}; int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int closestVal = Integer.MAX_VALUE;
        int result = 0;
        int size = nums.length;
        Arrays.sort(nums);

        for(int idx = 0; idx < size; idx++){
            int low = idx + 1, high = size - 1;

            while (low < high){
                int sum = nums[idx] + nums[low] + nums[high];

                if(Math.abs(target - sum) < closestVal){
                    closestVal = Math.abs(target - sum);
                    result = sum;
                }

                if(sum == target) {
                    return sum;
                }else if(sum < target){
                        low++;
                }else {
                        high--;
                }
            }
        }

        return result;
    }
}
