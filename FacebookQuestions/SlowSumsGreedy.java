package FacebookQuestions;

import java.util.Arrays;

public class SlowSumsGreedy {
    public static void main(String[] args) {
        int[] arr_1 = {4, 2, 1, 3};
        int expected_1 = 26;
        System.out.println(getTotalTime(arr_1));

        int[] arr_2 = {2, 3, 9, 8, 4};
        int expected_2 = 88;
        System.out.println(getTotalTime(arr_2));
    }

    private static int getTotalTime(int[] arr) {
        if(arr.length == 0) return 0;

        int totalPenalty = 0;
        Arrays.sort(arr);
        int currPenalty = arr[arr.length - 1];

        for(int idx = arr.length - 2; idx >= 0; idx--){
            int num = arr[idx];

            currPenalty = currPenalty + num;
            totalPenalty += currPenalty;
        }

        return totalPenalty;
    }
}
