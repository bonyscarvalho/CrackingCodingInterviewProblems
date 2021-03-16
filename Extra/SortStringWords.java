package Extra;

import java.util.Arrays;

public class SortStringWords {
    public static void main(String args[]) {
        String str = "This is a test String";
        String[] arr =  str.split(" ");

        String output = sortStringByWords(arr);
        System.out.println("Results: " + output);
    }
    //Notes: You take one Element and find its position in all its previous array.
    // Like Shift and Swap. Paper cutted String and now move them
    private static String sortStringByWords(String[] arr) {
        if(arr.length == 0)return " ";

        for(int i  = 1; i < arr.length; i++){
            String word = arr[i];       //This

            int index = i-1;        //0

            while (index >= 0 && word.length() < arr[index].length()){      // is a This
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = word;
        }
        return  Arrays.toString(arr);
    }
}
