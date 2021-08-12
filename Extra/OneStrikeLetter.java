package Extra;

import java.util.HashMap;
import java.util.Map;

public class OneStrikeLetter {
    public static void main(String[] args) {
        //System.out.println(solutionFinder("BBAAOONNXXOOLLLL"));
        System.out.println(solution("BBAAOONNXXOOLLLL"));
    }

    private static int solution(String S){
        if(S.length() == 0 || S.length() < 7) return 0;

        int[] charCount = new int[26];
        int counter = Integer.MAX_VALUE;

        for (char ch: S.toCharArray()){
            charCount[ch - 'A']++;
        }

        counter = Math.min(counter, charCount['B' - 'A']);
        counter = Math.min(counter, charCount['A' - 'A']);
        counter = Math.min(counter, charCount['L' - 'A'] / 2);
        counter = Math.min(counter, charCount['O' - 'A'] / 2);
        counter = Math.min(counter, charCount['N' - 'A']);

        return counter;
    }

    private static int solutionFinder(String S) {
        if(S.length() == 0 || S.length() < 7) return 0;

        Map<Character, Integer> letterCount = new HashMap<>();
        String ballon = "BALLOON";
        int count = 0;
        boolean isCountable = true;

        for(char ch : S.toCharArray()){
            letterCount.put(ch, letterCount.getOrDefault(ch, 0) + 1);
        }

        while (isCountable) {
            int currCount = 0;
            for (char ch : ballon.toCharArray()) {
                if (letterCount.containsKey(ch) && letterCount.get(ch) > 0) {
                    letterCount.put(ch, letterCount.get(ch) - 1);
                    currCount++;
                } else {
                    isCountable = false;
                    return count;
                }
            }
            if(currCount == 7){
                count++;
            }
        }

        return count;
    }
}
