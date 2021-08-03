package LeetCodeMedium;

public class AbsoluteDifferenceNumAndIdx {
    public static void main(String args[]) {
        int[] nums = {-70, -64, -6, -56, 64, 61, -57, 16, 48, -98 };
        System.out.println(maxDistance(nums));
    }
    private static int maxDistance(int[] array){
        if(array.length == 0)return 0;

        Integer max1 = Integer.MIN_VALUE;   //i
        Integer min1 = Integer.MAX_VALUE;   //i
        Integer max2 = Integer.MIN_VALUE;   //j
        Integer min2 = Integer.MAX_VALUE;   //j

        for (int idx = 0; idx < array.length; idx++){   //Mod can be represented as +i and -i
            max1 = Math.max(max1, array[idx] + idx);
            min1 = Math.min(min1, array[idx] + idx);

            max2 = Math.max(max2, array[idx] - idx);
            min2 = Math.min(min2, array[idx] - idx);
        }

        return Math.max(max1 - min1, max2- min2);
    }
}
