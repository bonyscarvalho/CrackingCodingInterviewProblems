package ToughQuestion;

//Given: An array A with all elements occuring twice except for x and y that occur once.
//To Do: Find the x and y in O(1) space and O(N) time
public class TwoDuplicates {
    public static void main(String[] args)
    {
        int[] arr = {3, 4, 8, 2, 1, 2, 8, 3};
        computeDuplicates(arr);
    }

    private static void computeDuplicates(int[] arr) {
        int all = 0;

        for(int num : arr){
            all ^= num;
        }
        System.out.println("all: "+ all);

        int k = 0;
        while(hasBitValue(all, k)){
            k++;
        }
        System.out.println("k: "+k);

        int num1 = 0, num2 = 0;
        for (int i=0; i< arr.length; i++) {

            if(hasBitValue(arr[i], (k - 1))){
                System.out.println("arr: " +arr[i]);
                num1 ^= arr[i];
            }else {
                num2 ^= arr[i];
            }
        }
        System.out.println("num1: "+num1+" num2: "+num2);

    }

    private static boolean hasBitValue(int num, int index) {
        int temp = num & (1<<index);
        return temp != 0;
    }
}
