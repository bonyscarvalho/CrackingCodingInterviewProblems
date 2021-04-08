package ChapterModerate;

public class KadaneContiguousSequence {
    public static void main(String[] args) {
        int[] input = {2, -8, 3, -2, 4, -10};
        int maxSum = computeContiguousSum(input);
    }

    private static int computeContiguousSum(int[] input) {
        if(input.length == 0) return -1;

        int currMax = input[0];
        int max = input[0];
        int startIdx = 0, endIdx = 0, temp = 0;

        for (int i = 1; i < input.length; i++){
            if(input[i] > (currMax + input[i])){
                currMax = input[i];
                temp = i;
            }else {
                currMax += input[i];
            }

            if(max < currMax){
                max = currMax;
                startIdx = temp;
                endIdx = i;
            }
        }
        System.out.println("Max: " + max + " StartIDX: " + startIdx + " EndIDX: " + endIdx);

        return max;
    }
}
