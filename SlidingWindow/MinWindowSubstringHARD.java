package LeetCodeMedium.SlidingWindow.SumOfSubArray;

import java.util.HashMap;
import java.util.Map;
//76. Minimum Window Substring
//Sliding Window with Presum Approach
public class MinWindowSubstringHARD {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        String minWindow = minWindow(s, t);
        System.out.println(minWindow);
    }

    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        //Used for Comparing the Length from LeftPtr to RightPtr for getting the min length
        //0--> Len 1--> left 2-->Right
        Integer[] ans = new Integer[] {-1, 0, 0};

        Map<Character, Integer> dictT = new HashMap<>();
        for(char ch : t.toCharArray()){
            dictT.put(ch, dictT.getOrDefault(ch, 0) + 1);
        }

        int required = dictT.size();
        int formed = 0;

        int slowPtr = 0;
        Map<Character, Integer> windowS = new HashMap<>();
        int fastPtr = 0;

        while(fastPtr < s.length()){
            char currChar = s.charAt(fastPtr);
            //you put all the characters of the String into the Map and compare the freq of it with the given one, as it is said it will have duplicates
            windowS.put(currChar, windowS.getOrDefault(currChar, 0) + 1);

            //Once the freq matched the size of t Map it is said that the String contains all the values of t
            if(dictT.containsKey(currChar) && dictT.get(currChar).intValue() == windowS.get(currChar).intValue()){
                formed++;
            }

            //you compare as long as formed is same as required from left to right
            while(slowPtr <= fastPtr && formed == required){
                char first = s.charAt(slowPtr);
                //Checking if the size of current window is lesser then previous
                if(ans[0] == -1 || ((fastPtr - slowPtr + 1) < ans[0])){
                    ans[0] = fastPtr - slowPtr + 1;
                    ans[1] = slowPtr;
                    ans[2] = fastPtr;
                }

                //int count = windowS.get(first) - 1;
                windowS.put(first, windowS.get(first) - 1);
                //Checking if char from the leftPtr is not the char of the finding string
                //We give intValue as the string can be very big so we want the max value
                if(dictT.containsKey(first) && dictT.get(first).intValue() > windowS.get(first).intValue()){
                    formed--;
                }

                slowPtr++;
            }

            fastPtr++;

        }


        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
