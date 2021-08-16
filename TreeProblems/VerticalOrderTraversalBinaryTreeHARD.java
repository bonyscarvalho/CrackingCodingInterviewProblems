package TreeProblems;

import java.util.*;

//987. Vertical Order Traversal of a Binary Tree
public class VerticalOrderTraversalBinaryTreeHARD {
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

    static  class Point {
        TreeNode root;
        int x;
        int y;
        public Point(TreeNode root, int x, int y) {
            this.root = root;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        //root = [3,9,20,null,null,15,7]

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> verticalTraversal = verticalTraversal(root);
        System.out.println(verticalTraversal);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer, PriorityQueue<Point>> map = new HashMap<>();
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(root, 0, 0));
        Comparator<Point> comparator = (a, b) -> {
            if (a.y == b.y) {
                return a.root.val - b.root.val;
            } else {
                return a.y - b.y;
            }
        };
        int minIdx = 0;
        int maxIdx = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            root = point.root;
            map.putIfAbsent(point.x, new PriorityQueue<>(comparator));
            map.get(point.x).add(point);
            minIdx = Math.min(minIdx, point.x);
            maxIdx = Math.max(maxIdx, point.x);
            if (root.left != null)  queue.offer(new Point(root.left, point.x - 1, point.y + 1));
            if (root.right != null) queue.offer(new Point(root.right, point.x + 1, point.y + 1));
        }

        for (int i = minIdx; i <= maxIdx; i++) {
            PriorityQueue<Point> pq = map.get(i);
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                list.add(pq.poll().root.val);
            }
            res.add(list);
        }

        return res;
    }

}
