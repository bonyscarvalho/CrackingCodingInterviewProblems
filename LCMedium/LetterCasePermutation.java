package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

//784. Letter Case Permutation
public class LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }
    public static List<String> letterCasePermutation(String s) {
        if(s.length() == 0) return new ArrayList<>();

        char[] str = s.toCharArray();
        List<String> perms = new ArrayList<>();
        letterCasePermutation(str, 0, perms);

        return perms;
    }

    private static void letterCasePermutation(char[] str, int idx, List<String> perms) {
        //if(idx == str.length){
            //System.out.println(str);
            perms.add(String.valueOf(str));
            //return;
      // }

        for(int i = idx; i < str.length; i++){
            char curr = str[i];

            if(!Character.isDigit(curr)){
                if(Character.isUpperCase(curr)){
                    System.out.println("U: " +curr);
                    str[i] = Character.toLowerCase(curr);
                    letterCasePermutation(str, i+1, perms);
                    str[i] = Character.toUpperCase(curr);
                }else {
                    System.out.println("L: " +curr);
                    str[i] = Character.toUpperCase(curr);
                    letterCasePermutation(str, i + 1, perms);
                    str[i] = Character.toLowerCase(curr);
                }
            }
        }
    }
}
