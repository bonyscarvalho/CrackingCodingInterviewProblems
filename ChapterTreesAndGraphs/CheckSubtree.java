package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class CheckSubtree {
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
               // System.out.println(" Inserted " + value + " to left of " + node.value);
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
        CheckSubtree tree = new CheckSubtree();
        Node t1 = new Node(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + t1.value);
        tree.insert(t1, 1);
        tree.insert(t1, 9);
       // tree.insert(t1, 8);
        //tree.insert(t1, 6);
        //tree.insert(t1, 7);
        tree.insert(t1, 3);
        tree.insert(t1, 9);
        tree.insert(t1, 11);
        tree.insert(t1, 12);
        System.out.println("Traversing t1");
        tree.traverseInOrder(t1);

        Node t2 = new Node(9);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + t2.value);
        tree.insert(t2, 11);
        tree.insert(t2, 12);
        System.out.println("Traversing t2");
        tree.traverseInOrder(t2);

        System.out.println("SubTree of Tree is: " + checkSubTree(t1, t2));

    }

    private static Boolean checkSubTree(Node t1, Node t2) {
        if(t2 == null){
            return true;
        }
        return subTreeSearch(t1, t2);
    }

    private static Boolean subTreeSearch(Node t1, Node t2){
        if(t1 == null){
            return false;
        }else if((t1.value == t2.value) && matchSubTree(t1, t2)){
            System.out.println("Matched Value "+ t1.value);
            return true;
        }
        return subTreeSearch(t1.left, t2) || subTreeSearch(t1.right, t2);
    }


    private static Boolean matchSubTree(Node t1, Node t2) {
        if(t1 == null && t2 == null){
            return true;
        }else if(t1 == null || t2 == null || t1.value != t2.value){
            return false;
        }else{
            System.out.println("t2 Value" + t2.value);
            return matchSubTree(t1.left, t2.left) && matchSubTree(t1.right, t2.right);
        }
    }
}
