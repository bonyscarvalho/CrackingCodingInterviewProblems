package LeetCodeMedium.SlidingWindow;

import java.util.*;

//438. Find All Anagrams in a String
public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s =    "abab", p = "ab";              //"cbaebabacd", p = "abc";
        //"abab"
        //"ab"
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagramsArrApp(String s, String p) {
        if(s.length() < p.length()) return null;
        int pLen = p.length();
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];
        List<Integer> anagramsList = new ArrayList<>();

        for(char ch : p.toCharArray()){
            pFreq[ch - 'a']++;
        }

        for(int idx = 0; idx < s.length(); idx++){
            char currChar = s.charAt(idx);
            sFreq[currChar - 'a']++;

            if(idx >= pLen){
                sFreq[s.charAt(idx - pLen) - 'a']--;
            }

            if(Arrays.equals(sFreq, pFreq)){
                anagramsList.add(idx - pLen + 1);
            }
        }

        return anagramsList;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length())
            return result;

        int[] targetCharactersFreq = new int[128];  //can be 26 too for lower case only
        int remainingCharsCount = p.length();   //Counter to keep track of p's string
        int startIdx = 0;   //windows left ptr
        int endIdx = 0;

        for(char currChar : p.toCharArray()){
            targetCharactersFreq[currChar - 'a']++;
        }

        while(endIdx < s.length()){
            char currChar = s.charAt(endIdx);

            if(targetCharactersFreq[currChar - 'a'] >= 1){
                remainingCharsCount--;
            }
            targetCharactersFreq[currChar - 'a']--;

            if(remainingCharsCount == 0){
                result.add(startIdx);
            }

            int windowLen = endIdx - startIdx + 1;

            //Shrink
            if(windowLen == p.length()){
                char startCHar = s.charAt(startIdx);
                if(targetCharactersFreq[startCHar - 'a'] >= 0){
                    remainingCharsCount++;
                }

                targetCharactersFreq[startCHar - 'a']++;
                startIdx++;
            }
            endIdx++;
        }

        return result;
    }
}
