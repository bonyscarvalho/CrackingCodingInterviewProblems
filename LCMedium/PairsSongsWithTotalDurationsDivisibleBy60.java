package LeetCodeMedium;
//1010. Pairs of Songs With Total Durations Divisible by 60
public class PairsSongsWithTotalDurationsDivisibleBy60 {
    public static void main(String args[]) {
        int[] time1 = {30,20,150,100,40};
        int[] time2 = {60,60,60};
        int[] time3 = {60,0};
        System.out.println(numPairsDivisibleBy60(time1));
        System.out.println(numPairsDivisibleBy60(time2));
        System.out.println(numPairsDivisibleBy60(time3));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        if(time.length == 0) return 0;

        int numOfPairs = 0;
        int[] remainderCount = new int[60];

        for(int song : time){
            int normalizedTime = song % 60;     //for 2nd TC, if num is 60 then nT is 0 and remainderTime is 60 - 0 which is OutofBound so % 60
            int remainderTime = (60 - normalizedTime)% 60; // as the time can be 60 or 0

            if(remainderCount[remainderTime] > 0){
                numOfPairs += remainderCount[remainderTime];
            }

            remainderCount[normalizedTime] += 1;
        }

        return numOfPairs;
    }
}
