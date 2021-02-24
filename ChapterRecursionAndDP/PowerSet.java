package ChapterRecursionAndDP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
    public static void main(String[] args) {
        int[] set = {1,2,3};
        ArrayList<ArrayList<Integer>> recursiveRes = getSubsetOfPowerSetRecursively(set);
        System.out.println("Results: " + recursiveRes);


//        ArrayList<ArrayList<Integer>> results = getSubsetOfPowerSet(set);
//        System.out.println("Results: " + results);
    }

    private static ArrayList<ArrayList<Integer>> getSubsetOfPowerSetRecursively(int[] set) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(set.length == 0){
            results.add(new ArrayList<>());
            return results;
        }
        return getSubsets(set, 0);
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(int[] set, int index) {
        ArrayList<ArrayList<Integer>> results;
        if(set.length == index){
            results = new ArrayList<>();
            results.add(new ArrayList<>());
        }else {
            results = getSubsets(set, index + 1);
            int num = set[index];
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset: results){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.addAll(subset);
                temp.add(num);
                moreSubsets.add(temp);
            }
            results.addAll(moreSubsets);
        }
        return results;
    }

    private static ArrayList<ArrayList<Integer>> getSubsetOfPowerSet(int[] set) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(set.length == 0){
            res.add(new ArrayList<>());
            return res;
        }
        for(int i = 0; i < set.length; i++){

            if(res.size() == 0){
                ArrayList<Integer> al = new ArrayList<>();
                res.add(new ArrayList<>());
                al.add(set[i]);
                res.add(al);
                System.out.println("Res 0: " + res);
            }else{
                addListToRes(set[i], res);
            }
            System.out.println("Res: "+i+" "+ res);
        }

        return res;
    }

    private static void addListToRes(int num, ArrayList<ArrayList<Integer>> res) {
        ArrayList<ArrayList<Integer>> moreSubSets =  new ArrayList<>();
        for(ArrayList<Integer> subsets : res){
            ArrayList<Integer> sub = new ArrayList<>();
            sub.addAll(subsets);
            sub.add(num);
            moreSubSets.add(sub);
        }
        res.addAll(moreSubSets);
    }
}
