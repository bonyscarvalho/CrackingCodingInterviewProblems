package LeetCodeMedium;

import java.util.HashMap;
import java.util.Map;

//299. Bulls and Cows
public class BullsAndCows {
    public static void main(String[] args) {
        String secret1 = "1807", guess1 = "7810";
        String secret2 = "1123", guess2 = "0111";

        System.out.println(getHint(secret1, guess1));
        System.out.println(getHint(secret2, guess2));
    }

    public static String getHint(String secret, String guess) {
        if(secret.length() != guess.length()) return "";

        Map<Character, Integer> sFreq = new HashMap<>();
        int cows = 0, bulls = 0;

        for(char s : secret.toCharArray()){
            sFreq.put(s, sFreq.getOrDefault(s, 0) + 1);
        }

        for(int idx = 0; idx < guess.length(); idx++){
            char secretChar = secret.charAt(idx);
            char guessChar = guess.charAt(idx);

            if(sFreq.containsKey(guessChar)){
                if(secretChar == guessChar){
                    bulls++;

                    if(sFreq.get(guessChar) <= 0){
                        //As the cows should be decremented if the both char match so that freq can be given to bull
                        cows--;
                    }
                } else {
                    if(sFreq.get(guessChar) > 0){
                        cows++;
                    }
                }
                sFreq.put(guessChar, sFreq.get(guessChar) - 1);
            }
        }

        return Integer.toString(bulls) + 'A' + Integer.toString(cows) + 'B';
    }
}
