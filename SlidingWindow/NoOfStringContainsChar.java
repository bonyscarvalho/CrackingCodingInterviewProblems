package LeetCodeMedium.SlidingWindow.SumOfSubArray;

//1358. Number of Substrings Containing All Three Characters
public class NoOfStringContainsChar {
    public static void main(String args[]) {
       // System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstringsAnother("abcabc"));
    }

    private static int numberOfSubstringsAnother(String s) {
        if(s.length() == 0)return 0;

        int[] count = {-1, -1, -1};    //a, b, c ==> use to count the min occurrence of all 3 chars in current substring
        int start = 0;
        int result = 0;
//        abcabc
        for(int end = 0; end < s.length(); end++){
            count[s.charAt(end) - 'a'] = end;   //updating with the last index for occurences
            // we keep the initial value as -1 as when trying to find the max occurrence for the initial 2 values it will be 0 and at the 3rd value it will be updated
            // -1 can aslo help in returning the result as zero if any occurence of char is not found
            result += (1 + Math.min(count[0], Math.min(count[1], count[2])));   //as min will have the exact count of number of occurrences of all 3 chars
        }

        return result;
    }

    //Prefix SUm Approach
    //1. Adding the currSUm
    //2. chechking if current sum exceeded
    //3. removing from start
    public static int numberOfSubstrings(String s) {
        if(s.length() == 0)return 0;

        int[] count = {0, 0, 0};    //a, b, c ==> use to count the min occurrence of all 3 chars in current substring
        int start = 0;
        int result = 0;

        for (int end = 0; end < s.length(); end++){
            count[s.charAt(end) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0){
                count[s.charAt(start) - 'a']--;
                start++;
            }

            result += start;    // as we want the AT LEAST number of occurrences we add the till now found to the result
            // like for every incremented start pointer

        }

        return result;
    }

}
