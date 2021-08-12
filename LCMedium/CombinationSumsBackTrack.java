package LeetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//39. Combination Sum and 40.
public class CombinationSumsBackTrack {
    public static void main(String[] args) {
        int [] candidates1 = {2,3,6,7}; int target1 = 7;
        int [] candidates2 = {2,3,5}; int target2 = 8;
        //System.out.println(combinationSum(candidates1, target1));
        //System.out.println(combinationSum(candidates2, target2));

        int [] uniqueCandidates1 = {10,1,2,7,6,1,5}; int uniqueTarget1 = 8;
        int [] uniqueCandidates2 = {2,5,2,1,2}; int uniqueTarget2 = 5;
        System.out.println(combinationSumUnique(uniqueCandidates1, uniqueTarget1));
        System.out.println(combinationSumUnique(uniqueCandidates2, uniqueTarget2));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return new ArrayList<>();

        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        combinationSum(candidates, target,0, results, new ArrayList<Integer>());

        return results;
    }

    private static void combinationSum(
            int[] candidates, int target, int currIdx, List<List<Integer>> results, ArrayList<Integer> currComb) {
        if(target < 0)return;

        if(target == 0){
            results.add(new ArrayList<>(currComb));
            //return;
        }

        for (int idx = currIdx; idx < candidates.length; idx++){
            //Important: Need to create new reference as the values will be used in different method
            //target = target - candidates[idx];
            //int tempTarget = target - candidates[idx];
            currComb.add(candidates[idx]);
            combinationSum(candidates, target - candidates[idx], idx, results, currComb);
            currComb.remove(currComb.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSumUnique(int[] candidates, int target) {
        if(candidates.length == 0) return new ArrayList<>();

        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        combinationSumUnique(candidates, target,0, results, new ArrayList<Integer>());

        return results;
    }

    private static void combinationSumUnique(int[] candidates, int target, int currIdx,
                                             List<List<Integer>> results, ArrayList<Integer> currList) {
        if(target < 0){ //|| currIdx >= candidates.length don't need this as you are already validating in for loop
            return;
        }
        if(target == 0){
            results.add(new ArrayList<>(currList));
            return;
        }
        //10,1,2,7,6,1,5 -> 1,1,2,5,6,7,10
        for(int idx = currIdx; idx < candidates.length; idx++){
            //We have this condition so that the same number results are not calculated again
            //Result -> [[1, 1, 6], [1, 2, 5], [1, 7], [1, 2, 5], [1, 7], [2, 6]] for 2 1s as both have calculated results
            //idx > currIdx is for idx should be greater and not same
//            if(idx > currIdx && candidates[currIdx] == candidates[idx]){
//                continue;
//            }
            //idx == currIdx is for ZERO
            if(idx == currIdx || candidates[idx] != candidates[idx - 1]){
                if(target - candidates[idx] < 0){
                    break;
                }
                currList.add(candidates[idx]);
                combinationSumUnique(candidates, target - candidates[idx], idx + 1, results, currList);
                currList.remove(currList.size() - 1);
            }
        }
    }

}
