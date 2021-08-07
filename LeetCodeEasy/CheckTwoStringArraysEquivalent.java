package LeetCodeEasy;
//1662. Check If Two String Arrays are Equivalent
public class CheckTwoStringArraysEquivalent {

    public static void main(String[] args) {
        String[] word11 = {"ab", "c"},word12 = {"a", "bc"};
        String[] word21 = {"a", "cb"},word22 = {"ab", "c"};

        System.out.println(arrayStringsAreEqual(word11, word12));
        System.out.println(arrayStringsAreEqual(word21, word22));
        System.out.println(arrayStringsAreEqualJoin(word11, word12));
        System.out.println(arrayStringsAreEqualJoin(word21, word22));
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1.length == 0 || word2.length == 0) return false;

        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();

        for(String word : word1){
            w1.append(word);
        }
        for(String word : word2){
            w2.append(word);
        }

        return w1.toString().equals(w2.toString());
    }

    public static boolean arrayStringsAreEqualJoin(String[] word1, String[] word2) {
        String s1 = String.join("", word1);
        String s2 = String.join("", word2);
        return s1.equals(s2);
    }
}
