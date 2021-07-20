package LeetCodeMedium.DisjointAndDFS;

import java.util.HashMap;
import java.util.Map;

public class BloodMatchDisjointSet {

    public static class DisjointSetUnion {
        Map<Integer, Integer> disjointSetsLeader;
        Map<Integer, Integer> disjointSetsRank;
        int totalSets;

        public DisjointSetUnion(int totalSets) {    //Constructor to Initialize the DSU instance
            this.totalSets = totalSets;
            disjointSetsLeader = new HashMap<>();
            disjointSetsRank = new HashMap<>();
            createSets(totalSets);
        }

        private void createSets(int totalSets) {
            for (int i = 1; i <= totalSets; i++) {
                disjointSetsLeader.put(i, i);   //initial setting of assign node to itself
                disjointSetsRank.put(i, 1);     //and rank of the each node to 1 as 1 node only is pointing to it

            }
        }

        public boolean union(int x, int y) {
            int leaderOfX = find(x);
            int leaderOfY = find(y);

            if (leaderOfX == leaderOfY) {
                return true;
            }
            //KISS
            //If Rank of Leader Y is greater then you swap its value so that there is only 1 operations for put and just 1 if condition rather then if else block
            //Always you change the value of Higher Rank to be the leader of lower rank
            if (disjointSetsRank.get(leaderOfY) > disjointSetsRank.get(leaderOfX)) {    //Order by Rank Stage rather then random
                int temp = leaderOfY;
                leaderOfY = leaderOfX;
                leaderOfX = temp;
            }
            disjointSetsLeader.put(leaderOfY, leaderOfX);
            int updatedRankOfX = disjointSetsRank.get(leaderOfX) + disjointSetsRank.get(leaderOfY);
            disjointSetsRank.put(leaderOfX, updatedRankOfX);
            totalSets--;

            return false;
        }

        public int find(int x) {
            if (disjointSetsLeader.get(x) != x) {
                int rootLeader = find(disjointSetsLeader.get(x));
                disjointSetsLeader.put(x, rootLeader);  //Path Compression Stage
                return rootLeader;
            }
            return x;
        }
    }



    public static void main(String[] args) {
        int n = 10;
        int[][] relations = {{1, 2}, {4, 2}, {6, 9}, {6, 10}, {8, 10}};
        int m = 3;
        int[][] queries = {{1, 4}, {6, 8}, {3, 7}};

        DisjointSetUnion disjointSetUnion = new DisjointSetUnion(n);

        //creating the disjoint sets
        for (int idx = 0; idx < relations.length; idx++){
            disjointSetUnion.union(relations[idx][0], relations[idx][1]);
        }

        //Finding the same parent(group) if the sets exists
        for(int idx = 0; idx < queries.length; idx++){
            System.out.println("queries: " + idx + " " + (disjointSetUnion.find(queries[idx][0]) == disjointSetUnion.find(queries[idx][1])));
        }

        System.out.println(disjointSetUnion.disjointSetsLeader);
    }
}
