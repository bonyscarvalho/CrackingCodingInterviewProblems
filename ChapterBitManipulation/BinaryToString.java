package ChapterBitManipulation;

public class BinaryToString {
    public static void main(String args[]) {
        double num = 0.5;
        String binaryToString = convertNumToBinary(num);
        System.out.println("Flip Bit Count: " + binaryToString);

    }

    private static String convertNumToBinary(double num) {
        if(num >= 1 || num <= 0) return "ERROR";

        StringBuffer sb = new StringBuffer("0.");
        int decimalPoint = 5;
        while (num > 0){

            if(sb.length() >= 32) return "ERROR";

            double n = num;
            n = n * 2;
            if(n >= 1){
                sb.append(1);
                n = n - 1;
            }else {
                sb.append(0);
            }
            //int remainder = (int) (n % 10);
           // sb.append(remainder);
            //num = remainder == 1 ? (n - 1) : n;
            num = n;
            //decimalPoint--;
        }
        return sb.toString();
    }
}
