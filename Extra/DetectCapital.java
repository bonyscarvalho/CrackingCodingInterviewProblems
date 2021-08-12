package Extra;

//520. Detect Capital
public class DetectCapital {

    public static void main(String[] args) {
        String word = "USA";
        System.out.println(detectCapitalUse("leetcode"));
    }

    public static boolean detectCapitalUse(String word) {
        if(word.length() == 0) return false;

        int upperCaseCount = 0;

        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                upperCaseCount++;
            }
        }

        if(upperCaseCount == word.length()  || upperCaseCount == 0) return true;

        return (upperCaseCount == 1 && Character.isUpperCase(word.charAt(0)));

    }
}
