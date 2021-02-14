package TreesAndGraphs;

import java.util.Random;

class TreeNode{
    private int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int d){
        data = d;
        size = 1;
    }

    public TreeNode getRandomNode(){
        int leftSize = left == null ? 0 : left.size();
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        if(randomIndex < leftSize){
            return left.getRandomNode();
        }else if(randomIndex == leftSize){
            return this;
        }else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d){
        if(d <= data){
            if(left == null){
                left = new TreeNode(d);
            }else {
                left.insertInOrder(d);
            }
        }else {
            if(right == null){
                right = new TreeNode(d);
            }else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public TreeNode find(int d){
        if(data == d){
            return this;
        }else if(d <= data){
            return left != null ? left.find(d) : null;
        }else if(d > data){
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    public TreeNode getRandomNodeLeftSize(){
        // if(root == null) return null;

        Random random = new Random();
        int randomIndex = random.nextInt(size());
        return getRandomIndexNode(randomIndex);
    }

    public  TreeNode getRandomIndexNode(int index){
        int leftSize = left == null ? 0 : left.size();
        if(index < leftSize){
            return left.getRandomIndexNode(index);
        }else if( index == leftSize){
            return this;
        }else{
            return right.getRandomIndexNode(index - (leftSize + 1));
        }
    }

    public int size(){
        return size;
    }
    public  int data(){
        return data;
    }
}

public class RandomNode {
    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(20);
        treeNode.insertInOrder(30);
        treeNode.insertInOrder(10);

        //System.out.println("Get Random Node data: " + treeNode.getRandomNode().data());

        System.out.println("Right Shit: "+ Integer.toBinaryString(1 << 2));
    }
}
