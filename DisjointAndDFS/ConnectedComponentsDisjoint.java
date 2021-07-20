package LeetCodeMedium.DisjointAndDFS;

import java.util.HashMap;
import java.util.Map;

public class ConnectedComponentsDisjoint {
    public static void main(String args[]) {
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};        //{{0,1},{1,2},{3,4}};

        int n = 5;
        //edges = [[0,1],[1,2],[3,4]]

        System.out.println(countComponents(n, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        Map<Integer, Integer> parents = new HashMap<>();
        int[] rank = new int[n];
        makeSets(parents, n);

        for(int idx = 0; idx < edges.length; idx++){
            int src = edges[idx][0];
            int dest = edges[idx][1];

            union(parents, src, dest, rank);
        }

        int groups = 0;
        for(int key : parents.keySet()){
            if(key == parents.get(key)){
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
