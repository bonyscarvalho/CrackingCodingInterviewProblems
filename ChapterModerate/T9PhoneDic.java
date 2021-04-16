package ChapterModerate;

import java.util.ArrayList;
import java.util.HashMap;

public class T9PhoneDic {
    static char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void main(String[] args) {
        String[] words = {"tree", "mate", "used","don", "tooth","tasty"};

        HashMap<String, ArrayList<String>> dictionary = initializeDictonary(words);
        System.out.println(dictionary);

        //ArrayList<String> results = getValidT9Words(words);
    }

    private static HashMap<String, ArrayList<String>> initializeDictonary(String[] words){
        HashMap<Character, Character> charToNumberMaps = createLetterToNumberMapping();
        System.out.println(charToNumberMaps);

        HashMap<String, ArrayList<String>> wordsToNumberMapping = new HashMap<>();

        for (String word : words){
            String number = convertToT9(word, charToNumberMaps);
            if(wordsToNumberMapping.containsKey(number)){
                ArrayList<String> wordList = wordsToNumberMapping.get(number);
                wordList.add(word);
                wordsToNumberMapping.put(number, wordList);
            }else {
                ArrayList<String> wordList = new ArrayList<>();
                wordList.add(word);
                wordsToNumberMapping.put(number, wordList);
            }
        }
        return wordsToNumberMapping;
    }

    private static String convertToT9(String word, HashMap<Character, Character> charToNumberMaps) {
        StringBuilder sb = new StringBuilder();

        for (char letter : word.toCharArray()){
            if(charToNumberMaps.containsKey(letter)){   //EXTRA VALIDATION
                sb.append(charToNumberMaps.get(letter));
            }
        }

        return sb.toString();
    }

    private static HashMap<Character, Character> createLetterToNumberMapping() {
        HashMap<Character, Character> letterToNumMap = new HashMap<>();

        for (int i = 0; i < t9Letters.length; i++){
            char[] letters = t9Letters[i];
            if(letters != null){
                for (char letter : letters){
                    letterToNumMap.put(letter, Character.forDigit(i, 10));
                }
            }
        }

        return letterToNumMap;
    }
}
