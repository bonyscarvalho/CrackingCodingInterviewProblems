package ChapterBitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Conversion {
    public static void main(String args[])
    {
        int num1 = 29;
        int num2 = 15;
        int diff = getTheDifferenceOfDigits(num1, num2);

        System.out.println("Difference: " + diff);
    }

    private static int getTheDifferenceOfDigits(int num1, int num2) {
        int xor = num1 ^ num2;
        int result = 0;

        while (xor != 0){
            if((xor & 1) ==1){
                result++;
            }
            xor = xor >> 1;
        }
        return result;
    }
}
