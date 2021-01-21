package ChapterArraysAndStrings;

public class StringCompression {
    public static void main(String args[]){
        String input = "aabbbccccddddd";
        String compressed = compressStringApproach2(input);
        System.out.println("Compressed String is "+ compressed);
    }

    private static String compressStringApproach2(String input) {
        if(input.length() == 0 || input.length() == 1) return input;

        StringBuilder compressedString = new StringBuilder();
        int consecutiveCount = 0;

        for(int i = 0; i < input.length(); i++){
            consecutiveCount++;

            if(i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)){
                compressedString.append(input.charAt(i)).append(consecutiveCount);
                consecutiveCount = 0;
            }
        }

        return compressedString.length() > input.length() ? input : compressedString.toString();

    }


    //Another Method would be starting from index 0 and moving forward.
    // REMEMBER to add the check for i+1 <= length(string) so as check for OutofBoundException.
    // Also Check if the compressed String is not greater then the current one. If yes then return orginal one.
//    private static String compressStringApproach1(String input) {
//        if(input.length() == 0) return input;
//        if(input.length() == 1) return (input + "1");
//
//        int index = 1;
//        int count = 1;
//        StringBuffer result = new StringBuffer();
//
//        while(index < input.length()){
//            if(input.charAt(index - 1) == input.charAt(index)){
//                count++;
//            }else{
//                result.append(input.charAt(index - 1)).append(count);
//                count = 1;
//            }
//            index++;
//        }
//        if(index == input.length()) result.append(input.charAt(index - 1)).append(count);
//        return result.toString();
//    }
}
