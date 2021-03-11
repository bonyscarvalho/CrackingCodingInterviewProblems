package ChapterSortingAndSearching;

import java.util.*;

public class GroupAnagrams {
    public static void main(String args[])
    {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        ArrayList<String> result = new ArrayList<>();
        groupAnagramOfStrings(strs, result);
        System.out.println("Results: " + result);
    }

    private static void groupAnagramOfStrings(String[] strs, ArrayList<String> result) {
        if(strs.length == 0) return;

        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs){
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = String.copyValueOf(strArr);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }
        }

        for (String key : map.keySet()){
            result.addAll(map.get(key));
        }
    }
}
