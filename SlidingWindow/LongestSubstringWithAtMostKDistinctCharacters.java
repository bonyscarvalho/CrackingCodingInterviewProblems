package LeetCodeMedium.SlidingWindow.SumOfSubArray;

import java.util.HashMap;
import java.util.Map;

//340. Longest Substring with At Most K Distinct Characters
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String args[]) {
        String s = "eceba"; int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0) return -1;

        int startWindow = 0, maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> freqCounts = new HashMap<>();

        for(int endWindow = 0; endWindow < s.length(); endWindow++){
            char curr = s.charAt(endWindow);
            freqCounts.put(curr, freqCounts.getOrDefault(curr, 0) + 1);
            //eceba
            while (freqCounts.size() > k) {
                char startChar = s.charAt(startWindow);
                int count = freqCounts.get(startChar) - 1;
                if (count == 0) {
                    freqCounts.remove(startChar);
                } else {
                    freqCounts.put(startChar, count);
                }
                startWindow++;
            }

            maxLen = Math.max(maxLen, endWindow - startWindow + 1);
        }

        return maxLen;
    }
}
