package ChapterSortingAndSearching;

import java.util.Arrays;
import java.util.Collections;

class RadixSort {

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(Integer arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++){
            count[(arr[i] / exp) % 10]++;
        }
        System.out.println("Count Array: ");
        Arrays.stream(count).forEach(integer -> System.out.print(integer + " "));

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        System.out.println("Count Array After Rearrange: ");
        Arrays.stream(count).forEach(integer -> System.out.print(integer + " "));

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[--count[(arr[i] / exp) % 10]] = arr[i];
            //count[(arr[i] / exp) % 10]--;       // to get the last digit of the num exp--> 1, 10, 100 and Mod will return the last digit
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void radixsort(Integer arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = Collections.max(Arrays.asList(arr));

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    /*Driver Code*/
    public static void main(String[] args)
    {
        Integer arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        // Function Call
        radixsort(arr, n);
        System.out.println("\nRADIX Sort: ");
        Arrays.stream(arr).forEach(integer -> System.out.print(integer + " "));
    }
}
