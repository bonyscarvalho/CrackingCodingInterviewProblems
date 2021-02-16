package Extra;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
    public static void main(String args[]) {
        int[] arr= {1,2,2,1};
        int[] dupsArr = findDuplicates(arr);
        System.out.println("Dups: " + dupsArr);

    }
    
    //Brute Force: O(n*n)
    //Sort and Find: O(n*logn)
    //HashSet: Space and Time: O(n)

    private static int[] findDuplicates(int[] arr) {
        if(arr.length <= 1) return arr;

        Set<Integer> uniqueList = new HashSet<>();

        for (int i = 0; i < arr.length; i++){
            int index = arr[i] - 1;
            if(arr[index] < 0){
                uniqueList.add(Math.abs(arr[i]));
            }else {
                arr[index] = - arr[index];
            }
        }
        //Integer[] result = (Integer[]) uniqueList.toArray();
        System.out.println("Set: " +uniqueList);

        int[] test = uniqueList.stream().mapToInt(i -> i).toArray();
        return test;
    }
}
