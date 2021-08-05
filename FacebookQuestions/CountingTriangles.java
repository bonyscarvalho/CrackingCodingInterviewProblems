package FacebookQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CountingTriangles {
    static class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        int expected_1 = 3;
        System.out.println(countDistinctTriangles(arr_1));

        ArrayList<Sides> arr_2 = new ArrayList<>();
        arr_2.add(new Sides(3, 4, 5));
        arr_2.add(new Sides(8, 8, 9));
        arr_2.add(new Sides(7, 7, 7));
        int expected_2 = 3;
        System.out.println(countDistinctTriangles(arr_2));
    }

    private static int countDistinctTriangles(ArrayList<Sides> arr) {
        int triangelsCount = 1;
        Collections.sort(arr, new Comparator<Sides>() {
            @Override
            public int compare(Sides o1, Sides o2) {
                return o1.a - o2.a;
            }
        });
        for(Sides side : arr){
            side = sortSide(side);
            //System.out.println(side.a +" "+ side.b+" "+side.c);
        }

//        for(Sides side : arr){
//            System.out.println(side.a +" "+ side.b+" "+side.c);
//        }

        for(int idx = 1; idx < arr.size(); idx++){
            Sides prev = arr.get(idx - 1);
            Sides curr = arr.get(idx);
            if((prev.a == curr.a) && (checkSideValues(prev, curr))){

            }else {
                triangelsCount++;
            }
        }


        return triangelsCount;
    }

    private static boolean checkSideValues(Sides prev, Sides curr) {
        return prev.a == curr.a && prev.b == curr.b && prev.c == curr.c;
    }

    private static Sides sortSide(Sides side) {
        int[] sort = {side.a, side.b, side.c};
        Arrays.sort(sort);
        side.a = sort[0]; side.b = sort[1]; side.c = sort[2];
        return side;
    }
}
