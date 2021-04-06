package ChapterModerate;

import java.util.LinkedList;

public class EnglishInt {
    static String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] bigs = {"", "Thousand", "Million", "Billion"};
    static String hundred = "Hundred ";
    static String negative = "Negative ";

    public static void main(String args[]) {
        String converted = convertToEnglish(2566690);
        System.out.println(converted);
    }

    private static String convertToEnglish(int num) {
        if(num == 0){
            return smalls[0];
        }else if(num < 0){
            return negative + convertToEnglish(-1 * num);
        }
        LinkedList<String> parts = new LinkedList<>();
        int partsCount = 0;

        while (num > 0){
            if(num % 1000 != 0){
                System.out.println("Parts: " + num % 1000);
                String chunk = convertPartsOfChunk(num % 1000) + " " + bigs[partsCount];
                System.out.println("Chunk: " + chunk);
                parts.addFirst(chunk);
            }

            num = num / 1000;
            partsCount++;
        }

        return listToString(parts);
    }

    private static String convertPartsOfChunk(int num) {
        LinkedList<String> parts = new LinkedList<>();

        if(num >= 100){
            parts.addLast(smalls[num/100]);
            parts.addLast(hundred);
        }

        num = num % 100;

        if(num >=10 && num <= 19){
            parts.addLast(smalls[num]);
        }else if(num >= 20){
            parts.addLast(tens[num / 10]);
            num = num % 10;
        }

        if(num >= 1 && num <= 9){
            parts.addLast(smalls[num]);
        }

        return listToString(parts);
    }

    private static String listToString(LinkedList<String> parts) {
        StringBuilder res = new StringBuilder();
        while (parts.size() > 0){
            res.append(parts.pop());
            res.append(" ");
        }
//        res.append(parts.pop());
//        res.append(" ");
        return res.toString();
    }
}
