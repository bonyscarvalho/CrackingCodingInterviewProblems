package TreesAndGraphs;

public class ValidBST {
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
        ValidBST tree = new ValidBST();
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
        tree.traverseInOrder(root);

       // System.out.println("Is Balanced " + checkForValidBST(root) );
        System.out.println("Approach 2 with Range: " + checkIfValidBST(root, null, null));
    }

    //This uses Range approach VERY USEFUL AND IMPORTANT. 
    // left <= ROOT < right which is a Range. 
    // For Left root is MAX and for right ROOT is MIN
    private static Boolean checkIfValidBST(Node root, Integer min, Integer max) {
        if(root == null) return true;

        if((min != null && min >= root.value) || (max != null && root.value > max)) return false;

        if(!checkIfValidBST(root.left, min, root.value) || !checkIfValidBST(root.right, root.value, max)) return false;

        return true;
    }

    private static Boolean checkForValidBST(Node root) {
        if(root == null) return true;

        if(root.left != null){
            if(root.left.value > root.value) return false;
            checkForValidBST(root.left);
        }
        if(root.right != null){
            if(root.right.value < root.value) return false;
            checkForValidBST(root.right);
        }
        return true;
    }
}
