package ChapterModerate;

public class NumberSwapper {
    public static void main(String[] args)
    {
        int num1 = 10;
        int num2 = 8;
        System.out.println(num1);
        System.out.println(num2);
        num1 = num1 - num2; //Cal DIfference
        num2 = num1 + num2; //Add diff to num2 to get val of num1
        num1 = num2 - num1; // minus the diff from num2(as now it is num1) to get the value of num2
        System.out.println(num1);
        System.out.println(num2);
    }
}
