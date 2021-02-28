package ChapterRecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PermutationsWithDups {
    public static void main(String[] args) {
        String s = "AAB";

//        HashSet<String> perms = getPermutationsWithOutDups(s);
//        System.out.println("Perm without Dups: " + perms);

        ArrayList<String> perms = getPermutationsWithDupsString(s);
        System.out.println("Perm: " + perms);

//        computeStringPermutations(s, "");
//        System.out.println("Permutation: " + result);
    }

    private static ArrayList<String> getPermutationsWithDupsString(String s) {
        if(s.length() == 0) return new ArrayList<>();

        HashMap<Character, Integer> charCount = new HashMap<>();
        for(char ch: s.toCharArray()){
            if(charCount.containsKey(ch)){
                charCount.put(ch, charCount.get(ch) + 1);
            }else {
                charCount.put(ch, 1);
            }
        }
        System.out.println("Map: " + charCount);

        ArrayList<String> results = new ArrayList<>();
        printPerms(charCount, s.length() , "", results);
        return results;
    }

    private static void printPerms(HashMap<Character, Integer> charCount, int remaining, String prefix, ArrayList<String> results) {
        if(remaining == 0){
            System.out.println("Result: " +prefix);
            results.add(prefix);
            return;
        }

        for (char ch: charCount.keySet()){
            System.out.println("Char: " + ch);
            int count = charCount.get(ch);
            if(count > 0){
                charCount.put(ch, count - 1);   //like Substring(1)
                System.out.println("Prefix: " + (prefix + ch));
                printPerms(charCount, remaining - 1, prefix + ch, results);
                charCount.put(ch, count);
            }
        }
    }
}
