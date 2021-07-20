package LeetCodeMedium.DisjointAndDFS;

import java.util.*;

public class MostStonesRemovedDisjointSets {

    public static void main(String args[]) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};  //{{0,1} , {1, 0}};//{{0,0},{0,2},{1,1},{2,0},{2,2}};                         //{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println("Number of Stones Removed: " + removeStonesDisjointSets(stones));

    }

    private static int removeStonesDisjointSets(int[][] stones) {
        int len = stones.length;
        if(len == 0)return 0;

        Map<Integer, List<Integer>> rowMaps = new HashMap<>();
        Map<Integer, List<Integer>> colMaps = new HashMap<>();

        Map<Integer, Integer> parentLeader = new HashMap<>();
        int[] ranks = new int[len];
        Arrays.fill(ranks, 0);

        for(int idx = 0; idx < len; idx++){
            ////{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
            int rowStoneNum = stones[idx][0];
            List<Integer> rows = rowMaps.getOrDefault(rowStoneNum, new ArrayList<>());  //List for all 0, 1, 2
            makeSets(parentLeader, idx);    //creating the different groups 0 --> 4
            if(!rows.isEmpty()){
                // 0 --> 0, 0 --> 1,
                //parentLeader: {0=1, 1=1, 2=1, 3=1, 4=1, 5=1}
                //parentLeader: {0=0, 1=0, 2=0, 3=0, 4=0, 5=0} when idx is interchanged
                union(parentLeader, rows.get(rows.size() - 1), idx, ranks);   //Union of previous stones IDXs to the current one
            }
            rows.add(idx);
            rowMaps.put(rowStoneNum, rows);

            int colStoneNum = stones[idx][1];
            List<Integer> cols = colMaps.getOrDefault(colStoneNum, new ArrayList<>());  //List for all 0, 1, 2
            makeSets(parentLeader, idx);    //Not required as it is been already made in rows
            if(!cols.isEmpty()){
                union(parentLeader, cols.get(cols.size() - 1), idx, ranks);     //Union to form parent group of previous col Idx to current col's IDx
            }
            cols.add(idx);
            colMaps.put(colStoneNum, cols);
        }
        System.out.println("parentLeader: " + parentLeader);

        //Checking the groups with not same group
        int groups = 0;
        for(int key : parentLeader.keySet()){
            if(parentLeader.get(key) != key){
                groups++;
            }
        }

        return groups;
    }

    public static void makeSets(Map<Integer, Integer> parentLeader, int val){
        if(!parentLeader.containsKey(val)){
            parentLeader.put(val, val); //Initially all the values are pointed to itself and later parent it assigned
        }
    }

    public static int find(Map<Integer, Integer> parentLeader, int val){
        if(parentLeader.get(val) != val){
            int absParent = find(parentLeader,parentLeader.get(val));
            parentLeader.put(val, absParent);
            //return absParent;
        }
        return parentLeader.get(val);
    }

    public static void union(Map<Integer, Integer> parentLeader, int val1, int val2, int[] rank){
        int leaderOfVal1 = find(parentLeader, val1);
        int leaderOfVal2 = find(parentLeader, val2);

        if(leaderOfVal1 == leaderOfVal2){
            return;
        }

//        if(leaderOfVal1 > leaderOfVal2){
//            parentLeader.put(leaderOfVal2, leaderOfVal1);
//        }else{
//            parentLeader.put(leaderOfVal1, leaderOfVal2);
//            if(rank[leaderOfVal1] == rank[leaderOfVal2]) rank[leaderOfVal2]++;
//        }

        if(rank[leaderOfVal1] > rank[leaderOfVal2]){
            parentLeader.put(leaderOfVal2, leaderOfVal1);
        }else if(rank[leaderOfVal1] < rank[leaderOfVal2]){
            parentLeader.put(leaderOfVal1, leaderOfVal2);
        }else{
            parentLeader.put(leaderOfVal2, leaderOfVal1);
            rank[leaderOfVal1]++;
        }
    }
}
