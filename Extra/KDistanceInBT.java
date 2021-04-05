package Extra;

import java.util.*;

//863. All Nodes Distance K in Binary Tree
public class KDistanceInBT {
    static Map<TreeNode,TreeNode> parent = new HashMap<>();

    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(TreeNode node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
//                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new TreeNode(value); } }
        else if (value > node.value) {
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
            System.out.print(" " + node.value);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }

    public static void main(String args[])
    {
        KDistanceInBT tree = new KDistanceInBT();
        TreeNode root = new TreeNode(5);
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

        parentReference(root, null);    //Added Parent to MAP
        System.out.println(parent);

        List<Integer> kDistNode = computeKDistanceNodes(root, 2);
        System.out.println(kDistNode);

    }

    private static List<Integer> computeKDistanceNodes(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.add(root);
        visited.add(root);

        int level = 0;

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i <size; i++){
                if(level == k){
                    for (TreeNode n : queue){
                        result.add(n.value);
                    }
                    return result;
                }
                TreeNode curr = queue.poll();
                visited.add(curr);
                if(curr.left != null && !visited.contains(curr.left)){
                    queue.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    queue.add(curr.right);
                    visited.add(curr.right);
                }
                if(parent.get(curr) != null && !visited.contains(parent.get(curr))){
                    queue.add(parent.get(curr));
                    visited.add(parent.get(curr));
                }

            }

            level++;
        }
        return new ArrayList<>();
    }

    private static void parentReference(TreeNode child, TreeNode par) {
        if(child != null){
            parent.put(child, par);
            parentReference(child.left, child);
            parentReference(child.right, child);
        }
    }
}
