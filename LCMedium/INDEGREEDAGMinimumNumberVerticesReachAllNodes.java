package LeetCodeMedium;

import java.util.*;

//1557. Minimum Number of Vertices to Reach All Nodes
public class INDEGREEDAGMinimumNumberVerticesReachAllNodes {
    public static void main(String[] args) {
        int n = 6;
        //[[0,1],[0,2],[2,5],[3,4],[4,2]]
        List<Integer> edge1 = Arrays.asList(0, 1), edge2 = Arrays.asList(0, 2), edge3 = Arrays.asList(2, 5),
                edge4 = Arrays.asList(3, 4), edge5 = Arrays.asList(4, 2);
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(edge1);edges.add(edge2);edges.add(edge3);edges.add(edge4);edges.add(edge5);

        System.out.println(findSmallestSetOfVerticesDFS(n, edges));
        System.out.println(findSmallestSetOfVertices(n, edges));
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        if(n == 0) return new ArrayList<>();
        //The idea is since it is DAG and connected graph, so every node having indegree
        // greater than 0 can be reached from any other vertex, and
        // that any other vertex is a part of our connected graph hence that any other vertex can also be reached.
        //So, all nodes having indegee 0 is a part of our answer, from where every other node can be reached.


        int[] inDegreeGraph = new int[n];

        for(List<Integer> currList : edges){
            inDegreeGraph[currList.get(1)]++;
        }

        List<Integer> results = new ArrayList<>();

        for(int idx = 0; idx < n; idx++){
            if(inDegreeGraph[idx] == 0){
                results.add(idx);
            }
        }

        return results;
    }
    public static List<Integer> findSmallestSetOfVerticesDFS(int n, List<List<Integer>> edges) {
        List<List<Integer>> adjList = new ArrayList<>();
         for(int idx = 0; idx < n; idx++){
             adjList.add(new ArrayList<>());
         }

         for(List<Integer> currList : edges){
             int src = currList.get(0);
             int dest = currList.get(1);
             adjList.get(src).add(dest);
         }

         List<Integer> results = new ArrayList<>();
         Set<Integer> visited = new HashSet<>();

         for(int idx = 0; idx < n; idx++){
             List<Integer> currList = adjList.get(idx);

             if(!visited.contains(idx)){
                 for(Integer num : currList){
                     dfs(adjList, num, visited);
                 }
             }
         }

         for(int idx = 0; idx < n; idx++){
             if(!visited.contains(idx)){
                 results.add(idx);
             }
         }

         return results;
    }

     public static void dfs(List<List<Integer>> adjList, int num, Set<Integer> visited){
         if(visited.contains(num)) return;

         visited.add(num);

         List<Integer> currList = adjList.get(num);

         for(Integer currNum : currList){
             if(!visited.contains(currNum)){
                 dfs(adjList, currNum, visited);
             }
         }
     }
}
