package FacebookQuestions;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicalCandyBags {
    public static void main(String args[]) {
        int n_1 = 5, k_1 = 3;
        int[] arr_1 = {2, 1, 7, 4, 2};
        int expected_1 = 14;
        System.out.println(maxCandies(arr_1, k_1));

        int n_2 = 9, k_2 = 3;
        int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        int expected_2 = 228;
        System.out.println(maxCandies(arr_2, k_2));
    }

    private static int maxCandies(int[] arr, int k) {
        if(arr.length == 0)return 0;

        int maxCandy = 0;
        PriorityQueue<Integer> queue =  new PriorityQueue<>(Collections.reverseOrder());
        for(int num : arr){
            queue.add(num);
        }

        while (k > 0){
            int currCandy = queue.poll();
            maxCandy += currCandy;
            queue.add(currCandy/2);
            k--;
        }

        return maxCandy;
    }
}
