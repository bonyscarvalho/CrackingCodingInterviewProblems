package LeetCodeMedium.DisjointAndDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostStonesRemovedDFS {

    public static class Pair{
        int row;
        int col;
        Pair(int r, int c){
            row = r;
            col = c;
        }
        public String toString() {
            return row+","+col;
        }
    }

    public static void main(String args[]) {
        int[][] stones =   {{0,0},{0,2},{1,1},{2,0},{2,2}};                         //{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println("Number of Stones Removed: " + removeStones(stones));

    }

    public static int removeStones(int[][] stones) {
        int len = stones.length;
        if(len == 0)return 0;

        Map<String, ArrayList<Pair>> rowColMap = new HashMap<>();
        for(int idx = 0; idx < len; idx++){
            Pair stonePair = new Pair(stones[idx][0], stones[idx][1]);
            //Getting the every Pair and Comparing the ROW with other Rows and Cols with Other pairs col
            //If same then add to the map of their mapped pair
            for(int i = 0; i < len; i++){
                //creating every pairs key -> value list and then going to add all to it
                if((stones[i][0] == stonePair.row) || (stones[i][1] == stonePair.col)){
                    if(! rowColMap.containsKey(stonePair.toString())){  //added to keep the list so that new pair can be added
                        rowColMap.put(stonePair.toString(), new ArrayList<>());
                    }
                    rowColMap.get(stonePair.toString()).add(new Pair(stones[i][0], stones[i][1]));
                }
            }
        }
        //rowColMap: {0,0=[0,0, 0,2, 2,0], 0,2=[0,0, 0,2, 2,2], 1,1=[1,1], 2,0=[0,0, 2,0, 2,2], 2,2=[0,2, 2,0, 2,2]}

        HashSet<String> visited = new HashSet<>();    //for DFS
        int groups = 0;

        for(int idx = 0; idx < len; idx++){
            Pair currPair = new Pair(stones[idx][0], stones[idx][1]);
            if(! visited.contains(currPair.toString())){
                dfs(currPair, visited, rowColMap);
                groups++;
            }
        }

        System.out.println(rowColMap);
        System.out.println("Groups: " +groups);

        return len - groups;
    }

    private static void dfs(Pair currPair, HashSet<String> visited, Map<String, ArrayList<Pair>> rowColMap) {
        if(visited.contains(currPair.toString())){
            return;
        }

        visited.add(currPair.toString());

        for(Pair neighbors : rowColMap.get(currPair.toString())){
            if(!visited.contains(neighbors)){
                dfs(neighbors, visited, rowColMap);
            }
        }
    }
}
