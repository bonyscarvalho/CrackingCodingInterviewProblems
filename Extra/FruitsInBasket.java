package Extra;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {
    public static void main(String[] args) {
        int [] arr = {1,0,1,4,1,4,1,2,3};
        int mergedSortedArr = totalFruitsInBaskets(arr);

    }

    private static int totalFruitsInBaskets(int[] tree) {
        if(tree.length == 0)return 0;

        HashMap<Integer, Integer> map = new HashMap<>(); //[1,0,1,4,1,4,1,2,3]        //3,3,3,1,2,1,1,2,3,3,4
        int maxFruit = 0;
        int i = 0, lowestIdx = 0;

        while(i < tree.length){
            map.put(tree[i], i++);

            if(map.size() > 2){
                int minValue = Collections.min(map.values());
//                int minValue = tree.length - 1;
//                for(int n: map.values()){
//                    minValue = Math.min(minValue, n);
//                }
                System.out.println("Lowest Index: " + tree[lowestIdx] +" "+lowestIdx);
                map.remove(tree[minValue]);
                lowestIdx = minValue + 1;

            }

            maxFruit = Math.max(maxFruit, (i - lowestIdx));
        }
        System.out.println("Max: " + maxFruit);
        return maxFruit;

    }
}
