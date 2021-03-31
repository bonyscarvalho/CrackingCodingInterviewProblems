package ChapterModerate;

public class MinMax {
    public static void main(String[] args)
    {
        int num1 = 9;
        int num2 = 6;
        System.out.println("Max: "+ (num1 + num2 + Math.abs(num1 - num2)) / 2);
        System.out.println("Min: "+ (num1 + num2 - Math.abs(num1 - num2)) / 2);

    }

}
