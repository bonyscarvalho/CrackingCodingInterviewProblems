package ChapterRecursionAndDP;

public class RecursiveMultiply {
    public static void main(String[] args) {
        int num1 = 12;
        int num2 = 10;

        int smallerNum = Math.min(num1, num2);
        int biggerNum = Math.max(num1, num2);

        int ans = productHelper(smallerNum, biggerNum);
        System.out.println(ans);

//        int ans = multiplyWithoutOperator(num1, num2);
//        System.out.println(ans);
//        int res = 0;
//        while (num2 >= 1){
//            res += num1;
//            num2--;
//        }
//        System.out.println("Res: "+ res);
    }

    private static int productHelper(int smallerNum, int biggerNum) {
        if(smallerNum == 0) return 0;
        if(smallerNum == 1) return biggerNum;

        int smallHalfed = smallerNum >> 1;

        int halfProd = productHelper(smallHalfed, biggerNum);

        if((smallerNum % 2) == 0){
            return halfProd + halfProd;
        }else {
            return halfProd + halfProd + biggerNum;
        }
    }

    private static int multiplyWithoutOperator(int num1, int num2) {
        if(num2 == 1) return num1;
        if(num1 == 0 || num2 == 0) return 0;
        return (num1 + multiplyWithoutOperator(num1,num2 - 1));


    }
}
