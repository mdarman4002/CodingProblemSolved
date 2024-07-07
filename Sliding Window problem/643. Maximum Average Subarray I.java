/**
 * Solution class for finding the maximum average of any contiguous subarray of size k.
 */
class Solution {
    /**
     * Finds the maximum average of any contiguous subarray of size k.
     *
     * @param nums The input array of integers.
     * @param k The size of the contiguous subarray.
     * @return The maximum average of any contiguous subarray of size k.
     */
    public double findMaxAverage(int[] nums, int k) {
        int numslen = nums.length;
        
        // Handle edge cases where the input is invalid
        if (numslen == 0 || k == 0) return 0.0;

        // Initialize sum with the sum of the first 'k' elements
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Initialize max with the average of the first 'k' elements
        double max = (double) sum / k;

        // Use sliding window to calculate the maximum average
        for (int i = k; i < numslen; i++) {
            // Update sum to reflect the sliding window (subtract the element going out and add the element coming in)
            sum = sum - nums[i - k] + nums[i];
            // Update max if the new average is higher
            max = Math.max(max, (double) sum / k);
        }

        // Return the maximum average found
        return max;
    }
}
