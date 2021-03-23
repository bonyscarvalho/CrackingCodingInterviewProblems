import TreesAndGraphs.CheckBalanced;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {
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
        BSTSequence tree = new BSTSequence();
        Node root = new Node(5);
        tree.insert(root, 2);
        tree.insert(root, 8);

        ArrayList<LinkedList<Integer>> bstSequence = computeBSTSequence(root);
        System.out.println("Results: " + bstSequence);
    }

    private static ArrayList<LinkedList<Integer>> computeBSTSequence(Node root) {
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();

        if(root == null) {
            results.add(new LinkedList<>());
            return results;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.value);

        ArrayList<LinkedList<Integer>> leftSeq = computeBSTSequence(root.left);
        ArrayList<LinkedList<Integer>> rightSeq = computeBSTSequence(root.right);

        for(LinkedList<Integer> left : leftSeq){
            for(LinkedList<Integer> right : rightSeq){
                ArrayList<LinkedList<Integer>> branchPerm = new ArrayList<>();
                weavingListOfBranch(left, right, prefix, branchPerm);
                results.addAll(branchPerm);
            }
        }
        return results;
    }

    private static void weavingListOfBranch(LinkedList<Integer> left, LinkedList<Integer> right, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> branchPerm) {
        if(left.size() == 0 || right.size() == 0){
            LinkedList<Integer> temp = (LinkedList<Integer>) prefix.clone();
            temp.addAll(left);
            temp.addAll(right);
            branchPerm.add(temp);
            return;
        }

        int leftHead = left.removeFirst();
        prefix.addLast(leftHead);
        weavingListOfBranch(left,right,prefix,branchPerm);
        prefix.removeLast();
        left.addFirst(leftHead);

        int rightHead = right.removeFirst();
        prefix.addLast(rightHead);
        weavingListOfBranch(left,right,prefix,branchPerm);
        prefix.removeLast();
        right.addFirst(rightHead);
    }
}
