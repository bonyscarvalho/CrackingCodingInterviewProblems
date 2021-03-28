package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PaintHouse {
    static int[][] houses = {{17,2,17},{16,16,5},{14,3,19}};
    static HashMap<String, Integer> memo = new HashMap<>();
    public static void main(String args[]) {

        System.out.println(computePaintingCost(houses));
        System.out.println(memo);

        System.out.println(computeByDP(houses));


    }

    private static int computeByDP(int[][] houses) {
        if(houses.length == 0) return 0;

        int[][] memory = new int[houses.length][houses[0].length];
        int n = houses.length - 1;
        for(int i = 0; i < houses[0].length; i++){
            memory[n][i] = houses[n][i];
        }

        for (int houseNum = n - 1; houseNum >= 0; houseNum--){
            for(int color = 0; color < houses[houseNum].length; color++){
                if(color == 0){
                    memory[houseNum][color] = houses[houseNum][color] + Math.min(memory[houseNum + 1][1], memory[houseNum + 1][2]);
                }else if(color == 1){
                    memory[houseNum][color] = houses[houseNum][color] + Math.min(memory[houseNum + 1][0], memory[houseNum + 1][2]);
                }else {
                    memory[houseNum][color] = houses[houseNum][color] + Math.min(memory[houseNum + 1][0], memory[houseNum + 1][1]);
                }
            }
        }
        int min = Arrays.stream(memory[0]).min().getAsInt();

        return min;
    }

    private static int computePaintingCost(int[][] houses) {
        if(houses.length == 0) return 0;

        return Math.min(paintingCost(0, 0), Math.min(paintingCost(0, 1), paintingCost(0, 2)));
    }

    private static int paintingCost(int houseNum, int color) {
        if(memo.containsKey(getKey(houseNum,color))){
            System.out.println("HIT");
            return memo.get(getKey(houseNum, color));
        }

        int totalCost = houses[houseNum][color];

        if(houseNum == houses.length - 1){  // We dont have tp calculate for 3rd house as it is the last one
            //last house added for check
        }else if(color == 0){       //1st Color
            totalCost += Math.min(paintingCost(houseNum + 1, 1), paintingCost(houseNum + 1, 2));
        }else if(color == 1){
            totalCost += Math.min(paintingCost(houseNum + 1, 0), paintingCost(houseNum + 1, 2));
        }else if (color == 2){
            totalCost += Math.min(paintingCost(houseNum + 1, 0), paintingCost(houseNum + 1, 1));
        }
        memo.put(getKey(houseNum, color) , totalCost);
        return totalCost;
    }

    private static String getKey(int houseNum, int color) {
        return String.valueOf(houseNum) + " " + String.valueOf(color);
    }

    private static int computePaintingCost(int[][] houses, int houseIdx, int prevIdx, int minVal) {
        if(houseIdx >= houses.length) return 0;
        int currVal = 0;

        for(int house = houseIdx; house < houses.length; house++){
            for(int i = 0; i < houses[house].length; i++){
                if(prevIdx != i){
                    currVal = houses[house][i] + computePaintingCost(houses, house + 1, i, minVal);
                }
                if(currVal < minVal){
                    minVal = currVal;
                }
            }
        }
        System.out.println(minVal);
        return minVal;
    }
}
