package SortingAlgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    // static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
    // Creating a graph with 5 vertices
    static int V = 8;
    static ArrayList<ArrayList<Integer>> adj
            = new ArrayList<ArrayList<Integer> >(V);

    static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
        //adj.get(v).add(u);    //BiDirectional
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 1; i <= adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 1; j <= adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        for (int i = 1; i <= V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 3);
        addEdge(adj, 3, 7);
        addEdge(adj, 7, 0);

        //printGraph(adj);
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> orderFlow = new Stack<>();

        for(int vertex = 0; vertex < adj.size(); vertex++){
            if(!visited.contains(vertex)){
                topSortUtil(vertex, visited, orderFlow);;
            }
        }

        System.out.print("Order FLow: " );
        while (!orderFlow.isEmpty()){
            System.out.print(" " + orderFlow.pop());
        }

    }

    private static void topSortUtil(Integer vertex, Set<Integer> visited, Stack<Integer> orderFlow) {
        visited.add(vertex);
        System.out.println("Vertex: " + vertex);

        for (Integer child : adj.get(vertex)){
            if(visited.contains(child)){
                continue;
            }
            topSortUtil(child,visited,orderFlow);
        }
        orderFlow.push(vertex);
    }
}
