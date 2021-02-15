package ChapterBitManipulation;

public class FlipBitToWin {
    public static void main(String args[]) {
        Integer num = 1775;
        int flipMaxCount = getMaxFlipCount(num);
        System.out.println("Flip Bit Count: " + flipMaxCount);

    }

    private static int getMaxFlipCount(Integer num) {
        if(~num == 0) return 0;
        int currLen = 0;
        int prevLen = 0;
        int maxLen = 1;

        while (num != 0){
            if((num & 1) != 0){
                currLen++;
            }else if((num & 1) == 0){
                prevLen = ((num & 2) == 0) ? 0: currLen;
                currLen = 0;
            }
            maxLen = Math.max(currLen + prevLen + 1, maxLen);
            num = num >>> 1;
        }
        return maxLen;
    }
}
