package Extra;

import java.util.Arrays;

public class MinimumNumberOfLamps {
    public static void main(String args[]) {
        String street = "*.*.....";
        System.out.println(computeMinNumberOfLamps(street));
    }

    private static int computeMinNumberOfLamps(String street) {
        if (street.length() == 0)return 0;

        int[] lampPosition = new int[street.length()];
        Arrays.fill(lampPosition, 1);

        for(int idx = 0; idx < street.length(); idx++){
            if(street.charAt(idx) == '*'){
                lampPosition[idx] = -1;
                if(idx > 0 && idx < street.length() - 1){
                    lampPosition[idx - 1] = -1;
                    lampPosition[idx + 1] = -1;
                }else if(idx > 0){
                    lampPosition[idx - 1] = -1;
                }else{
                    lampPosition[idx + 1] = -1;
                }
            }
        }
        int currCount = 0, result = 0;
        for(int position : lampPosition){
            if(position == 1){
                currCount++;
            }else{
                // For finding the ceil(a/b) we use (a + b - 1)/b.
                result += (currCount + 2)/3;
                currCount = 0;  //making it 0 as we restart the count after couting the celing min lamp required
            }
        }

        result += (currCount + 2)/3;

        return result;
    }
}
