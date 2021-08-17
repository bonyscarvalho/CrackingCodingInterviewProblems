package LeetCodeMedium;

import java.util.Arrays;

//189. Rotate Array
public class RotateArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7}; int k = 3;
        rotate(nums1, k);
        Arrays.stream(nums1).forEach(value -> System.out.print(value+" "));
    }

    public static void rotate(int[] nums, int k) {
//         k = k % nums.length;
//         int count = 0;  //keep count of the nums changed

//         for(int idx = 0; count < nums.length; idx++){
//             int curr = idx;
//             int prev = nums[idx];

//             do{
//                 int nextIdx = (curr + k) % nums.length;
//                 int temp = nums[nextIdx];
//                 nums[nextIdx] = prev;
//                 prev = temp;
//                 curr = nextIdx;
//                 count++;
//             }while(idx != curr);
//         }

        k = k % nums.length;
        reverseArr(nums, 0, nums.length - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, nums.length - 1);
    }

    public static void reverseArr(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
