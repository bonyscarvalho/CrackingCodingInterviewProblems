package LeetCodeMedium.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//424. Longest Repeating Character Replacement
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s1 = "ABAB"; int k1 = 2;
        String s2 = "AABABBA"; int k2 = 1;
        System.out.println(characterReplacement(s1, k1));
        System.out.println(characterReplacement(s2, k2));
    }

    public static int characterReplacement(String s, int k) {
        if(s.length() == 0) return 0;

        Map<Character, Integer> charCounts = new HashMap<>();
        int[] charArrCounts = new int[26];
        int startIdx = 0, endIdx = 0;
        int maxCurrCharsCount = 0;
        int maxWindowLen = 0;

        while (endIdx < s.length()){
            char curr = s.charAt(endIdx);

            charCounts.put(curr, charCounts.getOrDefault(curr, 0) + 1);
            charArrCounts[curr - 'A']++;
            //maxCurrCharsCount = Math.max(maxCurrCharsCount, charCounts.get(curr));
            maxCurrCharsCount = Math.max(maxCurrCharsCount, charArrCounts[curr - 'A']);

            while (endIdx - startIdx + 1 - maxCurrCharsCount > k){  // shrink Time
                char charAtStart = s.charAt(startIdx);
                //int charAtStartCount = charCounts.get(charAtStart);
                //charCounts.put(charAtStart, charAtStartCount - 1);
                charArrCounts[charAtStart - 'A']--;
                startIdx++;
            }

            maxWindowLen = Math.max(maxWindowLen, endIdx - startIdx + 1);

            endIdx++;
        }

        return maxWindowLen;
    }
}
