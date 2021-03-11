package ChapterSortingAndSearching;

import java.util.Arrays;

public class SortedMerge {
    public static void main(String args[])
    {
        int[] arrA = {0, 4, 6, 8, 0, 0, 0, 0};
        int[] arrB = {2, 5, 9, 10};

        computeInOneArray(arrA, arrB);
        Arrays.stream(arrA).forEach(value -> System.out.print(value + " "));
    }

    private static void computeInOneArray(int[] arrA, int[] arrB) {
        if(arrB.length == 0) return;
        if(arrA.length == 0) return;



        int idx = arrA.length - 1;
        int orgA = arrA.length - 1;
        while (arrA[orgA] == 0){
            orgA--;
        }

        int idxB = arrB.length - 1;


        while (idxB >= 0){
            if(arrA[orgA] > arrB[idxB]){
                arrA[idx] = arrA[orgA];
                orgA--;
            }else {
                arrA[idx] = arrB[idxB];
                idxB--;
            }
            idx--;
        }
    }
}
