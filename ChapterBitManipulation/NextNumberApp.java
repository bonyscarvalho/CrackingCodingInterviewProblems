package ChapterBitManipulation;

public class NextNumberApp {
    public static void main(String args[]) {
        Integer num = 13948;
        Integer nextLargest = getNextLargest(num);
        System.out.println("Next Larget Num: " + Integer.toBinaryString(nextLargest));
        Integer prevNum = 0b10011110000011;
        Integer prevSmallest = getPrevSmallest(prevNum);
       // System.out.println("Prev Smallest Num: " + Integer.toBinaryString(prevSmallest));
    }

    private static Integer getPrevSmallest(Integer num) {
        int temp = num;
        int c0 = 0, c1 = 0;

        while((temp & 1) == 1){
            c1++;
            temp = temp>>1;
        }

        if(temp == 0) return -1;

        while((temp & 1) == 0){
            c0++;
            temp = temp>>1;
        }
        int pointer = c0 + c1;

        num = num & (~(0) << pointer + 1);
        System.out.println("Num: "+ Integer.toBinaryString(num));
        int mask = ((1 << (c1 + 1)) - 1);
        System.out.println("Mask: "+ Integer.toBinaryString(mask));
        num = num | (mask << (c0 - 1));

        System.out.println("Num: "+ Integer.toBinaryString(num));

        return num;
    }

    private static Integer getNextLargest(Integer num) {
        int temp = num;
        int c0 = 0, c1 = 0;

        while((temp & 1) == 0){
            c0++;
            temp = temp>>1;
        }
        while((temp & 1) == 1){
            c1++;
            temp = temp>>1;
        }
        int pointer = c0 + c1;

        if(pointer == 31 || pointer == 0){
            return -1;
        }

        num = num | 1 << pointer;
        num = num & (~((1 << pointer) - 1));

        num = num | ((1 << (c1 - 1)) - 1);

       // System.out.println("Bin: " + Integer.toBinaryString(13948));
        //System.out.println("Num: " + Integer.toBinaryString(num));

        return num;
    }
}
