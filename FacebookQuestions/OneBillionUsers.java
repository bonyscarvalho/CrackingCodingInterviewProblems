package FacebookQuestions;

public class OneBillionUsers {
    public static void main(String[] args) {
        float[] test_1 = {1.1f, 1.2f, 1.3f};
        int expected_1 = 79;
        System.out.println(getBillionUsersDay(test_1));

        float[] test_2 = {1.01f, 1.02f};
        int expected_2 = 1047;
        System.out.println(getBillionUsersDay(test_2));
    }

    private static int getBillionUsersDay(float[] growthRates) {
        if(growthRates.length == 0)return 0;
        double totalDays = 0;
        int lowerBound = 1, upperBound = 2000;
        double target = 1_000_000_000;

        while (lowerBound < upperBound){
            int midBound = (lowerBound + upperBound)/2;

            double midTotalDays = 0;
            for(float growthRate : growthRates){
                midTotalDays += Math.pow(growthRate, midBound);
            }

            if(target == midTotalDays){
                return midBound;
            }else if(target > midTotalDays){
                lowerBound = midBound + 1;
            }else {
                upperBound = midBound;
            }
        }
        //double total = Math.pow(1.5, 52);
        //System.out.println(total > 1_000_000_000);


        return lowerBound;
    }
}
