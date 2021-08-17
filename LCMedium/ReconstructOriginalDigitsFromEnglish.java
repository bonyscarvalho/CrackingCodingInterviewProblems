package LeetCodeMedium;
//423. Reconstruct Original Digits from English
public class ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        String s1 = "owoztneoer", s2 = "fviefuro";
        System.out.println(originalDigits(s1));
        System.out.println(originalDigits(s2));
    }

    public static String originalDigits(String s) {
        char[] count = new char[26];
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        int[] output = new int[10]; //as there are 0 - 9 nums

        output[0] = count['z' - 'a'];
        output[2] = count['w' - 'a'];
        output[4] = count['u' - 'a'];
        output[6] = count['x' - 'a'];
        output[8] = count['g' - 'a'];
        output[3] = count['h' - 'a'] - output[8];    // 1 h in three and 1 in eight
        output[5] = count['f' - 'a'] - output[4];
        output[7] = count['s' - 'a'] - output[6];
        output[9] = count['i' - 'a'] - output[5] - output[6] - output[8];
        output[1] = count['n' - 'a'] - output[7] - (2 * output[9]); // 2n in nine


        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < output[i]; j++){
                res.append(i);
            }
        }

        return res.toString();
    }
}
