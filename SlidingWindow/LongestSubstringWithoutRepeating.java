package LeetCodeMedium.SlidingWindow.SumOfSubArray;

import java.util.HashMap;
import java.util.Map;

//3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeating {
    public static void main(String args[]) {

        String str = "abcacbdbbedghi";
        System.out.println(lengthOfLongestSubstring("abcacbdbbedghi")); //this the answer should be 2 so currLen should be appened by  +1 for index of len
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)return s.length();

        int start = 0;
        int maxLen = 0;
        Map<Character, Integer> charIdxMap = new HashMap<>();

        for(int end  = 0; end < s.length(); end++){
            char currChar = s.charAt(end);

            if(charIdxMap.containsKey(currChar)){
                start = Math.max(start, charIdxMap.get(currChar));  //so that you are getting the greater index and won't consider the mismatch of chars in it.
            }
            int currLen = end - start + 1;

            maxLen = Math.max(currLen, maxLen);
            charIdxMap.put(currChar, end + 1);
        }

        return maxLen;
    }
}
