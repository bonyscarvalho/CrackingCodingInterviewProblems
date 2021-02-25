package Extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneLetterCombination {
    public static void main(String args[]) {
        String digits = "234";
        String [] wordsToDigits = {
          "0","0","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> results = new ArrayList<>();
        recursiveApproachForLetterCombination(results, digits, wordsToDigits, "", 0);
        System.out.println("Results: " + results);

//        List<String> letterCombination = letterCombinations(digits);  //Iterative Approach 
//        System.out.println("Result: " +letterCombination);

    }

    private static List<String> recursiveApproachForLetterCombination(List<String> results, String digits, String[] wordsToDigits, String word, int currIdx) {
        if(currIdx == digits.length()){
            results.add(word);
            //System.out.println("Result: " +results);
            return results;
        }

        String phoneWord = wordsToDigits[digits.charAt(currIdx) - '0'];
        for (int i = 0; i < phoneWord.length(); i++){
            recursiveApproachForLetterCombination(results, digits,wordsToDigits, word + phoneWord.charAt(i), currIdx + 1);
        }
        return results;
    }

    public static List<String> letterCombinations(String digits){
        if(digits.length() == 0) return null;

        HashMap<Integer, String> phone= new HashMap<>();
        phone.put(1,"");
        phone.put(2, "abc");
        phone.put(3,"def");
        phone.put(4,"ghi");
        phone.put(5,"jkl");
        phone.put(6,"mno");
        phone.put(7,"");
        phone.put(8,"");
        phone.put(9,"");
        phone.put(0,"");

        return findLetterCombination(phone, digits);
    }

    private static List<String> findLetterCombination(HashMap<Integer, String> phone, String digits) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> combinations = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++){
            int num = digits.charAt(i) - '0';
            if(num <= 9 && num >= 1){
                String s = phone.get(num);
                System.out.println("String: "+s);

                combinations = getCombination(s, res);
            }
            res = new ArrayList<>();
            res.addAll(combinations);
        }

        return res;
    }

    private static ArrayList<String> getCombination(String s, ArrayList<String> res) {
        ArrayList<String> temp = new ArrayList<>();
        if(res.size() == 0){
            for (char ch: s.toCharArray()){
                temp.add(Character.toString(ch));
            }
            return temp;
        }else {
            for (char ch : s.toCharArray()){
                for (String word : res){
                    temp.add(word + ch);
                    System.out.println("Word: " + (word+ch));
                }
            }
        }
        System.out.println("Temp: " +temp);
        return temp;
    }

}
