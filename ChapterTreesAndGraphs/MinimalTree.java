package TreesAndGraphs;

public class MinimalTree {
    Node root;

    // Tree Node
    static class Node {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public void inOrder(Node root)
    {
        if (root != null) {
            System.out.println(root.data + " ");
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    public static void main(String args[])
    {
        MinimalTree t2 = new MinimalTree();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        t2.root = t2.insertLevelOrder(arr, t2.root, 0, arr.length - 1 );
        t2.inOrder(t2.root);
    }

    private Node insertLevelOrder(int[] arr, Node root, int left, int right) {
        if(right < left) return null;   //Base Case. You can also have if(left < right which won't allow and return the root as null.

        int mid = (left + right) / 2;
        Node temp = new Node(arr[mid]);
        //System.out.println("TEMP: " + temp.data);
        root = temp;
        root.left = insertLevelOrder(arr, root.left, left, mid - 1);
        root.right = insertLevelOrder(arr, root.right, mid + 1, right);

        return root;
    }
}
