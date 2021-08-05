package FacebookQuestions;

import java.util.Arrays;

public class BalancedSplit {
    public static void main(String[] args) {
        int arr_1[] = {2, 1, 2, 5};
        boolean expected_1 = true;
        System.out.println(balancedSplitExists(arr_1));

        int arr_2[] = {3, 6, 3, 4, 4};
        boolean expected_2 = false;
        System.out.println(balancedSplitExists(arr_2));
    }

    private static boolean balancedSplitExists(int[] arr) {
        if (arr.length == 0) return true;
        //2, 1, 2, 5
        Arrays.sort(arr);

        int totalSum = Arrays.stream(arr).sum();
        int leftSum = 0;

        for (int idx = 0; idx < arr.length - 1; idx++){
            leftSum += arr[idx];
            if(arr[idx] != arr[idx + 1]){
                if(totalSum-leftSum == leftSum)return true;
            }
        }

        return false;
    }
}
