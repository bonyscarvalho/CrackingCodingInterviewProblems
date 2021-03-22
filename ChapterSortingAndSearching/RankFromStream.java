package ChapterSortingAndSearching;

public class RankFromStream {

    static class Node{
        int value;
        int previousHigh;
        Node left, right;
        public Node(int value){
            this.value = value;
            previousHigh = 0;
            left = null;
            right = null;
        }
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            node.previousHigh++;
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
                node.left.previousHigh = node.previousHigh - 1;
            }
        }
        else{
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.value);
                node.right = new Node(value);
                node.right.previousHigh = node.previousHigh + 1;
            }
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            System.out.println("Node:- Value: " +node.value+" Rank: "+ node.previousHigh);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }


    public static void main(String args[]) {

        RankFromStream tree = new RankFromStream();
        Node root = new Node(5);
        root.previousHigh = 0;
        tree.insert(root, 1);
        tree.insert(root, 4);
        tree.insert(root, 9);
        tree.insert(root, 7);
        tree.insert(root, 10);
        tree.traverseInOrder(root);
        System.out.println("Rank: "+ tree.getRankOfNumber(root, 10));



    }

    private int getRankOfNumber(Node root, int val) {
        if(root.value == val){
            return root.previousHigh;
        }

        if(root.value > val){
            return getRankOfNumber(root.left, val);
        }else {
            return getRankOfNumber(root.right, val);
        }
    }
}
