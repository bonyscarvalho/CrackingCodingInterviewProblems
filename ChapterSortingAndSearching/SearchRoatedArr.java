package ChapterSortingAndSearching;

public class SearchRoatedArr {
    public static void main(String args[]) {
        int[] arr =  {15, 16, 19, 20, 25, 27, 28, 4, 5, 7, 10, 14};                               //{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int search = 28;

        int indx = findElementForDuplicates(arr, 0, arr.length -1, search);
        System.out.println("IDX: " + indx);

    }

    //you start with normal increasing case PS every condition will have you search both left to mid-1 and mid+1 right
    //1. a[left] < a[mid] if true you search for left side 1st where if val > a[left] && val < a[mid] --> true then left else right
    //2. a[left] > a[mid] if true you search for right side 1st where if val > a[mid] && val <= a[right] --> true then right else left search
    //3. (duplicates) a[left] == a[mid] if search right side 1st where a[mid] != a[right] --> true 
    // then right search left 1st(with a variable to know if left is result or -1) if -1 then search right else return result. 
    private static int findElementForDuplicates(int[] arr, int leftIdx, int rightIdx, int searchVal) {
       // if(arr.length == 0) return -1;

        int mid  = (leftIdx + rightIdx) / 2;
        if(arr[mid] == searchVal) return mid;

        if(rightIdx < leftIdx) return -1;

        if(arr[leftIdx] < arr[mid]){    //Left to mid is Increasing
            if(arr[leftIdx] <= searchVal && searchVal < arr[mid]){
                return findElementForDuplicates(arr, leftIdx, mid - 1, searchVal );
            }else {
                return findElementForDuplicates(arr, mid + 1, rightIdx, searchVal );
            }
        }else if(arr[leftIdx] > arr[mid]){  //mid to left is decreasing
            if(arr[rightIdx] >= searchVal && arr[mid] < searchVal){
                return findElementForDuplicates(arr, mid + 1, rightIdx, searchVal );
            }else {
                return findElementForDuplicates(arr, leftIdx, mid - 1, searchVal );
            }
        }else if(arr[leftIdx] == arr[mid]){     //both are equal
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
}
