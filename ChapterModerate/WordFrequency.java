package ChapterModerate;

import java.util.HashMap;
import java.util.Locale;

public class WordFrequency {
    public static void main(String[] args)
    {
     String[] book ={" this", "is","a","string", "for","this"," is ", " a"};
     HashMap<String,Integer> table =  setUpDictionary(book);
     System.out.println(getFrequency(" xx", table));

    }

    private static int getFrequency(String word, HashMap<String, Integer> table) {
        if(table == null || word.length() == 0) return -1;
        word = word.trim().toLowerCase();
        if(table.containsKey(word)){
            return table.get(word);
        }
        return -1;
    }

    private static HashMap<String, Integer> setUpDictionary(String[] book) {
        if(book.length == 0) return null;
        HashMap<String, Integer> table = new HashMap<>();

        for(String word : book){
            word = word.toLowerCase().trim();
            table.put(word, table.getOrDefault(word,0) + 1);
        }
        System.out.println(table);
        return table;
    }
}
