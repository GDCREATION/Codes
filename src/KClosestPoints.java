import java.util.PriorityQueue;
import java.util.Queue;
/**Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in). */
public class KClosestPoints {
        public int[][] kClosest(int[][] points, int k) {
            // Use a lambda comparator to sort the PQ by farthest distance
            Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (int i = 0; i < points.length; i++) {
                int[] entry = {squaredDistance(points[i]), i};
                if (maxPQ.size() < k) {
                    // Fill the max PQ up to k points
                    maxPQ.add(entry);
                } else if (entry[0] < maxPQ.peek()[0]) {
                    // If the max PQ is full and a closer point is found,
                    // discard the farthest point and add this one
                    maxPQ.poll();
                    maxPQ.add(entry);
                }
            }
            
            // Return all points stored in the max PQ
            int[][] answer = new int[k][2];
            for (int i = 0; i < k; i++) {
                int entryIndex = maxPQ.poll()[1];
                answer[i] = points[entryIndex];
            }
            return answer;
        }
        
        private int squaredDistance(int[] point) {
            // Calculate and return the squared Euclidean distance
            return point[0] * point[0] + point[1] * point[1];
        }
    }
