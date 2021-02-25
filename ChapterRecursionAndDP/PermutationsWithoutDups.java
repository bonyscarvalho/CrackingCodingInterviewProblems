package ChapterRecursionAndDP;

import java.util.ArrayList;

public class PermutationsWithoutDups {
    static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) {
        String s = "ABC";

        ArrayList<String> perms = getPermutations(s);
        System.out.println("Perm: " + perms);

//        computeStringPermutations(s, "");
//        System.out.println("Permutation: " + result);
    }

    private static ArrayList<String> getPermutations(String s) {
        if(s == null) return null;

        ArrayList<String> perm = new ArrayList<>();
        if(s.length() == 0){
            perm.add("");
            return perm;
        }

        char firstChar = s.charAt(0);
        String remaining = s.substring(1);
        ArrayList<String> words = getPermutations(remaining);

        for (String word : words){
            for(int i = 0; i <= word.length(); i++){
                String formedWord = formWord(word, i, firstChar);
                System.out.println("Formed Word: " + formedWord);
                perm.add(formedWord);
            }
        }

        return perm;
    }

    private static String formWord(String word, int index, char firstChar) {
        String start = word.substring(0, index);
        String end = word.substring(index);
        return (""+start+firstChar+end) ;
    }

    private static void computeStringPermutations(String s, String prefix) {
//        if(prefix.length() == 0) {
//            System.out.println("No Perm");
//        }

        if(s.length() == 0){
            System.out.println("Result: " +prefix);
            result.add(prefix);
            return;
        }else {
            for(int i = 0; i < s.length(); i++){
                String remaining = s.substring(0, i) + s.substring(i+1);   //For 0: Empty and BC
                System.out.println("Reamining: "+s.charAt(i)+" is " + remaining);
                //prefix = prefix + ;   // For 0: A
                System.out.println("Prefix: is " + prefix);
                computeStringPermutations(remaining, prefix + s.charAt(i));
            }
        }

    }
}
