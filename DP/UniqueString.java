package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//1239. Maximum Length of a Concatenated String with Unique Characters
public class UniqueString {
    static int maxLength = 0;
    public static void main(String args[]) {
        String[] input =  {"cha","r","act","ers"};               //{"svrtygzibohnmax","eirfzohcgpkvdtj","kdnzag","jkwhuog","zgncwjosldfbuqamk","zapkcjhruesvm","u","awgevczxhfl","pecbukqfga","ptlqc","plsjghnxrdzvwciumfy","pouxdke","dhxniqlujcm","nagihydkmebtwjru","rsghkl"};
        //{"cha","r","act","ers"};    //"un","iq","ue"    //"cha","r","act","ers"
        List<String> arr = Arrays.asList(input);
        //System.out.println(maxLength(arr));

        System.out.println(isValidStringArrayWay("uniq"));
        //System.out.println(uniqueStringMaxLength(arr));
    }

    private static int uniqueStringMaxLength(List<String> arr) {
        uniqueStringMaxLength(arr, "",0);
        return maxLength;
    }

    //This is a Backtracking problem where you take 1 str merge it to another one
    // and check if it is valid if yes you merge and do recursive call further more. Just like N queens problem
    //at every step you cal maxLength and return the maxLength at last.
    private static void uniqueStringMaxLength(List<String> arr, String currWord, int start) {
        for(int index = start; index < arr.size(); index++){
            String str = arr.get(index);
            String temp = str + currWord;

            if(isValidString(temp)){
                int max = temp.length();
                maxLength = Math.max(max, maxLength);
                uniqueStringMaxLength(arr, temp,index + 1);
            }

        }

    }
    //Very Fast
    private static boolean isValidStringArrayWay(String temp) {
        char[] chars = new char[26];
        char[] tempArr = temp.toCharArray();
        for(char ch : tempArr){
           if(chars[ch - 'a']++ > 0){
               return false;
           }
        }
        return true;
    }


    private static boolean isValidString(String temp) {
        char[] chars = temp.toCharArray();
        HashSet<Character> sets = new HashSet<>();
        for(char ch : chars){
            if(sets.contains(ch)){
                return false;
            }
            sets.add(ch);
        }
        return temp.length() == sets.size();
    }

}
