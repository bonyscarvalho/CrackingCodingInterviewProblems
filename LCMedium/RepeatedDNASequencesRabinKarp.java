package LeetCodeMedium;

import java.util.*;

//187. Repeated DNA Sequences
public class RepeatedDNASequencesRabinKarp {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        //System.out.println(findRepeatedDnaSequencesSetApp(s));
        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        int len = 10, base = 4, shiftLeft = (int) Math.pow(base, len - 1);

        Map<Character, Integer> toInt = new HashMap<>();
        toInt.put('A', 1); toInt.put('C', 2); toInt.put('G', 3); toInt.put('T', 4);

        Set<Integer> seen = new HashSet<>();
        int currHash = 0;
        // Compute hash value of the initial window s[0, len - 1].
        for (int i = 0; i < len; ++i) {
            currHash = currHash * base + toInt.get(s.charAt(i));
        }
        seen.add(currHash);
        // Iterate through all other windows.
        for (int i = 1; i + len <= s.length(); ++i) {
            currHash = currHash - toInt.get(s.charAt(i - 1)) * shiftLeft;
            currHash = currHash * base + toInt.get(s.charAt(i + len - 1));
            if (seen.contains(currHash)) result.add(s.substring(i, i + len));
            seen.add(currHash);
        }
        return new ArrayList<>(result);
    }

    public static List<String> findRepeatedDnaSequencesSetApp(String s) {
        if(s.length() < 10) return new ArrayList<>();

        Set<String> repeated = new HashSet<>();
        Set<String> seen = new HashSet<>();

        for(int i = 0; i < s.length() - 10 + 1; i++){
            String curr = s.substring(i, i + 10);
            System.out.println(curr);
            if (seen.contains(curr)){
                repeated.add(curr);
            }
            seen.add(curr);
        }

        return new ArrayList<>(repeated);
    }
}
