package ChapterArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class PermutationPalindrome {
    public static void main(String args[]){
        String input = "Tact Coa";
        System.out.println("The Result of String being Palindrome Permutation is " + isPalindromePermutationApproac3(input));
    }

    private static Boolean isPalindromePermutationApproac3(String input) {
        if(input.length() == 0) return true;
        int bitVector = createBitVector(input);

        return (bitVector == 0) || checkExactlyOneBitRemaining(bitVector);
    }

    private static int createBitVector(String input) {
        int bitValue = 0;
        for(char ch : input.toCharArray()){
            int chIndex = getNumericValueForChar(ch);
            bitValue = bitVectorCal(chIndex, bitValue);
        }
        return bitValue;
    }

    private static int bitVectorCal(int chIndex, int bitValue) {
        if(chIndex < 0) return  bitValue;

        int mask = 1 << chIndex;    //create mask for char value

        if((bitValue & mask) == 0){     //char is new and not equal to any previous
            bitValue |= mask;       
        }else{                          //char is already there
            bitValue &= (~mask);        // minus the older char from here and get back the org value
        }                               //aba will return value of b back from here.
        return bitValue;
    }
    
    //it will be zero. as if you have 2 bits (110 - 1 = 101) & 110 the value will be greater then zero 
    // but if you just have 1 bit (100 - 1 = 011 & 100 it will be zero as only 1 bit)
    private static boolean checkExactlyOneBitRemaining(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
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
