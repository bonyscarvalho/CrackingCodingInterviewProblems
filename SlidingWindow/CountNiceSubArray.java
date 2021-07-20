package LeetCodeMedium.SlidingWindow.Count_NumberOfSubarray;

//1248. Count Number of Nice Subarrays
//Return the number of nice sub-arrays.
public class CountNiceSubArray {
    public static void main(String args[]) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
        System.out.println(numberOfSubarraysSlidingApp(nums, k));
    }

    private static int numberOfSubarraysSlidingApp(int[] nums, int k) {
        if(nums.length == 0)return 0;

        return numberOfSubarraysAtMostK(nums, k) - numberOfSubarraysAtMostK(nums, k - 1);
    }

    private static int numberOfSubarraysAtMostK(int[] nums, int k) {
        int start = 0, sum = 0, result = 0;

        for(int end = 0; end < nums.length; end++){
            sum += nums[end] % 2;   //mod 2 as that would eliminate the even number to zero

            while (sum > k){
                sum -= nums[start] % 2;
                start++;
            }
            result += end - start + 1;
        }

        return result;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        if(nums.length == 0)return 0;

        int count = 0, start = 0, result = 0, kCount = 0;

        for(int end = 0; end < nums.length; end++){
            //1,1,2,1,2,2,1 k = 3
            if((nums[end] % 2) == 1){
                kCount++;
                count = 0;
            }
            while (k == kCount){
                if((nums[start] % 2) == 1){
                    kCount--;
                }
                count++;
                start++;
            }
            //you increase the count of subarray even if the even are found after the index
            //like when k = 0 you know that there were all k odds found. so you increment count by 1 and remove the start Idx num
            //if after that you have some even nums on end IDx then keep on adding count variable as it is still valid and has all K
            //index --> 4 and 5 the count is still 1
            result += count;
        }

        return result;
    }

}
