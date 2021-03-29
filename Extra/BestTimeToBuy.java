package Extra;

public class BestTimeToBuy {
    public static void main(String args[])
    {
        //int[] input = {5, 3, 1, 2, 3};
        int[] input =  {2,1,4,5,2,9,7};   //{1,2,3,4,5};     //{7,4, 3, 1,5,3,6,4};

        int maxProfitWithIndex = computeMaxProfitWithIndex(input);

        //int maxProfit = computeMaxProfit(input);
    }

    private static int computeMaxProfitWithIndex(int[] input) {
        if(input.length == 0) return 0;
        int index = 0;
        int valley = input[0];
        int peak = input[0];
        int maxProfit = 0;

        while (index < input.length - 1){
            while (index < input.length - 1 && input[index] >= input[index + 1]){
                index++;
            }
            valley = input[index];

            while (index < input.length - 1 && input[index] <= input[index + 1]){
                index++;
            }

            peak = input[index];

            maxProfit += (peak - valley);
        }

        System.out.println(maxProfit );
        return maxProfit;

    }

    private static int computeMaxProfit(int[] input) {
        if(input.length == 0) return 0;
        int valley = 0;
        int peak = 0;
        int maxProfit = 0;
        while (valley < input.length){
            while (valley < input.length - 1 && input[valley] > input[valley + 1]){
                valley = valley + 1;
            }
            System.out.println("Valley: " + valley);
            peak = valley + 1;

            while (peak < input.length - 1 && input[peak] < input [peak + 1]){
                peak = peak + 1;
            }
            System.out.println("Peak: " + peak);
            if(peak < input.length){
                int currProfit = input[peak] - input[valley];
                System.out.println("CURR: " + currProfit);
                maxProfit += currProfit;
            }
//            if(peak <= input.length){
//                break;
//            }
            valley = peak + 1;
        }

        System.out.println(maxProfit);

        return maxProfit;

    }

}
