//package LeetCodeMedium;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CourseScheduleTopologicalSort {
//    //Assign all the values as the global varibales
//    //Status of the Node --> New, Visiting or Visited --> Like Color
//    //Adding a variable for this isCycle = false; --> if the status is Visiting and you come across it in DFS then a Cycle and can't be done
//    //Adj list of node to its pointing nodes. Map<Int, List<I>>
//    //
////
////    static int WHITE = 1;   //NEW
////    static int GRAY = 2;    //Visiting
////    static int BLACK = 3;   //Visited
////
////    static boolean isPossible;
////    static Map<Integer, Integer> color;
////    static Map<Integer, List<Integer>> adjNodeList;
////    static List<Integer> topologicalOrder;
////
////    private void initTopological(int numCourses) {
////        this.adjNodeList = new HashMap<>();
////        this.color = new HashMap<>();
////        this.isPossible = true;
////        this.topologicalOrder = new ArrayList<>();
////
////        for(int idx = 0; idx < numCourses; idx++){
////            color.put(idx, WHITE);
////        }
////    }
//
//    public static void main(String[] args) {
//        int numCourses = 4;
//        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//
//        int[] schedule = findOrder(numCourses, prerequisites);
//    }
//
//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//       // initTopological(numCourses);
//
//        //Creating the node link with adj map
//        for(int idx = 0; idx < prerequisites.length; idx++){
//            int src = prerequisites[idx][1];
//            int dest = prerequisites[idx][0];
//
//            List<Integer> adjList = adjNodeList.getOrDefault(src, new ArrayList<>());
//            adjList.add(dest);
//            adjNodeList.put(src, adjList);
//        }
//
//        //Do DFS on all the WHite nodes
//
//        for(int idx = 0; idx < numCourses; idx++){
//            if(color.get(idx) == WHITE){
//                dfsTopological(idx);
//            }
//        }
//        //Can be a stack too
//        int[] order;
//        if(!isPossible){
//            order = new int[0];
//        }else {
//            order = new int[numCourses];
//            for(int idx = 0; idx < numCourses; idx++){
//                order[idx] = topologicalOrder.get(numCourses - idx - 1);
//            }
//        }
//
//        return order;
//    }
//
//    private void dfsTopological(int idx) {
//        if(!isPossible) return;
//
//        color.put(idx, GRAY);   //Visiting curr Node
//
//        for(int node : adjNodeList.getOrDefault(idx, new ArrayList<>())){
//            if(color.get(node) == WHITE){
//                dfsTopological(node);
//            }else if(color.get(node) == GRAY){
//                isPossible = false;
//            }
//        }
//
//        color.put(idx, BLACK);  //Done Visiting
//        topologicalOrder.add(idx);
//    }
//}
