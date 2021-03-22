package ToughQuestion;

public class MedianOfSortedArr {

    public static void main(String args[]) {
        int[] arr1 = {1, 3, 8, 9, 15};
        int[] arr2 = {7, 11, 18, 19, 21, 25};

        System.out.println("Median of 2 Sorted Arr is: " + computeMedian(arr1, arr2));
    }

    private static double computeMedian(int[] arr1, int[] arr2) {
        if(arr2.length > arr1.length){
            return computeMedian(arr2, arr1);
        }
        int len1 = arr1.length;
        int len2 = arr2.length;

        int low = 0;
        int high = len2;
        int totalLen = len1 + len2;

        while (low <= high){

            int partition1 = (high + low) / 2;
            //can be (high + low + 1)/2 for even odd len combo but we will have extra val in left so Math.max(l1, l2) for odd len
            int partition2 = ((totalLen + 1)/2) - partition1;

            int l1 = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int l2 = partition2 == 0 ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int r1 = partition1 == len1 ? Integer.MAX_VALUE : arr1[partition1];
            int r2 = partition2 == len2 ? Integer.MAX_VALUE : arr2[partition2];

            if(l1 <= r2 && l2 <= r1){
                return (len1 + len2) % 2 == 0 ?
                        ((Math.max(l1,l2) + Math.min(r1, r2)) / 2) : Math.max(l1, l2);      //Math.min(r1, r2);
            }else if(l1 > r2){
                high = partition1 - 1;
            }else {
                low = partition1 + 1;
            }
        }

        return -1;
    }

}
