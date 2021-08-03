package FacebookQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PassingYearbooks {

    public static void main(String args[]) {
        int[] arr_1 = {2, 1};
        //int[] expected_1 = {2, 2};
        int[] output_1 = findSignatureCounts(arr_1);

        int[] arr_2 = {1, 2};
        //int[] expected_2 = {1, 1};
        int[] output_2 = findSignatureCounts(arr_2);
    }
    //Finding the number of cycle each num at Idx produced
   public static int[] findSignatureCounts(int[] nums) {
        // Write your code here
        int[] res = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        //As from the Student 1 it will be pointing to 0th Idx
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i+1);
        }
        Set<Integer> visited = new HashSet<>();
        for(int k : map.keySet()) {
            if(!visited.contains(k)) {
                Set<Integer> round = new HashSet<>();
                while(!visited.contains(k)) {
                    round.add(k);
                    visited.add(k);
                    k = map.get(k);
                }
                for(int i : round) {
                    res[i-1] = round.size();
                }
            }
        }
        return res;
    }
}
