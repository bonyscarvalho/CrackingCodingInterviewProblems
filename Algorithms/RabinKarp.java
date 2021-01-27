package Algorithms;

public class RabinTrapSubStringSearch {
    public static  int primeNumber = 3;

    public static void main(String[] args) {
        String pattern = "defc";
        String s = "adefcabcac";

        Integer presentIndex = isPatternPresentInString(s, pattern);
        System.out.println("Pattern Present Result Index is " + presentIndex);

    }

    private static Integer isPatternPresentInString(String s, String pattern) {
        int stringLen = s.length();
        int patternLen = pattern.length();

        if(stringLen == 0 || patternLen == 0 || stringLen < patternLen) return -1;

        double patternHash = calculateHashValue(pattern);

        System.out.println("Hash Value of Pattern: " + patternHash);


        int i = 0;
        double subStringHashValue = 0;
        int recalculatedValue = 0;
        double lastIndexValue = 0;

        while(i + patternLen <= stringLen){
            //int valueAtFirstIdx = s.charAt(i);

            if(i == 0){
                subStringHashValue = calculateHashValue(s.substring(i, i + patternLen));
                System.out.println("SubString Hash Value for i: "+i+ " is "+ subStringHashValue);

            }else{
                double charAtLastIndex = s.charAt(i + patternLen - 1);
                //System.out.println("Value at charAtLastIndex: " + charAtLastIndex + " for char " + s.charAt(i + patternLen - 1));
                subStringHashValue = (subStringHashValue - s.charAt(i - 1)) / primeNumber;
                //System.out.println("subStringHashValue: " + subStringHashValue + " for char " + s.charAt(i + patternLen - 1));

                //System.out.println("Divide Value "+ (subStringHashValue - valueAtFirstIdx) / primeNumber);
                lastIndexValue = Math.pow(primeNumber, patternLen - 1) * charAtLastIndex;
                //System.out.println("lastIndexValue: " + lastIndexValue + " for char " + s.charAt(i + patternLen - 1));

                //System.out.println("Last Index Value "+ lastIndexValue);
                //subStringHashValue = ((subStringHashValue - valueAtFirstIdx) / primeNumber) + ( Math.pow(primeNumber, patternLen-1) * charAtLastIndex );
                subStringHashValue = subStringHashValue + lastIndexValue;
                //System.out.println("Final subStringHashValue Value "+ subStringHashValue + " for char " + s.charAt(i + patternLen - 1));
            }
            if(patternHash == subStringHashValue){
                int j = 0;
                for(j = 0; j < patternLen; j++){
                    if(pattern.charAt(j) != s.charAt(i + j)){
                        break;
                    }
                }
                if(j == patternLen) return i;

            }
            i++;
        }

        return -1;
    }

    private static double calculateHashValue(String pattern) {
        if(pattern.length() == 0) return 0;

       // int primeNumber = 3;
        double valueOfHash = 0.0;
        int len = pattern.length();

        for(int i = 0; i < len; i++){
            int valueOfChar = pattern.charAt(i) ;
            valueOfHash += Math.pow(primeNumber, i) * valueOfChar;
        }

        return valueOfHash;
    }
}
