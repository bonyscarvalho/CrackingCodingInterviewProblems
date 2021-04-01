package ToughQuestion;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDe {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public void insert(TreeNode node, int value) {
        if (value < node.val) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
//                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new TreeNode(value); } }
        else if (value > node.val) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                // System.out.println("  Inserted " + value + " to right of " + node.value);
                node.right = new TreeNode(value);
            }
        }
    }

    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            System.out.print(" " + node.val);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }

    public static void main(String args[])
    {
        SerializeAndDe tree = new SerializeAndDe();
        TreeNode root = new TreeNode(5);
        //System.out.println("Binary Tree Example");
        //System.out.println("Building tree with root value " + root.val);
        tree.insert(root, 2);
        tree.insert(root, 8);
        tree.insert(root, 6);
        tree.insert(root, 9);
        //System.out.println("Traversing tree in order");
       // tree.traverseInOrder(root);

        String serialBFS = serializeBFS(root);
        System.out.println(serialBFS);

        TreeNode bfsNode = deserializeBFS(serialBFS);
        tree.traverseInOrder(bfsNode);

        String serialDFS = serializeDFS(root);
        System.out.println(serialDFS);
        
        TreeNode dfsNode = deserializeDFS(serialDFS);
        tree.traverseInOrder(dfsNode);


    }

    private static TreeNode deserializeDFS(String serialDFS) {
        if (serialDFS.length() == 0)return null;

        ArrayDeque<String> queue = new ArrayDeque<>();

        for(String node : serialDFS.split(",")) queue.addLast(node);

        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper(ArrayDeque<String> queue) {
        if(queue.isEmpty()) return null;

        TreeNode root = getTrieNodeValue(queue.removeFirst());
        if(root != null){
            root.left = deserializeHelper(queue);
            root.right = deserializeHelper(queue);
        }

        return root;
    }

    private static TreeNode deserializeBFS(String serial) {
        if(serial.length() == 0) return null;

        String[] nodes = serial.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 1;
        TreeNode root = getTrieNodeValue(nodes[0]);
        if(root != null){
            queue.add(root);
        }

        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            curr.left = getTrieNodeValue(nodes[index++]);
            curr.right = getTrieNodeValue(nodes[index++]);

            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }

        return root;
    }

    private static TreeNode getTrieNodeValue(String node) {
        if(node.equals("null") || node.equals(""))return null;

        return new TreeNode(Integer.parseInt(node));
    }

    private static String serializeBFS(TreeNode root) {
        if(root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            sb.append((curr != null ? curr.val : "null") +",");

            if(curr != null){
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private static String serializeDFS(TreeNode root) {
        if(root == null) return "null,";

        String leftSerialized = serializeDFS(root.left);
        String rightSerialized = serializeDFS(root.right);

        return root.val+","+ leftSerialized + rightSerialized;
    }
}
