class Solution {
    /**
     * Finds the length of the longest subarray with the maximum frequency value.
     * 
     * @param nums an array of integers
     * @return an integer representing the length of the longest subarray with the maximum frequency value
     */
    public int longestSubarray(int[] nums) {
        // Initialize maxValue to 0 (or Integer.MIN_VALUE for a more robust approach)
        int maxValue = 0; // Integer.MIN_VALUE;
        
        // Find the maximum value in the array
        for (int val : nums) {
            maxValue = Math.max(val, maxValue);
        }

        // Initialize frequency counters
        int currMaxFreq = 0; // current maximum frequency
        int storedMaxFreq = 0; // stored maximum frequency

        // Iterate through the array to find the longest subarray
        for (int curValue : nums) {
            if (curValue == maxValue) {
                // If the current value matches the maximum value, increment currMaxFreq
                currMaxFreq++;
            } else {
                // Otherwise, update storedMaxFreq and reset currMaxFreq
                storedMaxFreq = Math.max(storedMaxFreq, currMaxFreq);
                currMaxFreq = 0;
            }
        }
        
        // Update stored maximum frequency one last time
        storedMaxFreq = Math.max(storedMaxFreq, currMaxFreq);
        
        // Return the longest subarray length
        return storedMaxFreq;
    }
}
