package FacebookQuestions;

import java.util.HashMap;
import java.util.Map;

public class MinimumLengthSubstrings {
    public static void main(String[] args){
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        System.out.println(minLengthSubstring(s_1, t_1));

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        System.out.println(minLengthSubstring(s_2, t_2));
    }

    public static int minLengthSubstring(String s, String t) {
        // Write your code here
        if(s.length() < t.length()) return -1;

        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> tMap = new HashMap<>();
        for(char tChar : t.toCharArray()){
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }
        int requiredSize = tMap.size();

        Map<Character, Integer> sMap = new HashMap<>();
        int start = 0, end = 0;

        while (end < s.length()){
            char curr = s.charAt(end);

            sMap.put(curr, sMap.getOrDefault(curr, 0) + 1);

            if(tMap.containsKey(curr) && tMap.get(curr).equals(sMap.get(curr))){
                requiredSize--;
            }

            while (start <= end && requiredSize == 0){
                char startChar = s.charAt(start);
                minLen = Math.min(minLen, end - start + 1);

                if(tMap.containsKey(startChar)){
                    sMap.put(startChar, sMap.get(startChar) - 1);
                    requiredSize++;
                }
                start++;
            }

            end++;
        }



        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
