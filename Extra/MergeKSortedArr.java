package Extra;

import java.util.Arrays;
import java.util.PriorityQueue;

class QueueNode implements Comparable<QueueNode>{
    int arrIdx;
    int arrVal;
    int currIdx;
    QueueNode(int arrIdx, int arrVal, int currIdx){
        this.arrIdx = arrIdx;
        this.arrVal = arrVal;
        this.currIdx = currIdx;

    }

    @Override
    public int compareTo(QueueNode n) {
        if(arrVal > n.arrVal) return 1;
        if (arrVal < n.arrVal) return -1;
        return 0;
    }
}
public class MergeKSortedArr {
    public static void main(String[] args) {
        int [][] arr = {{1, 5, 9}, {2, 4, 8}, {3, 6, 7}};
        int [] mergedSortedArr = mergedSortedArray(arr);

    }

    private static int[] mergedSortedArray(int[][] arr) {
        if (arr.length == 0) return new int[2];

        int size = 0;
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            size += arr[i].length;
            pq.add(new QueueNode(i, arr[i][0], 0));
        }

        int[] result = new int[size];

        for (int i = 0; !pq.isEmpty(); i++){
            QueueNode n = pq.poll();
            int num = n.arrVal;
            result[i] = num;
            int idx = n.currIdx + 1;
            if(idx < arr[n.arrIdx].length){
                pq.add(new QueueNode(n.arrIdx, arr[n.arrIdx][idx], idx));
            }
        }

        Arrays.stream(result).forEach(System.out::println);
        return result;
    }
}
