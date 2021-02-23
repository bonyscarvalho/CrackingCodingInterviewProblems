package ChapterRecursionAndDP;

public class MagicIndex {
    public static void main(String[] args) {
//    int[] arr = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 22};
//    int magicIndex = getMagicIndexValue(arr);
//    System.out.println("Magic Index: " + magicIndex);

        int[] arrNonDistinctValues = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 22};
        int nDistinctVal = getMagicIndexValueFromNonDistinctArr(arrNonDistinctValues);
        System.out.println("Magic Index: " + nDistinctVal);


    }

    private static int getMagicIndexValueFromNonDistinctArr(int[] arr) {
        if(arr.length == 0) return -1;
        return getMagicIndexValueFromNonDistinctArr(arr, 0, arr.length-1);
    }

    private static int getMagicIndexValueFromNonDistinctArr(int[] arr, int start, int end) {
        if(end < start) return -1;  //base case

        int midIdx = (start + end) / 2 ;
        int midVal = arr[midIdx];

        if(midIdx == midVal) return midIdx;

        int leftIdx = Math.min(midVal , midIdx -1);
        int left = getMagicIndexValueFromNonDistinctArr(arr, start, leftIdx);
        if(left >= 0) return left;

        int rightIdx = Math.max(midVal, midIdx + 1);
        int right = getMagicIndexValueFromNonDistinctArr(arr, rightIdx, end);
        return right;
    }

    private static int getMagicIndexValue(int[] arr) {
        if(arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;

        while ((left <= right)){
            int mid = (left + right) / 2 ;
            System.out.println("Mid: " +mid);

            if(arr[mid] == mid){        // 5, 7, 9, 12, 22
                return mid;
            }else if(arr[mid] > mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
