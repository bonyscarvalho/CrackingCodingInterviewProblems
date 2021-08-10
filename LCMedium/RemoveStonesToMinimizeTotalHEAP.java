package LeetCodeMedium;

import java.util.PriorityQueue;

//1962. Remove Stones to Minimize the Total
public class RemoveStonesToMinimizeTotalHEAP {
    public static void main(String[] args) {
        int[] piles1 = {5,4,9}; int k1 = 2;
        int[] piles2 = {4,3,6,7}; int k2 = 3;

        System.out.println(minStoneSum(piles1, k1));
        System.out.println(minStoneSum(piles2, k2));
    }

    public static int minStoneSum(int[] piles, int k) {
        if(piles.length == 0)return 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int totalRemainingStones = 0;

        for(int pile : piles){
            maxHeap.add(pile);
        }

        while (k > 0){
            int currStone = maxHeap.remove();
            int remainingStone = currStone - (currStone/2);
            maxHeap.add(remainingStone);
            k--;
        }

        while (!maxHeap.isEmpty()){
            totalRemainingStones += maxHeap.remove();
        }

        return totalRemainingStones;
    }
}
