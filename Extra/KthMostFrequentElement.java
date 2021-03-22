package Extra;

import java.util.*;

public class KthMostFrequentElement {
    public static void main(String args[]) {
        int[] input = {1, 2};              //{1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = findKthMostFrequentElement(input, k);
        Arrays.stream(result).forEach(value -> System.out.print(value + " "));
    }

    private static int[] findKthMostFrequentElement(int[] input, int k) {
        if(input.length == 0) return new int[0];

        Map<Integer, Integer> frequencyFinder = new HashMap<>();
        for(int num : input){
            frequencyFinder.put(num,frequencyFinder.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> kValues = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer key1, Integer key2) {
                if(frequencyFinder.get(key1) > frequencyFinder.get(key2)) return 1;
                if(frequencyFinder.get(key1) < frequencyFinder.get(key2)) return -1;
                return 0;
            }
        });

        for(int key : frequencyFinder.keySet()) {
            if(kValues.size() >= k){
                if(frequencyFinder.get(kValues.peek()) < frequencyFinder.get(key)){
                    kValues.poll();
                    kValues.add(key);
                }
            }else {
                kValues.add(key);
            }
        }

        System.out.println("Result: " +kValues);


//            for(int key : frequencyFinder.keySet()){
//            if(frequencyFinder.get(key) >= k){
//                kthMostFreq.add(key);
//            }
//        }

        int[] res = new int[kValues.size()];        //kthMostFreq.stream().mapToInt(i -> i).toArray();
        for(int index = 0; index < res.length; index++){
            res[index] = kValues.remove();
        }

        return res;
    }


}
