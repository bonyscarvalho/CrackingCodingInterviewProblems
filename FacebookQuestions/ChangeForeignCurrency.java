package FacebookQuestions;

import java.util.Arrays;

public class ChangeForeignCurrency {
    public static void main(String[] args) {
        int target_1 = 94;
        int arr_1[] = {5, 10, 25, 100, 200};
        boolean expected_1 = false;
        System.out.println(canGetExactChange(target_1, arr_1));

        int target_2 = 75;
        int arr_2[] = {4, 17, 29};
        boolean expected_2 = true;
        System.out.println(canGetExactChange(target_2, arr_2));
    }

    private static boolean canGetExactChange(int target, int[] arr) {
        if(arr.length == 0)return false;
        Arrays.sort(arr);
        return canGetExactChange(target, arr, arr.length - 1);
    }

    private static boolean canGetExactChange(int target, int[] arr, int idx) {
        if(target == 0) return true;
        if(idx < 0 || idx == 0 && arr[idx] > target) return false;

        if(arr[idx] > target){
            return canGetExactChange(target, arr, idx - 1);
        }else {
            while (arr[idx] <= target){
                target  = target - arr[idx];
            }
            return canGetExactChange(target, arr, idx - 1);
        }
    }
}
