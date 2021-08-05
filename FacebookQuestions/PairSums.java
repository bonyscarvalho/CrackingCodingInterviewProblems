package FacebookQuestions;

import java.util.HashMap;
import java.util.Map;

public class PairSums {
    public static void main(String[] args) {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        System.out.println(numberOfWays(arr_1, k_1));

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        System.out.println(numberOfWays(arr_2, k_2));
    }

    private static int numberOfWays(int[] arr, int k) {
        if(arr.length  == 0) return -1;

        Map<Integer, Integer> counts = new HashMap<>();
        int totalCounts = 0;

        for(int num : arr){
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for(int num : arr){
            int remaining = k - num;

            if(counts.containsKey(remaining)){
                totalCounts += counts.get(num);
                //if both curr remaining and 3 + 3 = 6
                if(remaining == num){
                    totalCounts--;
                }
            }
        }
        //as we have counted the value twice
        return totalCounts/2;
    }
}
