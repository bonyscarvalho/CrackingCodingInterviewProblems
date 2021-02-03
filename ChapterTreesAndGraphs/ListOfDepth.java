package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ListOfDepth {
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
        if (value < node.value) { if (node.left != null) { insert(node.left, value); } else { System.out.println(" Inserted " + value + " to left of " + node.value); node.left = new Node(value); } } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.value);
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
        ListOfDepth tree = new ListOfDepth();
        Node root = new Node(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 8);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 9);
        System.out.println("Traversing tree in order");
        tree.traverseInOrder(root);

        ArrayList<LinkedList<Integer>> listOfDepths = new ArrayList<>();

        computeLinkedListOfDepths(root, listOfDepths,0);

        System.out.println("List Print: " + listOfDepths);

        ArrayList<LinkedList<Node>> result = createLevelLinkedList(root);

        System.out.println("Iterative way Print: " + result);

    }

    //Iterative Approoach Same as Recursive SOlution for ST O(n)
    private static ArrayList<LinkedList<Node>> createLevelLinkedList(Node root){
        if (root == null) return null;
        ArrayList<LinkedList<Node>> results = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        current.add(root);

        while (current.size() > 0){
            results.add(current);   //previous Level
            LinkedList<Node> parents = current; //Now they are parents
            current = new LinkedList<Node>();
            for(Node parent : parents){
                if(parent.left != null){
                    current.add(parent.left);
                }
                if (parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return results;
    }

    //Instead of having Map of Depth and linkedList you can have ArrayList
    //In which if the ArrayList size is same as the depth then you create new LinkedList
    //As we start from 0 and increase the depth by 1 level by level
    private static void computeLinkedListOfDepths(Node root, ArrayList<LinkedList<Integer>> listOfDepths,int depth) {
        if(root == null) return;

        LinkedList<Integer> temp = null;
        if(listOfDepths.size() == depth){
            temp = new LinkedList<>();
            listOfDepths.add(temp);
        }else{
            temp = listOfDepths.get(depth);
        }
        temp.add(root.value);

        computeLinkedListOfDepths(root.left, listOfDepths,depth + 1);
        computeLinkedListOfDepths(root.right, listOfDepths,depth + 1);
    }


}
