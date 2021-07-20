package LeetCodeMedium.SlidingWindow.SumOfSubArray;
//1524. Number of Sub-arrays With Odd Sum
//DP and PrefixSum
public class NumberOfSubArraysWithOddSum {
    public static void main(String args[]) {
        int[] nums = {1,3,5};
        System.out.println(numOfSubarrays(nums));
        System.out.println(numOfSubarrays(new int[]{2, 4, 6}));
    }

    public static int numOfSubarrays(int[] arr) {
        if(arr.length == 0)return 0;

        int[][] evenOddCount = new int[arr.length + 1][2];

        int totalOddSumCount = 0;

        for(int idx = 1; idx <= arr.length; idx++){
            if((arr[idx - 1] % 2) == 0) {   //increment the even count
                evenOddCount[idx][0] = evenOddCount[idx - 1][0] + 1;
                evenOddCount[idx][1] = evenOddCount[idx - 1][1];
            }else { //increment the odd count with help of number of even counts as till now number of even will +1 will be total number of odds till that IDX
                //2 odds can only make 2 odds but 2 even and 1 odd can make 3 pair in total EO-> O EE->E OO->E
                evenOddCount[idx][0] = evenOddCount[idx - 1][1];
                evenOddCount[idx][1] = evenOddCount[idx - 1][0] + 1;
            }
        }

        for (int idx = 0; idx <= arr.length; idx++){
            totalOddSumCount += evenOddCount[idx][1];
        }

        return totalOddSumCount;
    }

    public static int numOfSubarraysPrefixSum(int[] arr) {
        int odd = 0;    // number of subarrays with odd sum so far
        int even = 1; // number of subarrays with even sum so far (0 is even so count is 1)
        int prefixSum = 0;
        int count = 0;

        for (int num: arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                count += odd;   // add odd count as that will be number of pairs generated
                // the difference is odd
                // -> add number of subarrays in between
                even++;
            } else {
                count += even;  // add the even found till now with help of prefix SUm
                odd++;
            }

            count %= 1000000007;
        }

        return count;

    }
}
