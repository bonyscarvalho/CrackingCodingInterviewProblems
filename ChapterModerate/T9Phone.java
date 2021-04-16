package ChapterModerate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class T9Phone {
    public static void main(String[] args)
    {
//        char ch = 'A';
//        System.out.println((ch - '0') + 4);

        System.out.println(Character.forDigit(10, 10));

        Map<Integer, Character> mapping = new HashMap<>();
        mapping.put(1,'-');mapping.put(0, '-');
        mapping.put(2, 'a');mapping.put(3, 'd');mapping.put(4, 'g');mapping.put(5, 'j');
        mapping.put(6, 'm');mapping.put(7, 'p');mapping.put(8, 't');mapping.put(9, 'w');

        String[] words = {"tree", "mate", "used","don", "tooth"};
        String num = "8733";

        ArrayList<String> results = computeValidWords(num, mapping, words);
        System.out.println(results);
    }

    private static ArrayList<String> computeValidWords(String num, Map<Integer, Character> mapping, String[] words) {
        ArrayList<String> results = new ArrayList<>();
        if(num.length() == 0) return results;

        for (String word : words){
            System.out.println("Word: " + word);
            if(word.length() == num.length()){
                for(int i = 0; i < word.length(); i++){
                    char wordChar = word.charAt(i); int wordCharVal = wordChar - '0';
                    int delta = 3;

                    char inputChar = num.charAt(i); int inputCharVal = inputChar - '0';

                    if(inputCharVal == 7 || inputCharVal == 9){
                        delta = 4;
                    }

                    char mapChar = mapping.get(inputCharVal);
                    int mapCharVal = mapChar - '0';


                    if(!(wordCharVal >= mapCharVal && wordCharVal <= (mapCharVal + delta))){
                        break;
                    }
                    if(i == word.length() -1){
                       results.add(word);
                    }
                }
            }
        }

        return results;
    }
}
