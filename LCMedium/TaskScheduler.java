package LeetCodeMedium;

import java.util.Arrays;
import java.util.Map;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0) return 0;
        if(n == 0) return tasks.length;

        int[] char_freq = new int[26];  //as only upper case letters 0-25
        for(char task : tasks){
            char_freq[task - 'A']++;
        }

        Arrays.sort(char_freq); //O(1) operation as there are only 26 chars
        int max_charVal = char_freq[25] - 1;
        //After last "A" we are not sitting Idle anymore as it is done
        //'A' -> 'B' -> 'IDLE'- >'A' -> 'B' -> 'IDLE' -> 'A' -> 'B'

        int idleTime = (max_charVal * n);   //As we don't require the last max_char to have any idle time

        for(int idx = 24; idx >= 0; idx--){
            idleTime -= Math.min(max_charVal, char_freq[idx]);
            //Calculation of the number of Idle Values remaining after successfully inserting remaining chars
            //if the values go to negative then we know there is no Idle values remaining and task can be ordered
        }

        if(idleTime > 0){
            return idleTime + tasks.length;
        }

        return tasks.length;

    }
}
