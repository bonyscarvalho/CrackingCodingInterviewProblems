package Extra;

import java.util.*;

public class KthMostFreqWord {
    public static void main(String args[]) {
        String[] input =  {"i", "love", "leetcode", "i", "love", "coding"}; //{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};         //              //{1, 1, 1, 2, 2, 3};
        int k = 2;
        ArrayList<String> result = findKthMostFrequentWord(input, k);

    }

    private static ArrayList<String> findKthMostFrequentWord(String[] input, int k) {
        if(input.length == 0) return new ArrayList<>();

        Map<String, Integer> frequencyFinder = new HashMap<>();
        for(String str : input){
            frequencyFinder.put(str,frequencyFinder.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<String> kValues = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
//                return (frequencyFinder.get(key1).equals(frequencyFinder.get(key2)))
//                        ? key2.compareTo(key1)
//                        : (frequencyFinder.get(key1) - frequencyFinder.get(key2));

                if(frequencyFinder.get(key1) > frequencyFinder.get(key2)){
                    return 1;
                }
                if(frequencyFinder.get(key1) < frequencyFinder.get(key2)){
                    return -1;
                }
                System.out.println("KEY1: " +key1);
                System.out.println("KEY2: " +key2);
                System.out.println("Result: " + key2.compareTo(key1));
                // as we want the lexo sorted values, we will compare the highest value at the top which will be love.
                // love will be the root and i will be bottom and it will be removed.
                //As if K value is 1 then there should arranged lexographically(alphabatical)
                // which means when both freq are same you need it to be max value at top and min as leaf(alphabatical)
                return  key1.compareTo(key2);
            }
        });

        for(String str : frequencyFinder.keySet()){
            System.out.println("STR: " +str);
            kValues.add(str);
            if(kValues.size() > k) {
                kValues.poll();
            }
        }
        //System.out.println("Result: " + kValues);

        ArrayList<String> result = new ArrayList<>();
        while (!kValues.isEmpty()){
            result.add(kValues.remove());
        }
        System.out.println("Before Reverse: " +result);
        Collections.reverse(result);
        System.out.println("RESULT: " +result);
        return result;

    }
}
