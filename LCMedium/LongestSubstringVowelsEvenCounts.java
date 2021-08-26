package LeetCodeMedium;

import java.util.Arrays;

//1371. Find the Longest Substring Containing Vowels in Even Counts
public class LongestSubstringVowelsEvenCounts {
    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        System.out.println(findTheLongestSubstring(s));
    }

    public static int findTheLongestSubstring(String s) {
        if(s.length() == 0)return 0;

        int maxLen = 0;
        int[] vowelsNum = {1,0,0,0,2,0,0,0,4,0,0,0,0,0,8,0,0,0,0,0,16,0,0,0,0,0};   //a,e,i,o,u mapping
        int mask = 0;
        int[] prevMask = new int[32];
        Arrays.fill(prevMask, -1);

        for(int idx = 0; idx < s.length(); idx++){
            //calculating the mask for vowels
            mask ^= vowelsNum[s.charAt(idx) - 'a'];

            //seeing the value for the 1st time or mask-> 0 means the count is of vowels is even and matched
            if(prevMask[mask] == -1 && mask != 0){
                prevMask[mask] = idx;
            }

            maxLen = Math.max(maxLen, idx - prevMask[mask]);
        }


        return maxLen;
    }
}
