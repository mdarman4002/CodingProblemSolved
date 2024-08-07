import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a priority queue to store points based on their distance from the origin
        PriorityQueue<Points> queue = new PriorityQueue<>();
        
        // Iterate over each point
        for (int[] point : points) {
            // Calculate the square of the distance from the origin
            int square = point[0] * point[0] + point[1] * point[1];
            
            // Create a Points object and add it to the queue
            queue.add(new Points(point[0], point[1], square));
        }
        
        // Create a result array to store the k closest points
        int[][] result = new int[k][2];
        
        // Dequeue the k closest points and add them to the result array
        for (int i = 0; i < k; i++) {
            Points point = queue.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        
        return result;
    }
    
    public class Points implements Comparable<Points>{
        int x; 
        int y; 
        int square;
        
        Points(int x, int y, int square){
            this.x = x;
            this.y = y;
            this.square = square;
        }
        
        @Override
        public int compareTo(Points p2){
            return this.square - p2.square;
        }
    }
}
