package ChapterArraysAndStrings;

public class URLify {
    public static void main(String args[]) {
        String input = "Mr John Smith    ";
        int trueLength = 13;

        String output = urlShortenUpdate(input, trueLength);
        System.out.println("Output String :" + output);
    }

    private static String urlShortenUpdate(String input, int trueLength) {
        int index = input.length() - 1;
        char[] ch = input.toCharArray();
        int i = input.length() - 1;

        while(ch[index] == ' '){
            index--;
        }

        //Using Backward Approach to Keep track and keep some extra space at the back of string to put the space chars
        while(trueLength >= 0 && i >= 0){
            if(ch[index] != ' '){
                ch[i] = ch[index];
                i--;
                index--;
            }else{
                ch[i--] = '0';
                ch[i--] = '2';
                ch[i--] = '%';
                index--;
            }
        }

        return String.valueOf(ch);
    }
}
