package LeetCodeMedium;

import java.util.*;

public class KClosestPointsToOrigin {
    public static void main(String[] args)
    {
        int[][] points = {{3,3},{5,-1},{-2,4}};           //{{0,1},{1,0}} ;  //{{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] closetsKPoints = kClosest(points, k);
        //One Important Question in Interview is What if there are less points and greater K and what if the Integer Overflow happens?
    }

    public static class Point{
        int[] point;
        int distance;

        public Point(int[] point, int distance){
            this.distance = distance;
            this.point = point;
        }
    }

    public static int euclienDistance(int[] point){
        return ((point[0] * point[0]) + (point[1] * point[1]));
    }

    public static int[][] kClosest(int[][] points, int k) {
        if(points == null || points.length == 0) return points;

        PriorityQueue<Point> maxHeap = new PriorityQueue<>( (Point p1, Point p2) -> (p2.distance - p1.distance));
//                new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                return o2.distance - o1.distance;
//            }
 //       });

        for(int idx = 0; idx < points.length; idx++){
            int euclienDistance = euclienDistance(points[idx]);
            maxHeap.add(new Point(points[idx], euclienDistance));

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] closestPoints = new int[maxHeap.size()][];
        int i = 0;
        while (maxHeap.size() > 0){
            closestPoints[i++] = maxHeap.poll().point;
        }

        return closestPoints;
    }
}
