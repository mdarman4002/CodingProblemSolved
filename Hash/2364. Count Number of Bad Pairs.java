import java.util.HashMap;

/**
 * The Solution class provides a method to count the number of bad pairs in an array.
 * A bad pair is defined as a pair of indices (i, j) such that i < j and nums[i] - i != nums[j] - j.
 */
class Solution {
    
    /**
     * Counts the number of bad pairs in the given array.
     *
     * @param nums An array of integers.
     * @return The number of bad pairs in the array.
     */
    public long countBadPairs(int[] nums) {
        long n = nums.length; // Length of the input array
        long total = n * (n - 1) / 2; // Total number of pairs (i, j) where i < j
        long goodpair = 0; // Count of good pairs
        HashMap<Long, Long> map = new HashMap<>(); // Map to count occurrences of (i - nums[i])

        // Iterate through the array to calculate good pairs
        for (int i = 0; i < n; i++) {
            long val = i - (long) nums[i]; // Calculate the value as i - nums[i]
            long prevPair = map.getOrDefault(val, 0L); // Get the count of previous pairs for this value
            goodpair += prevPair; // Add the count of good pairs
            map.put(val, prevPair + 1); // Update the count in the map
            
            // Alternative way to update the count in the map (commented out)
            // map.put(val, map.getOrDefault(val, 0L) + 1);
        }
        
        return total - goodpair; // Return the count of bad pairs
    }
}

/**
 * Example usage:
 * Solution solution = new Solution();
 * int[] nums = {1, 2, 3, 4};
 * long badPairsCount = solution.countBadPairs(nums);
 */
