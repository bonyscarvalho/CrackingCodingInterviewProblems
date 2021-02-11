package TreesAndGraphs;

import java.util.*;

public class PathWithSum {

    static class Node {
        int value;
        Node left, right;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
            //System.out.println(" Inserted " + value + " to left of " + node.value);
            node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                //System.out.println("  Inserted " + value + " to right of " + node.value);
                node.right = new Node(value);
            }
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }

    public static void main(String args[])
    {
        int target = 11;
        PathWithSum tree = new PathWithSum();
        Node root = new Node(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 6);
        tree.insert(root, 8);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 9);
        tree.insert(root, 1);
        System.out.println("Traversing tree in order");
        tree.traverseInOrder(root);

        int totalPaths = getThePaths(root, target);
        System.out.println("Total Paths: "+ totalPaths);

//        List<LinkedList<Integer>> results = new ArrayList<>();
//
//        createListOfNodes(root, target, results);
//
//        System.out.println("List: "+results);

    }

    private static int getThePaths(Node root, int target) {
        if(root == null) return 0;

        return getThePathsWithTheSums(root, target, 0, new HashMap<Integer, Integer>());
    }

    private static int getThePathsWithTheSums(Node root, int target, int runningSum, HashMap<Integer, Integer> pathSumCount) {
        if(root == null) return 0;

        runningSum += root.value;
        int totalPaths = pathSumCount.getOrDefault(runningSum - target, 0);

        if(target == runningSum) totalPaths++;


        insertInHashMap(pathSumCount, runningSum, 1);
        totalPaths += getThePathsWithTheSums(root.left, target, runningSum, pathSumCount);
        totalPaths += getThePathsWithTheSums(root.right, target, runningSum, pathSumCount);
        insertInHashMap(pathSumCount, runningSum, -1);

        return totalPaths;

    }

    private static void insertInHashMap(HashMap<Integer, Integer> pathSumCount, int runningSum, int delta) {
        int value = pathSumCount.getOrDefault(runningSum, 0) + delta;

        if(value == 0){
            pathSumCount.remove(runningSum);
        }else {
            pathSumCount.put(runningSum, value);
        }

    }

    //Code to Print all the Paths
    private static List<LinkedList<Integer>> createListOfNodes(Node root, int target, List<LinkedList<Integer>> results) {
        if(root == null)return null;

        computeListOfTargets(root, target, new LinkedList<Integer>(),  results);

        if(root.left != null) createListOfNodes(root.left,target,results);

        if(root.right != null) createListOfNodes(root.right,target,results);

        return results;
    }

    private static List<LinkedList<Integer>> computeListOfTargets(Node root, int target, LinkedList<Integer> currList, List<LinkedList<Integer>> results) {
        if(root == null && target != 0) return results;
        if(root == null)return results;

        target = target - root.value;
        currList.addLast(root.value);
        if(target == 0){
            results.add(currList);
            currList = new LinkedList<>();
            System.out.println("Curr Result List: " +results);
            //return results;
        }

        if(root.left != null) computeListOfTargets(root.left, target, new LinkedList<>(currList), results);

        if(root.right != null) computeListOfTargets(root.right, target, new LinkedList<>(currList), results);

        return results;
    }

}
