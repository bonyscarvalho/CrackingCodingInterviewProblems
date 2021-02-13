package TreesAndGraphs;

public class FirstCommonAncestor {
    static class Node {
        double value;
        Node left, right;

        Node(double value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(Node node, double value) {
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

    public static void main(String args[]) {
        double p = 6.0;
        double q = 7.0;
        FirstCommonAncestor tree = new FirstCommonAncestor();
        Node root = new Node(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 6);
        tree.insert(root, 5.5);
        tree.insert(root, 8);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 9);
        tree.insert(root, 1);
        System.out.println("Traversing tree in order");
        tree.traverseInOrder(root);

        Node ancestor = binarySearchTreeAncestorSearch(root,p, q);

        //Node ancestor = findFirstCommonAncestorWithOutLink(root,p, q);

        //int ancestor = findFirstCommonAncestor(root,p, q);
        System.out.println("First Common Ancestor of "+p+" and "+q+" is " + ancestor.value);

    }

    private static Node findFirstCommonAncestorWithOutLink(Node root, double p, double q) {
        if(root == null) return null;
        System.out.println("Root: "+ root.value);
        if (root.value == p && root.value == q) return root;

        Node x = findFirstCommonAncestorWithOutLink(root.left, p, q);
//        if(x != null && x.value != p && x.value != q){
//            System.out.println("X: "+ x.value);
//            return x;
//        }

        Node y = findFirstCommonAncestorWithOutLink(root.right, p, q);
//        if(y != null && y.value != p && y.value != q){
//            System.out.println("Y: "+ y.value);
//            return y;
//        }
        System.out.println("Before : " + (x != null ? x.value : "X is Empty") + " Before: " + (y != null ? y.value : "Y is Empty"));

        if(x != null && y != null){
            System.out.println("Not Null: "+ root.value);
            return root;
        }else if(root.value == q || root.value == p){
            System.out.println("OR: "+  root.value);
            return root;
        }else {
            System.out.println("Null : " + (x != null ? x.value : "X is Empty") + " NULL: " + (y != null ? y.value : "Y is Empty"));
            return x == null ? y : x;
        }
    }

    private static double findFirstCommonAncestor(Node root, int p, int q) {
        if(!coversInTree(root, p) || !coversInTree(root, q)){
            return Integer.MIN_VALUE;
        }
        return findFirstCommonAncestorHelper(root, p, q);
    }

    private static double findFirstCommonAncestorHelper(Node root, int p, int q) {
        if(root == null || root.value == p || root.value == q){
            return 999;
        }
        boolean pIsOnLeft = coversInTree(root.left, p);
        boolean qIsOnLeft = coversInTree(root.left, q);

        if(pIsOnLeft != qIsOnLeft) return root.value;       // as both are not same they are on different side so root is their ancestor

        Node childNode = pIsOnLeft ? root.left : root.right;
        System.out.println("ChildNode: " +childNode.value);

        return findFirstCommonAncestorHelper(childNode, p, q);

    }

    //Important Method to check if nodes is been covered by the subtree or nodes
    private static boolean coversInTree(Node root, int p) {
        if(root == null) return false;
        if(root.value == p) return true;

        return coversInTree(root.left,p) || coversInTree(root.right, p);

    }

    private static Node binarySearchTreeAncestorSearch(Node root, double p, double q){
        if(root == null) return null;

        if(root.value > p && root.value > q){
            return binarySearchTreeAncestorSearch(root.left, p, q);
        }
        if(root.value < p && root.value < q){
            return binarySearchTreeAncestorSearch(root.right, p, q);
        }
        return root;
    }
}
