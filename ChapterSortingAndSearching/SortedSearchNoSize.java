package ChapterSortingAndSearching;

public class SortedSearchNoSize {
    public static void main(String args[]) {
        int [] input = {2, 3, 5, 7, 8, 9, 9, 11, 11, 13, 15, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1};
        int targetElemen = 16;
        int indexElement = getElementByIndex(input, 5);
        int lenOfArr = findLengthOfArray(input, targetElemen);
        System.out.println("Target Element Index: " + findElementIndex(input, targetElemen, lenOfArr));
        //System.out.println(indexElement);

    }

    private static int findLengthOfArray(int[] input, int targetElemen) {
        int startIdx = 1;
        while (input[startIdx] != -1 && input[startIdx] < targetElemen){
            startIdx = startIdx * 2;
        }
//        while (input[startIdx] < 0){
//            startIdx--;
//        }

        System.out.println("Len: " + startIdx);
        return startIdx;
    }

    private static int findElementIndex(int[] input, int target, int arrLen) {
        int left = 0;
        int right = arrLen;

        while (left <= right){
            int mid = (left + right) / 2;
            if(input[mid] == target){
                return mid;
            }else if(input[mid] > target || input[mid] == -1){
                right = mid - 1;
            }else {
                left = mid + 1;
            }

        }
        return -1;
    }

    private static int getElementByIndex(int[] input, int index) {
        return input[index];
    }

}
