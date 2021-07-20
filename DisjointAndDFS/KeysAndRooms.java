package LeetCodeMedium.DisjointAndDFS;

import java.util.*;

//841. Keys and Rooms
//Disjoint won't work here as this is a directed graph and not undirected
//[[1],[],[0,3],[1]] here, we can go from 2 -> 0 but there is no way from 0 -> 2 so this will be false
public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() == 0) return true;

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            Integer currRoom = queue.remove();

            for(int room : rooms.get(currRoom)){
                if(!visited.contains(room)){
                    visited.add(room);
                    queue.add(room);
                }
            }
        }

        return visited.size() == rooms.size();
    }

    public static void main(String args[]) {
        int[][] valid = {{1},{2},{3},{}};
        List<List<Integer>> validRooms = new ArrayList<List<Integer>>();
        for(int[] num: valid){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int n : num){
                temp.add(n);
            }
            validRooms.add(temp);
        }
        int[][] invalid = {{1,3},{3,0,1},{2},{0}};
        List<List<Integer>> inValidRooms = new ArrayList<List<Integer>>();
        for(int[] num: invalid){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int n : num){
                temp.add(n);
            }
            inValidRooms.add(temp);
        }


        System.out.println("Is Room Reachable: " +canVisitAllRooms(validRooms));
        System.out.println("Is Room Reachable: " +canVisitAllRooms(inValidRooms));
    }
}
