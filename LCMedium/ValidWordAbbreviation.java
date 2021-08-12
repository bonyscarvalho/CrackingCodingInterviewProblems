package LeetCodeMedium;
//408. Valid Word Abbreviation
public class ValidWordAbbreviation {
    public static void main(String[] args) {
        String word1 = "internationalization", abbr1 = "i12iz4n";
        String  word = "apple", abbr = "a2e";
        System.out.println(validWordAbbreviation(word1, abbr1));
        System.out.println(validWordAbbreviation(word, abbr));
    }
    public static boolean validWordAbbreviation(String word, String abbr) {
        if(word.length() == 0 || abbr.length() == 0)return false;

        int wordLen = word.length(), abbrLen = abbr.length();
        int wordPtr = 0, abbrPtr = 0;

        while (abbrPtr < abbrLen && wordPtr < wordLen){
                int count = 0;
                while (abbrPtr < abbrLen && Character.isDigit(abbr.charAt(abbrPtr))) {
                    // special case "a" & "01"
                    int n = abbr.charAt(abbrPtr) - '0';
                    if (n == 0 && count == 0) {
                        return false;
                    }

                    count = count * 10 + n;
                    abbrPtr++;
                }
                wordPtr += count;

                if(abbrPtr >= abbrLen || wordPtr >= wordLen){
                    break;
                }

                if(word.charAt(wordPtr) != abbr.charAt(abbrPtr)){
                    return false;
                }
                wordPtr++;
                abbrPtr++;
        }

        if (abbrPtr == abbrLen && wordPtr == wordLen){
            return true;
        }

        return false;
    }
}
