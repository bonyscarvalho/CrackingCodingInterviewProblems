package ChapterSortingAndSearching;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args)
    {
        int[] arr = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};
        computeCoutingSort(arr);
    }

    private static void computeCoutingSort(int[] arr) {
        int n = arr.length;
        if(n == 0) return;

        int max = 9;        //Can use collection to find max;
        int[] coutingCount = new int[max+1];

        for(int i = 0; i < n; i++){
            coutingCount[arr[i]]++;
        }

        for(int i = 1; i < coutingCount.length; i++){
            coutingCount[i] += coutingCount[i-1];
        }
        Arrays.stream(coutingCount).forEach(num -> System.out.print(num+" "));
        System.out.println();

        int[] output = new int[n];
        for(int i = n-1; i >= 0; i--){
            output[--coutingCount[arr[i]]] = arr[i];
        }
        System.out.println("Sorted Array: ");
        Arrays.stream(output).forEach(num -> System.out.print(num+" "));
    }
}
