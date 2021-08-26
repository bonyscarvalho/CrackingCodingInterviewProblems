package TreeProblems;
import java.util.*;
//257. Binary Tree Paths
public class BinaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        //root = [3,9,20,null,null,15,7]

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<String> nodesPaths = binaryTreePaths(root);
        System.out.println(nodesPaths);
    }

    public  static List<String> paths = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return paths;

        StringBuilder currPath = new StringBuilder();
        binaryTreePathsHelper(root, currPath);

        return paths;
    }

    public static void binaryTreePathsHelper(TreeNode root, StringBuilder currPath){
        if(root == null)return;
        currPath.append(root.val);

        if(root.left == null && root.right == null){
            //String curr = new String(currPath.toString() + root.val);
            paths.add(currPath.toString());
            return;
        }
        currPath.append("->");
        String rightSide = currPath.toString();

        if(root.left != null){
            binaryTreePathsHelper(root.left, currPath);
        }

        if(root.right != null){
            binaryTreePathsHelper(root.right, new StringBuilder(rightSide));
        }

    }
}
