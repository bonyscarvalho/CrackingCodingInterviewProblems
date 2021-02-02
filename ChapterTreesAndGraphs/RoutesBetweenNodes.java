package TreesAndGraphs;

import java.util.*;

public class RoutesBetweenNodes {
   // static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
   // Creating a graph with 5 vertices
   static int V = 7;
    static ArrayList<ArrayList<Integer> > adj
            = new ArrayList<ArrayList<Integer> >(V);

    static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
        //adj.get(v).add(u);    //BiDirectional 
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 2);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 4);
        addEdge(adj, 6, 5);

        System.out.println("Result: "+ BFSCheckPath(4, 6));
    }

    private static Boolean BFSCheckPath(int src, int dest) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        visited.add(src);
        while (!queue.isEmpty()){
            int temp = queue.poll();
            System.out.println("Temp: " + temp);
            if(temp == dest) return true;
            for (int v :adj.get(temp)){
                if(!visited.contains(v)){
                    visited.add(v);
                    queue.add(v);
                }
            }

        }
        return false;
    }
}
