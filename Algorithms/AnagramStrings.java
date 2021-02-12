package Algorithms;

import java.util.*;

public class AnagramStrings {
    public static void main(String args[])
    {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<ArrayList<String>> results = getAnagramListsOfStrings(strs);
        System.out.println("Results: " + results);
    }

    private static List<ArrayList<String>> getAnagramListsOfStrings(String[] strs) {
        List<ArrayList<String>> res = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();

        if(strs.length == 0) return res;
        if(strs.length == 1){
            res.add(new ArrayList<String>(Collections.singleton(strs[0])));
            return res;
        }
        for(String str : strs){
            char[] firstArray = str.toCharArray();
            Arrays.sort(firstArray);

            String key = Arrays.toString(firstArray);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }

        }
        System.out.println("Map Length " + map.size());
        for(String key : map.keySet()){
            ArrayList<String> temp = map.get(key);
            res.add(temp);
        }
//        System.out.println("Result: " + res);
        return res;

    }

    private static boolean isAnagrams(String fir, String sec) {
        if(fir.length() != sec.length()) return false;

        int i = 0;
        while(i < fir.length()){
            if(fir.charAt(i) != sec.charAt(i)){
                return false;
            }
            i++;
        }
        return true;
    }
}
