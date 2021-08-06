package FacebookQuestions;

public class EncryptedWords {
    public static void main(String[] args) {
        String s_1 = "facebook"; //facebook
        String expected_1 = "bac";  //eafcobok
        System.out.println(findEncryptedWord(s_1));

        String s_2 = "abcd";    //abcxcba
        String expected_2 = "bacd"; //xbacbca
        //System.out.println(findEncryptedWord(s_2));
    }

    private static String findEncryptedWord(String s) {
        if(s.length() <= 2)return s;

        return computeEncryption(s, 0, s.length() - 1);
    }

    private static String computeEncryption(String s, int startPtr, int endPtr) {
        if(startPtr > endPtr)return "";
        if(endPtr - startPtr + 1 <= 2)return s.substring(startPtr, endPtr + 1);

        int midPtr = (startPtr + endPtr)/2;
        System.out.println(s.charAt(midPtr));

        return s.charAt(midPtr) + computeEncryption(s, startPtr, midPtr - 1) +
                computeEncryption(s, midPtr + 1, endPtr);
    }
}
