package ChapterBitManipulation;

public class PairwiseSwap {
    public static void main(String[] args)
    {
        int x = 23; // 00010111
        System.out.println("X "+Integer.toBinaryString(x));


        // Output is 43 (00101011)
        System.out.println(swapBits(x));
    }

    private static int swapBits(int x) {
        int evenBits = x & 0xAAAAAAAA ; //Index starts from 1 
        System.out.println("Even BITS "+Integer.toBinaryString(0xAAAAAAAA));

        System.out.println("Even "+Integer.toBinaryString(evenBits));
        int oddBits = x & 0x55555555 ;
        System.out.println("ODD BITS "+Integer.toBinaryString(0x55555555));
        System.out.println("Odd "+Integer.toBinaryString(oddBits));


        evenBits = evenBits >> 1;
        System.out.println("Even "+Integer.toBinaryString(evenBits));
        oddBits = oddBits << 1;
        System.out.println("Odd "+Integer.toBinaryString(oddBits));


        return evenBits | oddBits ;
    }
}
