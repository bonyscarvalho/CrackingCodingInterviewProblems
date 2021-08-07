package FacebookQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchingPairs {
    public static void main(String[] args) {
        String s1 = "abcd", t1 = "adcb";
        String s2 = "mno", t2 = "mno";
        String s3 = "abcde", t3 = "adcbe";
        String s4 = "abcd", t4= "abcd";
        String s5 = "abcd", t5 = "efgh";
        String s6 = "abcd", t6 = "abce";
        String s7 = "abczz", t7 = "abcee";

        System.out.println(matchingPairs(s1, t1));
        System.out.println(matchingPairs(s2, t2));
        System.out.println(matchingPairs(s3, t3));
        System.out.println(matchingPairs(s4, t4));
        System.out.println(matchingPairs(s5, t5));
        System.out.println(matchingPairs(s6, t6));
        System.out.println(matchingPairs(s7, t7));
    }

    public static int matchingPairs(String s, String t) {
        // Write your code here
        if(s.length() != t.length()) return 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int res = 0;
        boolean hasDuplicates = false;  //Edge Case where if it has Dups then you can just to inner swap and you will get same result
        Set<Character> dupsCheckSet = new HashSet<>();

        for(int idx = 0; idx < s.length(); idx++){
            if(s.charAt(idx) != t.charAt(idx)){
                sb1.append(s.charAt(idx));
                sb2.append(t.charAt(idx));
            }else {
                if(!dupsCheckSet.add(s.charAt(idx))){
                    hasDuplicates = true;
                }
                res++;
            }
        }

        //if both string are same then you don't have to calculate
        if(sb1.length() == 0){
            if(hasDuplicates){
                return res;
            }
            return res - 2;
        }

        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();
        for (int idx = 0; idx < sb1.length(); idx++){   //"bd","db";
            //if mapS contains chars from sb2 then if we swap them with each other it will be a matching pair
            if(mapS.containsKey(sb2.charAt(idx))){
                res++;
            }
            //if both Chars are reverse of each other then we can switch and add 1 to it
            if(mapS.getOrDefault(sb2.charAt(idx), -1) == mapT.getOrDefault(sb1.charAt(idx), -2)){
                return res + 1;
            }
            mapS.put(sb1.charAt(idx), idx);
            mapT.put(sb2.charAt(idx), idx);
        }


        return res + ((sb1.length() == 1) ? -1 : 0);
    }
}
