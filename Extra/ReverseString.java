package Extra;

public class ReverseString {
    public static void main(String args[]) {
        String str = "CAT"; //"The Daily Byte";
        System.out.println(computeReversedString(str));
    }

    private static String computeReversedString(String str) {
        if(str.length() == 0)return "";
        char[] strArr = str.toCharArray();

        int leftPtr = 0, rightPtr = str.length() - 1;

        while (leftPtr < rightPtr){
            char temp = strArr[leftPtr];
            strArr[leftPtr] = strArr[rightPtr];
            strArr[rightPtr] = temp;

            leftPtr++;
            rightPtr--;
        }


        return String.copyValueOf(strArr);
    }
}
