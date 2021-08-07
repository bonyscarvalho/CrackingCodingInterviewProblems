package LeetCodeEasy;
//605. Can Place Flowers
public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n1 = 1; int n2 = 2;
        System.out.println(canPlaceFlowers(flowerbed, n1));
        System.out.println(canPlaceFlowers(flowerbed, n2));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 0)return false;

        int idx = 0, flowerPlacedCount = 0;
        while (idx < flowerbed.length){
            if((flowerbed[idx] == 0)
                    && (idx == 0 || flowerbed[idx - 1] == 0)
                    && ((idx == flowerbed.length - 1 || flowerbed[idx + 1] == 0))){
                flowerPlacedCount++;
                flowerbed[idx] = 1;
            }
            if(flowerPlacedCount >= n){
                return true;
            }
            idx++;
        }

        return false;
    }
}
