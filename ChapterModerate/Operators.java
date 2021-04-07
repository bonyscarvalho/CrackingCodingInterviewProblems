package ChapterModerate;

public class Operators {
    public static void main(String[] args) {
        int num1 = -20;
        int num2 = 10;

        System.out.println("Subtraction Result: "+ subtractNum(num1, num2));

        System.out.println("Multiplication Result: "+ multiplyNum(num1, num2));

        System.out.println("Division Result: "+ divideNum(num1, num2));
    }

    private static int divideNum(int num1, int num2) {
        if(num1 == 0 || num2 == 0)return 0;

        int res = 0;
        int prod = 0;
        int absNum1 = absNum(num1);
        int absNum2 = absNum(num2);

        while (absNum1 + negate(absNum2) >= 0){
            res++;
            absNum1 += negate(absNum2);
        }

        if(num1 > 0 && num2 > 0 || num1 < 0 && num2 < 0){
            return res;
        }else {
            return negate(res);
        }

//        while (prod + num2 <= 0){
//            res++;
//            prod +=num1;
//        }
    }

    private static int multiplyNum(int num1, int num2) {
        if(num1 < num2) return multiplyNum(num2, num1);

        int res = 0;

        for (int i = 0; i < absNum(num2); i++){
            res += num1;
        }

        if(num2 < 0){
            res = negate(res);
        }
        return res;
    }

    private static int absNum(int num2) {
        if(num2 < 0) return negate(num2);
        else return num2;
    }

    private static int subtractNum(int num1, int num2) {

        return num1 + negateByDoubling(num2);
    }

    private static int negateByDoubling(int num){
        int neg = 0;
        int signNum = num < 0 ? 1 : -1;
        int delta = signNum;

        while (num != 0){
            boolean diffSign = (num + delta > 0) != (num > 0);  // when delta is bigger it will be negative and will be true

            if(num + delta != 0 && diffSign){
                delta = signNum;
            }

            neg += delta;
            num += delta;
            delta += delta; //1, 2, 4, 8, 16
        }
        return neg;

    }

    private static int negate(int num){
        num = ~num;
        num++;
        return num;
    }
}
