package DynamicProgramming;

import java.util.Arrays;

//152. Maximum Product Subarray
public class MaxProductSubArray {
    public static void main(String[] args)
    {
        int[] arr = {2, 3, -2, 4};   //{-2,3,2,-4};            //{-3,-1,-1};        //{2, 3, -2, 4, 2};
        int bruteForce = computeMaxProductBruteForce(arr);
        int kadaneApp = computeMaxProductByKadane(arr);
    }

    private static int computeMaxProductByKadane(int[] arr) {
        if(arr.length == 0) return 0;

        int min_so_far = arr[0];
        int max_so_far = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++){
            int curr = arr[i];
            // tempMin for as to calculation of maxValue in next operation.
            // Values shouldn't get affected due to current operation
            int temp_Min = Math.min(curr, Math.min((max_so_far * curr), (min_so_far * curr)));

            max_so_far = Math.max(curr, Math.max((max_so_far * curr), (min_so_far * curr)));
            min_so_far = temp_Min;
            System.out.println("curr: " +curr+" minSoFar: " +min_so_far+ "maxSoFar: " +max_so_far);

            result = Math.max(result, max_so_far);
        }

        System.out.println(result);
        return result;
    }

    private static int computeMaxProductBruteForce(int[] arr) {
        if(arr.length == 0)return 0;

        int result = arr[0];

        for(int i = 0; i < arr.length; i++){
            int num = 1;
            for (int j = i; j < arr.length; j++){
                num = num * arr[j];
                result = Math.max(result, num);
            }
        }
        System.out.println(result);

        return result;
    }
}
