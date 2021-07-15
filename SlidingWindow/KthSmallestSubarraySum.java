package LeetCodeMedium;
//1918. Kth Smallest Subarray Sum
//Kth Index SubArray SUM
public class KthSmallestSubarraySum {
    public static void main(String args[]) {

        int[] nums1 = {3,3,5,5}; int k1 = 7;
        int[] nums2 = {2,1,3}; int k2 = 4;    //nums = [2,1,3], k = 4
        //[2,9,2,10,7]
        //1
        int[] nums3 = {2,9,2,10,7}; int k3 = 1;

        System.out.println(kthSmallestSubarraySum(nums1, k1));
        System.out.println(kthSmallestSubarraySum(nums2, k2));
        System.out.println(kthSmallestSubarraySum(nums3, k3));
    }

    public static int kthSmallestSubarraySum(int[] nums, int k) {
        if(nums.length == 0)return -1;

        int totalSum = 0;
        for(int num : nums){
            totalSum += num;    //MAX LIMIT OF SUM for our RightPtr
        }
        //2,1,3     //k -> 4
        //totalSUm = 6 mid = 3 count => 4
        //l->0 h-> 2 mid->1

        int lowSum = 0, highSum = totalSum;

        while (lowSum <= highSum){
            int midSum = (lowSum + highSum)/2;    //Mid Sum for calculating subarray to less then MID

            int subArrayCountWithMidSum = numberOfSubArray(nums, midSum);
            System.out.println("midSum: " + midSum + "lowSum: " + lowSum + "highSum: " + highSum + "subArrayCountWithMidSum: " + subArrayCountWithMidSum);
//            if(subArrayCountWithMidSum < k){
//                lowSum = midSum + 1;
//            }else{
//                highSum = midSum - 1;
//            }

            if(subArrayCountWithMidSum == k - 1){
                return midSum;
            }if(subArrayCountWithMidSum < k){
                lowSum = midSum + 1;
            }else{
                highSum = midSum - 1;
            }

            //NO IDEA WHY THIS DOESN't WORK
//            if (k < midSum) {
//                highSum = midSum + 1;
//            } else if (k > subArrayCountWithMidSum) {
//                lowSum = midSum + 1;
//            }else{
//                return midSum;
//            }


        }

        //The lower bound will tells us, there are k sums that less than this lower bound, which makes this lower bound the kth smallest value, or the largest among these k sums.
        return lowSum;
    }

    //Normal Sliding window approach for finding number of subarray less the target
    private static int numberOfSubArray(int[] nums, int target) {
        int start = 0;
        int prefixSum = 0;
        int totalSubArrayCount = 0;

        for(int end = 0; end < nums.length; end++){
            prefixSum += nums[end];

            //Shrinking Stage
            while (prefixSum > target){
                prefixSum -= nums[start];
                start++;
            }

            totalSubArrayCount += (end - start + 1);    //Number of count of array less then target between start and end Index
        }

        return totalSubArrayCount;
    }
}
