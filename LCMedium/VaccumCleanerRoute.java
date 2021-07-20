package LeetCodeMedium;

import java.util.HashMap;
import java.util.Map;

public class VaccumCleanerRoute {
    public static void main(String args[]) {
        String route = "URURD";     //"RUULLDRD";
        System.out.println(isVaccumBackToPosition(route));
    }

    private static boolean isVaccumBackToPosition(String route) {
        if(route.length() == 0)return true;
        Map<Character, int[]> directionMap = new HashMap<>();
        directionMap.put('L', new int[]{-1, 0});
        directionMap.put('R', new int[]{1, 0});
        directionMap.put('U', new int[]{0, 1});
        directionMap.put('D', new int[]{0, -1});

        int[] startPosition = new int[]{0,0};

        for(int idx = 0; idx < route.length(); idx++){
            char currDir = route.charAt(idx);

            int[] currMove = directionMap.get(currDir);

            startPosition[0] += currMove[0];
            startPosition[1] += currMove[1];
        }

        if(startPosition[0] == 0 && startPosition[1] == 0){
            return true;
        }

        return false;
    }
}
