package ChapterBitManipulation;

public class Insertion {
    public static void main(String args[]) {
        Integer n = 0b10000111100;
        Integer m = 0b10011;
        int i = 2;
        int j = 6;

        //Integer insertionN = insertionOfMinN(n, m , i, j);
        //System.out.println("Insertion Result: " + Integer.toBinaryString(insertionN));

        Integer insertMinN = insertMinN(n, m , i, j);
        System.out.println("Insertion Result: " + Integer.toBinaryString(insertMinN));
    }

    private static Integer insertMinN(Integer n, Integer m, int i, int j) {
        int allOnes = ~0;

        int left = allOnes << (j + 1);
        System.out.println("Left: " + Integer.toBinaryString(left));
        int right = ((1 << i) - 1);
        System.out.println("Right: " + Integer.toBinaryString(right));

        int clearedM = left | right;
        System.out.println("Cleared Bits M: " + Integer.toBinaryString(clearedM));

        int n_cleared = n & clearedM;
        int m_shifted = m << i;

        return n_cleared | m_shifted;
    }

    private static int insertionOfMinN(Integer n, Integer m, int i, int j) {
        int leftShiftedByI = (m << i);
        int clearBit = 0;
        for(int a = 0; a < 5; a++){
            int mask = 1;
            mask = 1 << a;
            clearBit = clearBit | mask;
        }
        //System.out.println("Mask Binary: "+ Integer.toBinaryString(clearBit));
        int clearBitShifted = clearBit << i;
        //System.out.println("Clear Bit Binary: "+ Integer.toBinaryString(clearBitShifted));

        int cleanedN = n & ~clearBitShifted;
        //System.out.println("Clear N Binary: "+ Integer.toBinaryString(cleanedN));

        //System.out.println("Left Shifted M: " + Integer.toBinaryString(leftShiftedByI));
        Integer insertionN = (cleanedN | leftShiftedByI);
        //System.out.println("Insertion Result: " + Integer.toBinaryString(insertionN));
        return insertionN;
    }
}
