package LeetCodeMedium;

import java.util.Arrays;
import java.util.PriorityQueue;

//253. Meeting Rooms II
public class MeetingRoom {

    public static void main(String[] args)
    {
        int[][] intervals = {{2, 8}, {8, 20}, {5, 11}, {3, 4}, {11, 15}, {3, 9}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((A, B) -> (A - B));

        minHeap.add(intervals[0][1]);

        for(int idx = 1; idx < intervals.length; idx++){
            int prevMeetingEndingTime = minHeap.peek();
            int currMeetingStartingTime = intervals[idx][0];
            int currMeetingEndingTime = intervals[idx][1];

            if(currMeetingStartingTime >= prevMeetingEndingTime){
                minHeap.poll();
            }

            minHeap.add(currMeetingEndingTime);
        }

        return minHeap.size();
    }
}
