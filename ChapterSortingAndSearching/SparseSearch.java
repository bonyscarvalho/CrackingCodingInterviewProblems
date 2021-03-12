package ChapterSortingAndSearching;

public class SparseSearch {
    public static void main(String args[]) {
        String[] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "", ""};
        String target = "at";


        //System.out.println(input[4].compareTo(input[0]));
        System.out.println("Target Index: " +findString(input, target));

    }

    private static int findString(String[] input, String target) {
        if(input.length == 0) return -1;

        int left = 0;
        int right = input.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if(input[mid].equalsIgnoreCase(target)){
                return mid;
            }

            if(input[mid].isEmpty()){
                int ptr = mid;
                while(input[ptr].isEmpty()){
                    ptr--;
                }


                if(input[ptr].compareTo(target) == 0){
                    return ptr;
                }else if(input[ptr].compareTo(target) > 0){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(input[mid].compareTo(target) > 0){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
