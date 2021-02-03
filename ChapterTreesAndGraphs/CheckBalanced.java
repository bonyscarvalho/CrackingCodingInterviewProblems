package TreesAndGraphs;

import ChapterLinkedList.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class CheckBalanced {
    static class WrapperForHeight{
        boolean isBalanced;
        int size;

        public WrapperForHeight(boolean b, int s) {
            isBalanced = b;
            size = s;
        }
    }

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
        CheckBalanced tree = new CheckBalanced();
        Node root = new Node(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        tree.insert(root, 2);
        //tree.insert(root, 4);
       tree.insert(root, 8);
//        tree.insert(root, 6);
        tree.insert(root, 7);
//        tree.insert(root, 3);
        tree.insert(root, 9);
       tree.insert(root, 11);
        tree.insert(root, 12);
        System.out.println("Traversing tree in order");
        tree.traverseInOrder(root);

        int height = computeHeight(null);
        System.out.println("Is Balanced " + (height != Integer.MIN_VALUE));
    }

    private static int computeHeight(Node root) {
        if(root == null)return -1;

        int left = computeHeight(root.left);
        if(left == Integer.MIN_VALUE) return Integer.MIN_VALUE; //Error Send Above

        int right = computeHeight(root.right);
        if(right == Integer.MIN_VALUE) return Integer.MIN_VALUE;    //Error

        if(Math.abs(left - right) > 1){
            return Integer.MIN_VALUE;   //Compute and send Error Above
        }
        return Math.max(left, right) + 1;
    }

}
