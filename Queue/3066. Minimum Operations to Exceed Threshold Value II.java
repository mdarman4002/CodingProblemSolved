import java.util.PriorityQueue;

/**
 * Solution class to find the minimum number of operations required
 * to ensure all elements in the array are greater than or equal to a given threshold k.
 */
class Solution {
    
    /**
     * This method calculates the minimum number of operations needed
     * to make all elements in the nums array greater than or equal to k.
     * 
     * In each operation, the two smallest integers x and y are removed from nums,
     * and a new integer, calculated as min(x, y) * 2 + max(x, y), is added back to the array.
     * 
     * @param nums An array of integers representing the initial values.
     * @param k An integer representing the threshold value.
     * @return The minimum number of operations required to ensure all elements are >= k.
     */
    public int minOperations(int[] nums, int k) {
        // Create a priority queue (min-heap) to store elements less than k
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add all elements less than k to the priority queue
        for (int num : nums) {
            if (num < k) {
                pq.add(num);
            }
        }

        int operations = 0; // Counter for the number of operations

        // While there are elements in the priority queue
        while (!pq.isEmpty()) {
            // Poll the smallest element from the queue
            int x = pq.poll();
            operations++; // Increment the operation count

            // If the queue is empty after polling x, break the loop
            if (pq.isEmpty()) break;

            // Poll the next smallest element
            int y = pq.poll();
            // Calculate the new value to be added back to the queue
            long newValue = 2L * x + y;

            // If the new value is still less than k, add it back to the queue
            if (newValue < k) {
                pq.add((int) newValue);
            }
        }

        // Return the total number of operations performed
        return operations;
    }
}
