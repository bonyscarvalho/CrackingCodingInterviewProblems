import TreesAndGraphs.FirstCommonAncestor;
import TreesAndGraphs.PathWithSum;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElement {

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

            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public static void main(String args[])
    {
        int target = 11;
        KthSmallestElement tree = new KthSmallestElement();
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
//
//        ArrayList<Integer> results = new ArrayList<>();
//        inOrderTraversal(root, results);
//        System.out.println("List: "+results);
//        System.out.println("Get the 3rd Smallest Element: " + results.get(2));

        System.out.println("\nIterative Way for 3rd Smallest: " + iterativeWaytoFind(root));

    }

    private static int iterativeWaytoFind(Node root) {
        int k = 7;
        if(root == null) return -1;

        Stack<Node> stack = new Stack<>();
       while (true){
           while (root != null){
               stack.add(root);
               root = root.left;
           }
           Node lastNode = stack.pop();
           k--;
           if(k == 0)return lastNode.value;
           root = lastNode.right;
       }
    }

    private static void inOrderTraversal(Node root, ArrayList<Integer> results) {
        if(root != null){
            inOrderTraversal(root.left, results);
            results.add(root.value);
            inOrderTraversal(root.right, results);
        }
    }
}
