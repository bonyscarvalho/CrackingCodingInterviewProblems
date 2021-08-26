package LeetCodeMedium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//451. Sort Characters By Frequency
public class SortCharactersByFrequencyBucketSortVIP {
    public static void main(String[] args) {
       String s1 = "tree", s2 = "Aabb";
       System.out.println(frequencySort(s1));
        System.out.println(frequencySort(s2));
    }

    public static String frequencySort(String s) {
        if(s.length() == 0) return "";

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char curr : s.toCharArray()){
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
        }

        int maxFreq = Collections.max(freqMap.values());

        List<List<Character>> buckets = new ArrayList<>();
        for(int idx  = 0; idx <= maxFreq; idx++){
            buckets.add(new ArrayList<>());
        }

        for(char curr : freqMap.keySet()){
            int currFreq = freqMap.get(curr);
            buckets.get(currFreq).add(curr);
        }

        StringBuilder result = new StringBuilder();

        for(int idx = buckets.size() - 1; idx >= 0; idx--){
            List<Character> curr = buckets.get(idx);
            for(Character ch : curr){
                for(int i = 0; i < idx; i++){
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
