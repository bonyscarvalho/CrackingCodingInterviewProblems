package LeetCodeEasy;

//1832. Check if the Sentence Is Pangram
public class CheckIsPangram {
    public static void main(String[] args) {
        String sentence1 = "thequickbrownfoxjumpsoverthelazydog", sentence2 = "leetcode";
        System.out.println(checkIfPangram(sentence1));
        System.out.println(checkIfPangram(sentence2));
    }
    public static boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;

        int[] charsFreq = new int[26];

        for(char curr : sentence.toCharArray()){
            if(Character.isAlphabetic(curr)){
                charsFreq[curr - 'a']++;
            }
        }

        for(int freq : charsFreq){
            if(freq == 0) return false;
        }

        return true;
    }
}
