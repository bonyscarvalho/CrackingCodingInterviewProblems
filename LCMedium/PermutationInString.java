package LeetCodeMedium;

//567. Permutation in String
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        String a1 = "adc", a2 = "dcda";

        System.out.println(checkInclusion(s1, s2));
        System.out.println(checkInclusion(a1, a2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];
        //initial s1 and s2 till s1 len
        for(int idx = 0; idx < s1.length(); idx++){
            s1Chars[s1.charAt(idx) - 'a']++;
            s2Chars[s2.charAt(idx) - 'a']++;
        }
        //VERY Important to validate the window size "s2.length() - s1.length()"
        for(int idx = 0; idx < s2.length() - s1.length(); idx++){
            if(matchesS1InS2(s1Chars, s2Chars)){
                return true;
            }
            //adding new chars after window
            s2Chars[s2.charAt(idx + s1.length()) - 'a']++;
            //shrink older ones
            s2Chars[s2.charAt(idx) - 'a']--;
        }

        //VERY IMPORTANT: we need to match it again for the last index as we are stopping at the last index and not comparing
        return matchesS1InS2(s1Chars, s2Chars);
    }

    private static boolean matchesS1InS2(int[] s1Chars, int[] s2Chars) {
        for(int idx = 0; idx < 26; idx++){
            if(s1Chars[idx] != s2Chars[idx]) return false;
        }
        return true;
    }
}
