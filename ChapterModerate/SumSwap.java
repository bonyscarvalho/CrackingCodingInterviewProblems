package ChapterModerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SumSwap {
    public static void main(String[] args) {
        int[] arr1 = {4, 1, 2, 1, 1, 2};
        int[] arr2 = {3, 6, 4, 3};

        ArrayList<Integer> swapNum = computeArraySwapForEqualSum(arr1, arr2);
        System.out.println(swapNum);

        ArrayList<Integer> approach2 = computeSumSwapByHashSet(arr1, arr2);
        System.out.println(approach2);
    }

    private static ArrayList<Integer> computeSumSwapByHashSet(int[] arr1, int[] arr2) {
        Integer target = getTarget(arr1, arr2);
        if(target == null) return null;

        return findDifference(arr1, arr2, target);
    }

    private static ArrayList<Integer> findDifference(int[] arr1, int[] arr2, Integer target) {
        HashSet<Integer> contentsArr2 = getContents(arr2);
        ArrayList<Integer> result = new ArrayList<>();
        for(int num1 : arr1){
            int num2 = target - num1;
            if(contentsArr2.contains(num2)){
                result.add(num1);
                result.add(num2);
                return result;
            }
        }
        return null;
    }

    private static HashSet<Integer> getContents(int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr2){
            set.add(num);
        }
        return set;
    }

    private static Integer getTarget(int[] arr1, int[] arr2) {
        int sumArr1 = sumArr(arr1);
        int sumArr2 = sumArr(arr2);
        int targetDiff = Math.abs(sumArr1 - sumArr2);

        if(sumArr1 == sumArr2) return null;

        return targetDiff;
    }

    private static ArrayList<Integer> computeArraySwapForEqualSum(int[] arr1, int[] arr2) {
        if(arr1.length == 0 || arr2.length == 0) return null;

        ArrayList<Integer> results = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int sumArr1 = sumArr(arr1);
        int sumArr2 = sumArr(arr2);
        System.out.println(sumArr1 +" " + sumArr2);

        if(sumArr1 == sumArr2) return null;

        int[] largeArr = sumArr1 > sumArr2 ? arr1 : arr2;
        int[] smallArr = sumArr1 > sumArr2 ? arr2 : arr1;
        int targetDiff = Math.abs(sumArr1 - sumArr2);

        int idxLarge = largeArr.length - 1, idxSmall = 0;

        while (idxLarge < largeArr.length && idxSmall < smallArr.length){
            int sum = smallArr[idxSmall] + largeArr[idxLarge];

            if(sum == targetDiff){
                results.add(smallArr[idxSmall]);
                results.add(largeArr[idxLarge]);
                return results;
            } else if(sum > targetDiff){
                idxLarge--;
            }else {
                idxSmall++;
            }
        }
        return null;
    }

    private static int sumArr(int[] arr1) {
        int sumArr1 = 0;
        for (int num : arr1){
            sumArr1 += num;
        }

        return sumArr1;
    }
}
