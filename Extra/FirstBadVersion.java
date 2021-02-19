package Extra;

public class FirstBadVersion {
    public static void main(String[] args) {
        boolean [] arr = {false,false, false, false, true, true, true, true, true, true};
        int badVersionIdx = findTheFirstBadVersion(arr);
        System.out.println("Start of Bad Version is: " + badVersionIdx);

    }

    private static int findTheFirstBadVersion(boolean[] arr) {
        if (arr.length == 0) return Integer.MIN_VALUE;

        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int mid = left + (right - left) / 2;    //You do left + (R-L)/2 to avoid overflow and remember it is r-l/2 and not the whole number/2;
            System.out.println("Mid: " + mid);

            if(!arr[mid]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;   //or right doesn't matter as both will be same
    }
}
