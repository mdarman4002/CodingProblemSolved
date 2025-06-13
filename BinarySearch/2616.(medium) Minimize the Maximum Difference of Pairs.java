/**
 * The Solution class provides a method to minimize the maximum difference
 * between pairs of integers in an array.
 */
class Solution {
    
    /**
     * This method minimizes the maximum difference between pairs of integers
     * in the given array `nums` such that exactly `p` pairs can be formed.
     *
     * @param nums an array of integers to be paired
     * @param p the number of pairs to form
     * @return the minimized maximum difference between the pairs
     */
    public int minimizeMax(int[] nums, int p) {
        // If no pairs are to be formed, return 0
        if (p == 0) return 0;

        // Sort the array to facilitate pairing
        Arrays.sort(nums);
        int n = nums.length;
        
        // Initialize the binary search bounds
        int left = 0, right = nums[n - 1] - nums[0];
        
        // Perform binary search to find the minimum possible maximum difference
        while (left < right) {
            int mid = left + (right - left) / 2; // Calculate the mid-point
            int pairs = 0; // Count of pairs formed
            
            // Iterate through the sorted array to count pairs
            for (int i = 1; i < n; i++) {
                // Check if the current pair can be formed within the mid difference
                if (nums[i] - nums[i - 1] <= mid) {
                    pairs++; // Increment the pair count
                    i++; // Move to the next element to form the next pair
                }
            }
            
            // Adjust the binary search bounds based on the number of pairs formed
            if (pairs >= p) {
                right = mid; // Try for a smaller maximum difference
            } else {
                left = mid + 1; // Increase the minimum difference
            }
        }
        
        // Return the minimized maximum difference
        return left;
    }
}
