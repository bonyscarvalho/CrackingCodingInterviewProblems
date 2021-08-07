package LeetCodeEasy;

import java.util.Arrays;

//937. Reorder Data in Log Files
public class ReorderDataInLogFiles {
    public static void main(String[] args) {
        String[] logs1 = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] logs2 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};

        String[] sorted1 = reorderLogFiles(logs1);
        System.out.println("SORTED 1: ");
        Arrays.stream(sorted1).forEach(val-> System.out.print(val + " "));
        String[] sorted2 = reorderLogFiles(logs2);

    }

    public static String[] reorderLogFiles(String[] logs) {
        /*
        log1 > log2 -> 1
        log1 == log2 -> 0
        log1 < log2 -> -1
         */
        Arrays.sort(logs, (log1, log2)->{
            int indexLog1 = log1.indexOf(" ");  //removing the Id
            String id1 = log1.substring(0, indexLog1);
            String main1 = log1.substring(indexLog1+1);

            int indexLog2 = log2.indexOf(" ");  //removing the Id
            String id2 = log2.substring(0, indexLog2);
            String main2 = log2.substring(indexLog2+1);

            boolean isDigitLog1 = Character.isDigit(main1.charAt(0));
            boolean isDigitLog2 = Character.isDigit(main2.charAt(0));

            if(!isDigitLog1 && !isDigitLog2){   //both are letter logs
                int value = main1.compareTo(main2);
                if(value == 0){ //both letter are same so compare by their Ids
                    return id1.compareTo(id2);
                }
                return value;
            }

            if (isDigitLog1){   //log1 is a Digit
                if(isDigitLog2){//log2 is a Digit
                    return 0;   //SO no sorting is required
                }else { // log2 is a letter so higher priority then log1
                    return 1;
                }
            }else { //log1 is not a digit
                return -1;
            }
            //return isDigitLog1 ? (isDigitLog2 ? 0 : 1) : -1;
        });

        return logs;
    }
}
