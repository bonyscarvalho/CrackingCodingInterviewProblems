package TreeProblems;
//654. Maximum Binary Tree
public class MaximumBinaryTree {
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
        int[] nums = {3,2,1,6,0,5};

        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println(treeNode.val);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums, int leftIdx, int rightIdx) {
        System.out.println("leftIdx: " + leftIdx +" rightIdx: " + rightIdx);
        if(leftIdx == rightIdx){
             TreeNode sub = new TreeNode(nums[rightIdx]);
             return sub;
            //return null;
        }
        //leftIdx > rightIdx V. Imp as it can cause stack overflow error
        //|| leftIdx < 0 || rightIdx < 0 || leftIdx >= nums.length || rightIdx >= nums.length
        //You don't require above condition with the below one
        if(leftIdx > rightIdx ) return null;


        int maxIdx = findMaxIdx(nums, leftIdx, rightIdx);

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = constructMaximumBinaryTree(nums, leftIdx, maxIdx - 1);
        root.right = constructMaximumBinaryTree(nums, maxIdx + 1, rightIdx);

        return root;
    }


    public static int findMaxIdx(int[] nums, int leftIdx, int rightIdx){
        int maxIdx = leftIdx;

        for(int idx = leftIdx; idx <= rightIdx; idx++){
            if(nums[idx] > nums[maxIdx]){
                maxIdx = idx;
            }
        }

        return maxIdx;
    }

}
