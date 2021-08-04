package FacebookQuestions;

import java.util.*;

public class QueueRemovals {
    public static class Position{
        int val, idx;
        public Position(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String args[]) {
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        Arrays.stream(output_1).forEach(value -> System.out.print(value + " "));

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
        System.out.println("NEXT RES: ");
        Arrays.stream(output_2).forEach(value -> System.out.print(value + " "));
    }

    private static int[] findPositions(int[] arr, int x) {
        int[] output = new int[x];
        Queue<Position> queue = new LinkedList<>();

        for(int idx = 0; idx < arr.length; idx++){
            queue.add(new Position(idx + 1, arr[idx]));
        }

        List<Position> poppedElements;

        for(int idx = 0; idx < x; idx++){
            poppedElements = new ArrayList<>();
            int maxVal = Integer.MIN_VALUE;
            int maxIdx = -1;

            for(int j = 0; j < x && !queue.isEmpty(); j++){
                Position currPosition = queue.poll();
                poppedElements.add(currPosition);

                if(currPosition.val > maxVal){
                    maxVal = currPosition.val;
                    maxIdx = currPosition.idx;
                }
            }

            output[idx] = maxIdx;

            for(Position popped : poppedElements){
                if(popped.idx != maxIdx){
                    queue.add(new Position(popped.idx, (popped.val == 0) ? 0 : popped.val - 1));
                }
            }
        }

        return output;
    }
}
