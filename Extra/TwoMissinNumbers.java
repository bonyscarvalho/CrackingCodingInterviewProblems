package Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoMissinNumbers {
    public static void main(String args[]) {
        int[] arr = {1, 3, 4, 6};

        Integer[] missingNumbers = sortApproach(arr);
        System.out.println("Missing Numbers are: " + missingNumbers);
    }

    private static Integer[] sortApproach(int[] arr){
        int len = arr.length;
        if(len <= 1) return new Integer[2];

        Arrays.sort(arr);

        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < arr.length - 1; i++){
            if(arr[i + 1] != (arr[i] + 1)){
                res.add(arr[i] + 1);
            }
        }
        System.out.println("Print List: " +res);

        Integer[] resArray = res.toArray(new Integer[res.size()]);

//        Integer[] testArray = new Integer[2];
//        testArray = res.toArray(testArray);

        //Object[] objArray = res.toArray();

        for(Object i : resArray){
            System.out.println("Res Array "+ i);
        }

        return resArray;
    }

    private static int[] findTwoMissingNumbers(int[] arr) {
        int len = arr.length;
        if(len <= 1) return new int[2];

        long arrSum = 0;
        int totalActualSize = len + 2;
        long totalActualSUM = ((long) totalActualSize * (totalActualSize + 1)) / 2;

        System.out.println("Total Arr Sum: " + totalActualSUM);

        for(int i : arr){
            arrSum += i;
        }

        int pivot = (int) (totalActualSUM - arrSum) / 2;
        System.out.println("Pivot: " + pivot);

        int lefttotalXOR = 0;
        int righttotalXOR  = 0;
        int leftArrXOR = 0;
        int rightArrXOR = 0;

        for (int i = 1; i <= pivot; i++){
            lefttotalXOR ^= (i);
        }
        for (int i = pivot + 1; i <= totalActualSize; i++){
            righttotalXOR ^= (i);
        }

        for (int i : arr){
            if(i <= pivot){
                leftArrXOR ^= (i);
            }else {
                rightArrXOR ^= (i);
            }
        }

        System.out.println("Left and Right: " + (lefttotalXOR ^ leftArrXOR) +" "+ (rightArrXOR ^ righttotalXOR));

        return new int[]{(lefttotalXOR ^ leftArrXOR), (rightArrXOR ^ righttotalXOR)};
    }
}
