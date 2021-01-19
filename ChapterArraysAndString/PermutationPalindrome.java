package ChapterArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class PermutationPalindrome {
    public static void main(String args[]){
        String input = "Jerry";
        System.out.println("The Result of String being Palindrome Permutation is " + isPalindromePermutationApproac2(input));
    }
    //this approach is same as previous only using array which is quite faster then map.
    private static Boolean isPalindromePermutationApproac2(String input) {
        if(input.length() == 0) return true;
        int oddCount = 0;
        System.out.println("Charcter count " + (Character.getNumericValue('z') - Character.getNumericValue('a') + 1));
        int[] charTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(char c : input.toCharArray()){
            int charVal = getNumericValueForChar(c);

            if(charVal != -1){
                charTable[charVal]++;
                if(charTable[charVal] % 2 == 1){
                    oddCount++;
                }else {
                    oddCount--;
                }
            }
        }
        return oddCount <= 1;
    }

    private static int getNumericValueForChar(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int charVal = Character.getNumericValue(c);
        if(a <= charVal && charVal <= z){
            return charVal - a;
        }
        return -1;
    }

    //Map and get to check
    private static Boolean isPalindromePermutationApproac1(String input) {
        String updated = input.toLowerCase().replaceAll("\\s", "");
        System.out.println("Updated String "+ updated);
        if(input.length() == 0) return true;
        Map<Character, Integer> charCount = new HashMap<>();

        for(char c : updated.toCharArray()){
            if(charCount.containsKey(c)){
                if(charCount.get(c) == 1){
                    charCount.remove(c);
                }else{
                    charCount.put(c, charCount.get(c) - 1);
                }
            }else {
                charCount.put(c, 1);
            }
        }
        int size = charCount.size();
        System.out.println("Size " + size);
        return size == 1 || size == 0;
    }
}
