package ToughQuestion;

import java.util.ArrayDeque;
import java.util.ArrayList;

//449. Serialize and Deserialize BST
public class SearilizeAndDesearikizeBST {
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
//                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value); } }
        else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
               // System.out.println("  Inserted " + value + " to right of " + node.value);
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
        SearilizeAndDesearikizeBST tree = new SearilizeAndDesearikizeBST();
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
        tree.insert(root, 11);
        tree.insert(root, 12);
        System.out.println("Traversing tree in order");
        //tree.traverseInOrder(root);

//        String serialized = serializeBST(root);
//
//        SearilizeAndDesearikizeBST newTree = new SearilizeAndDesearikizeBST();
//        deserializeBST(serialized, newTree);

        String serializedApproach2 = serialize(root);
        System.out.println(serializedApproach2);

        Node approcah2 = deserialize(serializedApproach2);
        tree.traverseInOrder(approcah2);
        
    }

    private static void deserializeBST(String serialized, SearilizeAndDesearikizeBST newTree) {
        if(serialized.length() == 0) return;
        String[] nodes = serialized.split(",");
        System.out.println("Size: " +nodes.length);
        ArrayList<Integer> intArr = new ArrayList<>();
        for (String n : nodes){
            n = n.trim();
            if(!n.isEmpty()){
                intArr.add(Integer.parseInt(n));
            }
        }
        Node root = new Node(intArr.get(0));
        System.out.println(intArr);
        for(int index = 1; index < intArr.size(); index++){
            newTree.insert(root, intArr.get(index));
        }
        System.out.println("Tree: ");
        newTree.traverseInOrder(root);
    }

    private static String serializeBST(Node root) {
        if(root == null) return "";

        return root.value+", " + serializeBST(root.left) + serializeBST(root.right);
    }


    private static String serialize(Node root){
        return doSerialize(root,new StringBuilder()).toString();
    }

    private static StringBuilder doSerialize(Node root, StringBuilder sb) {
        if(root == null) return sb;

        //PreOrder
        sb.append(root.value).append(" ");
        doSerialize(root.left, sb);
        doSerialize(root.right, sb);
        return sb;
    }

    public static Node deserialize(String data) {
        if(data.length() == 0) return null;
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String s : data.split("\\s+")) queue.addLast(s);

        return deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Node deserializeHelper(ArrayDeque<String> queue, int minValue, int maxValue) {
        if(queue.isEmpty()) return null;

        int firstVal = Integer.parseInt(queue.getFirst());      //for postOrder it will be getLast
        if(firstVal < minValue || firstVal > maxValue) return null;     //Invalid Case for right and left nodes values

        firstVal = Integer.parseInt(queue.removeFirst());       //for PostOrder removeLast
        Node root = new Node(firstVal);
        root.left = deserializeHelper(queue, minValue, firstVal);
        root.right = deserializeHelper(queue, firstVal, maxValue);
        return root;
    }

}
