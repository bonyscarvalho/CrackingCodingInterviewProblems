package LeetCodeMedium;

import java.util.Arrays;

//294. Flip Game II
public class FlipGameII {
    public static void main(String[] args) {
        String currentState1 = "++++", currentState2 = "+";
        System.out.println(canWin(currentState1));
        System.out.println(canWin(currentState2));
    }

    public static boolean canWin(String currentState) {
        if(currentState.length() < 2) return false;

        char[] currState = currentState.toCharArray();
        return canWinHelper(currState);
    }

    private static boolean canWinHelper(char[] currState) {
        for (char curr : currState){
            System.out.print(curr + " ");
        }
        System.out.println();
        for(int idx = 0; idx < currState.length - 1; idx++){
            if(currState[idx] == '+' && currState[idx + 1] == '+'){
                currState[idx] = '-'; currState[idx + 1] = '-';

                if(!canWinHelper(currState)){
                    currState[idx] = '+'; currState[idx + 1] = '+';
                    return true;
                }
                currState[idx] = '+'; currState[idx + 1] = '+';
            }
        }

        return false;
    }
}

