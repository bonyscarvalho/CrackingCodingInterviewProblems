package ChapterRecursionAndDP;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes {
    static class Box {
        int height, width, depth;
        public Box(int h, int w, int d){
            height = h;
            width = w;
            depth = d;
        }
    }
    public static void main(String[] args) {
//        Box box1 = new Box(4, 4,4);
//        Box box2 = new Box(7, 7,7);
//        Box box3 = new Box(5, 5,5);
//        Box box4 = new Box(6, 6,6);

        Box[] boxes = new Box[4];
        boxes[0] = new Box(4, 4,4);
        boxes[1] = new Box(7, 7,7);
        boxes[2] = new Box(5, 5,5);
        boxes[3] = new Box(6, 6,6);

        Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                if(o1.height > o2.height) return -1;
                if(o1.height < o2.height) return 1;
                return 0;
            }
        });

        Arrays.stream(boxes).forEach(box -> System.out.print(box.height+" "));

        Integer totalMaxHeight = computeMaxHeight(boxes);

    }

    private static Integer computeMaxHeight(Box[] boxes) {
        if(boxes.length == 0) return 0;

        Integer[] results = new Integer[boxes.length];
        for(int i = 0; i < results.length; i++){
            results[i] = boxes[i].height;
        }

        //MEMO
        results[0] = boxes[0].height;
        int i = 0, j = i+1;

        while (i < j && j < boxes.length){
            while (i < j){
                if(isValidBox(boxes[i], boxes[j])){
                    int maxHeight = boxes[j].height + results[i];
                    if(maxHeight > results[j]){
                        results[j] = maxHeight;
                    }
                    System.out.println("results[j]: " +results[j] +" j: "+j +" i: "+i);
                }
                i++;
            }
            j++;
            i = 0;
        }

        Integer max = Collections.max(Arrays.asList(results));
        System.out.print("Results: ");
        Arrays.stream(results).forEach(res -> System.out.print(res+" "));
        System.out.println("Max Height: " +max);

        return max;

    }

    private static boolean isValidBox(Box box1, Box box2) {
        return ((box1.depth > box2.depth) && (box1.width > box2.width));
    }
}
