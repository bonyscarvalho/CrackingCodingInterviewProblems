package LeetCodeMedium;

import java.util.PriorityQueue;

//1167. Minimum Cost to Connect Sticks
public class MinimumCostToConnectSticks {
    public static void main(String[] args) {
        int[] sticks1 = {1,8,3,5};
        int[] sticks = {2,4,3};
        System.out.println(connectSticks(sticks));
        System.out.println(connectSticks(sticks1));
    }

    public static int connectSticks(int[] sticks) {
        /*
         PriorityQueue<Integer> minHeap = new PriorityQueue<>(sticks.length, new Comparator<Integer>() {
         @Override
         public int compare(Integer o1, Integer o2) {
            return o1-o2;
         }
      });

	  //Ways to declare PriorityQueue.
	  //PriorityQueue<Integer> minHeap  = new PriorityQueue<>(); //PriorityQueue is min heap by default.
	  //PriorityQueue<Integer> minHeap  = new PriorityQueue<>((a,b)->(a-b));
         */

        if(sticks.length == 0)return 0;

        int minCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int stick : sticks){
            pq.add(stick);
        }

        while (pq.size() > 1){
            int curr = pq.remove();
            int next = pq.remove();

            int stickLen = curr + next;
            minCost += stickLen;

            pq.add(stickLen);
        }

        return minCost;
    }
}
