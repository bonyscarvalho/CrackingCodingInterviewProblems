package ChapterArraysAndStrings;

import java.util.Arrays;

public class OneStringPermutationOfAnother {
    public static void main(String args[]) {

        String first = "abcdef";
        String second = "fdecbf";

        System.out.println("String Permutation Value is "+ isPermutationStringsMethod2(first,second));
    }
    //Sort and Compare Time: O(nlog(n)) as both string are of same length Space O(n)
    private static Boolean isPermutationStringsMethod1(String first, String second) {
        if(first.length() != second.length()) return false;

        char[] firstString = first.toCharArray();
        char[] secondString = second.toCharArray();
        Arrays.sort(firstString);
        Arrays.sort(secondString);

        for(int i = 0; i < firstString.length; i++){
            if(firstString[i] != secondString[i]){
                return false;
            }
        }
        return true;
    }
// going through the arrays of both strings and incrementing first string and decrementing 2nd. Time: O(n) Space O(1). MATTERS
    private static Boolean isPermutationStringsMethod2(String first, String second) {
        if(first.length() != second.length()) return false;

        int [] lettersCount = new int[26];

        for(int i = 0; i < first.length(); i++){
            lettersCount[first.charAt(i) - 'a']++;
        }
        for(int i = 0; i < second.length(); i++){
            lettersCount[second.charAt(i) - 'a']--;
        }

        for (int i = 0; i < lettersCount.length; i++){
            if(lettersCount[i] > 0){
                return false;
            }
        }
        return true;
    }

}
