/**
 * This class provides a solution to the problem of finding the minimum cost of connecting ropes.
 */
class Solution {
    /**
     * This function calculates the minimum cost of connecting the ropes.
     * 
     * @param arr an array of long integers representing the lengths of ropes
     * @param n   the number of ropes
     * @return the minimum cost of connecting the ropes
     */
    long minCost(long arr[], int n) {
        // Create a priority queue to store the lengths of ropes
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // Add all the lengths of ropes to the priority queue
        for (long ele : arr) {
            pq.add(ele);
        }

        // Initialize the cost of connecting ropes
        long cost = 0;

        // Continue connecting ropes until only one rope is left
        while (pq.size() > 1) {
            // Remove the two smallest lengths of ropes from the priority queue
            long min1 = pq.remove();
            long min2 = pq.remove();

            // Calculate the cost of connecting the two ropes
            cost += (min1 + min2);

            // Add the new length of rope to the priority queue
            pq.add(min1 + min2);
        }

        // Return the minimum cost of connecting the ropes
        return cost;
    }
}
