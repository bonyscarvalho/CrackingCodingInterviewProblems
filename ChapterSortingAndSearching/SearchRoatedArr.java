package ChapterSortingAndSearching;

public class SearchRoatedArr {
    public static void main(String args[]) {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int search = 5;
        System.out.println("Index of "+search+" is " + findElement(arr, search));

        int indx = findElementForDuplicates(arr, 0, arr.length -1, search);
        System.out.println("IDX: " + indx);

    }

    private static int findElementForDuplicates(int[] arr, int leftIdx, int rightIdx, int searchVal) {
       // if(arr.length == 0) return -1;

        int mid  = (leftIdx + rightIdx) / 2;
        if(arr[mid] == searchVal) return mid;

        if(rightIdx < leftIdx) return -1;

        if(arr[leftIdx] < arr[mid]){    //Left is Increasing
            if(arr[leftIdx] <= searchVal && searchVal < arr[mid]){
                return findElementForDuplicates(arr, leftIdx, mid - 1, searchVal );
            }else {
                return findElementForDuplicates(arr, mid + 1, rightIdx, searchVal );
            }
        }else if(arr[leftIdx] > arr[mid]){
            if(arr[rightIdx] >= searchVal && arr[mid] < searchVal){
                return findElementForDuplicates(arr, mid + 1, rightIdx, searchVal );
            }else {
                return findElementForDuplicates(arr, leftIdx, mid - 1, searchVal );
            }
        }else if(arr[leftIdx] == arr[mid]){
            if(arr[rightIdx] != arr[mid]){
                return findElementForDuplicates(arr, mid + 1, rightIdx, searchVal );
            }else {
                int result = findElementForDuplicates(arr, leftIdx, mid - 1, searchVal );
                if(result == -1){
                    return findElementForDuplicates(arr, mid + 1, rightIdx, searchVal );
                }else {
                    return result;
                }
            }
        }
        return -1;
    }

    private static int findElement(int[] arr, int search) {
        if(arr.length == 0) return -1;

        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        while (leftIdx <= rightIdx){
            int midIdx = (leftIdx + rightIdx) / 2;

            if(arr[midIdx] == search)return midIdx;

            if(arr[rightIdx] < search){
                rightIdx = midIdx - 1;
            }else {
                leftIdx = midIdx + 1;
            }
        }
        return -1;
    }
}
