package LeetCodeMedium.DisjointAndDFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfProvincesDisjointSets {
    public static void main(String args[]) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        if(isConnected.length == 0) return 0;

        Map<Integer, Integer> parent = new HashMap<>();
        int[] rank = new int[isConnected.length];
        makeSets(parent, isConnected.length);
        Arrays.fill(rank, 0);

        for(int row = 0; row < isConnected.length; row++){
            for(int col = 0; col < isConnected[0].length; col++){
                if(isConnected[row][col] == 1){
                    union(parent, row, col, rank);
                }
            }
        }
        System.out.println(parent);

        int groups = 0;
        for(int key : parent.keySet()){
            if(key == parent.get(key)){
                groups++;
            }
        }

        return groups;
    }

    private static void makeSets(Map<Integer, Integer> parent, int length) {
        for(int val = 0; val < length; val++){
         parent.put(val, val);
        }
    }

    public static void union(Map<Integer, Integer> parent, int val1, int val2, int[] rank) {
        int leaderOfVal1 = find(parent, val1);
        int leaderOfVal2 = find(parent, val2);

        if(leaderOfVal1 == leaderOfVal2){
            return;
        }

        if(rank[leaderOfVal1] > rank[leaderOfVal2]){
            parent.put(leaderOfVal2, leaderOfVal1);
        }else if(rank[leaderOfVal1] < rank[leaderOfVal2]){
            parent.put(leaderOfVal1, leaderOfVal2);
        }else {
            parent.put(leaderOfVal1, leaderOfVal2);
            rank[leaderOfVal2]++;
        }
    }

    private static int find(Map<Integer, Integer> parent, int val) {
        if(parent.get(val) != val){
            int absParent = find(parent, parent.get(val));
            parent.put(val, absParent);
            return absParent;
        }
        return val;
    }


}
