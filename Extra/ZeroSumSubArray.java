package Extra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubArray {
    public static void main(String args[]) {
        int[] arr = {1, 2, -5, 1, 2, -1};

        int[] zeroSubArray = getZeroSubArray(arr);
//        for (int num: zeroSubArray){
//            System.out.println(num);
//        }
        Arrays.stream(zeroSubArray).forEach(System.out::println);
    }

    private static int[] getZeroSubArray(int[] arr) {
        if (arr.length == 0) return arr;

        Map<Integer, Integer> sums = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            Integer oldIndex = sums.get(sum);
            if(oldIndex == null){
                sums.put(sum, i);
                sum += arr[i];
            }else{
                return Arrays.copyOfRange(arr, oldIndex, i);
            }
        }
        return null;
    }
}
