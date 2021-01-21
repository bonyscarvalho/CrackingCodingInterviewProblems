package ChapterArraysAndStrings;

public class StringRotation {
    public static void main(String args[]){
        String s1 = "abcde"; //"waterbottle"
        String s2 = "erbottlewat";

        System.out.println("String s2 result of being SubString of s1 is " + isSubStringCheck(s1, s2));
    }

    private static boolean isSubStringCheck(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) return false;

        String checkSubstring = s2 + s2;

        return checkSubstring.contains(s1);

    }
}
