package FacebookQuestions;

import java.util.HashMap;
import java.util.Map;

//1460. Make Two Arrays Equal by Reversing Sub-arrays
public class ReverseToMakeEqual {
    public static void main(String args[]) {
        int[] target = {1,2,3,4}, arr = {2,4,1,3};
        System.out.println(canBeEqual(target, arr));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length) return false;

        Map<Integer, Integer> freqCount = new HashMap<>();
        for(int num : arr){
            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
        }
        for (int num : target){
            if(!freqCount.containsKey(num)){
                return false;
            }else {
                int count = freqCount.get(num);
                if(count == 1){
                    freqCount.remove(num);
                }else {
                    freqCount.put(num, count - 1);
                }
            }
        }

        return freqCount.size() == 0;
    }
}
