package FacebookQuestions;

import java.util.*;

public class MinimizingPermutationsBFS {
    public static void main(String[] args) {
        int n_1 = 5;
        int[] arr_1 = {1, 2, 5, 4, 3};
        int expected_1 = 1;
        System.out.println(minOperations(arr_1));

        int n_2 = 3;
        int[] arr_2 = {3, 1, 2};
        int expected_2 = 2;
        System.out.println(minOperations(arr_2));
    }

    public static class Item{
        int[] arr;
        int permC;
        public Item(int[] arr, int permC){
            this.arr = arr;
            this.permC = permC;
        }
    }
    private static int minOperations(int[] arr) {
        //Very simple solution: you reverse the arr 1 at a time and check if it is sorted
        //and then you add it to queue for next call
        // basically like: visiting every num and reversing and checking if sorted (like 1st level of tree) then adding them for next level
        if(arr.length == 0 || isSorted(arr))return 0;

        Set<String> visited = new HashSet<>();
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(arr, 0));

        while (!queue.isEmpty()){
            Item currItem = queue.poll();
            int[] currArr = currItem.arr;

            if(visited.contains(Arrays.toString(currArr))){
                continue;
            }
            visited.add(Arrays.toString(currArr));

            for(int i = 0; i < currArr.length; i++){
                for (int j = i + 1; j < currArr.length; j++){
                    int[] reversedArr = reverseArr(Arrays.copyOf(currArr, currArr.length), i, j);
                    if(isSorted(reversedArr)){
                        return currItem.permC + 1;
                    }
                    queue.add(new Item(reversedArr, currItem.permC + 1));
                }
            }
        }

        return -1;  //Invalid Case
    }

    private static int[] reverseArr(int[] copyArr, int start, int end) {
        for(int idx = 0; idx <= (end - start)/2; idx++){
            //we do start +  and end-  as we are starting from 0 and we need to only reverse from start to end
            int temp  = copyArr[start + idx];
            copyArr[start + idx] = copyArr[end - idx];
            copyArr[end - idx] = temp;
        }
        return copyArr;
    }

    private static boolean isSorted(int[] arr) {
        for(int idx = 0; idx < arr.length; idx++){
            if(arr[idx] != idx + 1){
                return false;
            }
        }
        return true;
    }
}
