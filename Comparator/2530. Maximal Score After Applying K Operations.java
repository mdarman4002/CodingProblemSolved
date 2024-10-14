import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        // Create a max heap to store the elements as Long
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        // Add all elements from the input array to the max heap
        for (int ele : nums) {
            maxHeap.offer((long) ele);
        }
        
        long sum = 0; // Variable to store the sum of the k largest elements

        // Loop to process k elements
        while (k > 0) {
            // Extract the largest element from the heap
            long maxele = maxHeap.poll();
            sum += maxele; // Add the extracted element to the sum

            // Update the extracted element based on its value
            if (maxele % 3 != 0) {
                // If maxele is not divisible by 3, add (maxele / 3) + 1 back to the heap
                long updated = (maxele / 3L) + 1;
                maxHeap.offer(updated);
            } else {
                // If maxele is divisible by 3, add (maxele / 3) back to the heap
                long updated = (maxele / 3L);
                maxHeap.offer(updated);
            }
            
            k--; // Decrement the count of elements to process
        }
        
        return sum; // Return the total sum of the k largest elements
    }
}
