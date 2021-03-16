package ChapterSortingAndSearching;

import java.util.ArrayList;

public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] input = {{15, 20, 40, 85},
                          {20, 35, 80, 95},
                          {30, 55, 95, 105},
                          {40, 80, 100, 120}
                        };

        ArrayList<Integer> result = sortedMatrixSearch(input, 85);
        System.out.println("Result: " + result);
    }

    private static ArrayList<Integer> sortedMatrixSearch(int[][] input, int target) {
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = input.length - 1;

        while (i >= 0 && i < input.length && j >= 0 && j < input.length){
            if(input[i][j] == target){
                result.add(i);
                result.add(j);
                return result;
            }else if(input[i][j] > target){
                j--;
            }else {
                i++;
            }
        }
        return null;
    }
}
