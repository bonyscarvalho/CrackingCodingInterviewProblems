package LeetCodeMedium.DisjointAndDFS;

import java.util.*;


public class GraphValidTree {

    public static void main(String args[]) {
        int validN = 5; int[][] validEdges = {{0,1},{0,2},{0,3},{1,4}};
        int invalidN = 5; int[][] invalidEdges = {{0,1},{1,2},{2,3},{1,3},{1,4}};

        System.out.println("Is Graph Valid: " +validTree(validN, validEdges));
        System.out.println("Is Graph Valid: " +validTree(invalidN, invalidEdges));
    }

    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        Map<Integer, Integer> parents = new HashMap<>();
        int[] ranks = new int[n];
        int noOfLeader = 0;

        makeSets(parents, n);

        for(int idx = 0; idx < edges.length; idx++){
            int src = edges[idx][0];
            int dest = edges[idx][1];

            if(!unionAndCycleDetection(parents, ranks, src, dest)){
                return false;
            }
        }

        for(int val : parents.keySet()){
            if(val == parents.get(val)){
                noOfLeader++;
            }
        }

        return noOfLeader == 1;
    }

    public static void makeSets(Map<Integer, Integer> parents, Integer length){
        for(int idx = 0; idx < length; idx++){
            parents.put(idx, idx);  //self node is the parent of itself
        }
    }

    public static boolean unionAndCycleDetection(Map<Integer, Integer> parents, int[] ranks, Integer parent1, Integer parent2){
        Integer leaderOfParent1 = findLeader(parents, parent1);
        Integer leaderOfParent2 = findLeader(parents, parent2);

        if(leaderOfParent1 == leaderOfParent2){
            return false;
        }

        if(ranks[leaderOfParent1] > ranks[leaderOfParent2]){
            parents.put(leaderOfParent2, leaderOfParent1);
            ranks[leaderOfParent1]++;
        }else if(ranks[leaderOfParent1] < ranks[leaderOfParent2]){
            parents.put(leaderOfParent1, leaderOfParent2);
            ranks[leaderOfParent2]++;
        }else{
            parents.put(leaderOfParent2, leaderOfParent1);
            ranks[leaderOfParent1]++;
        }

        return true;
    }

    public static int findLeader(Map<Integer, Integer> parents, Integer parent){
        if(parents.get(parent) != parent){
            Integer absLeader = findLeader(parents, parents.get(parent));
            parents.put(parent, absLeader);
            return absLeader;
        }
        return parent;
    }
}
