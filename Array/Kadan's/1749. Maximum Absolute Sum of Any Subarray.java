/**
 * The Solution class provides a method to calculate the maximum absolute sum
 * of a contiguous subarray from a given integer array.
 */
class Solution {
    
    /**
     * Calculates the maximum absolute sum of a contiguous subarray.
     * 
     * This method uses Kadane's algorithm to find both the maximum sum
     * and the minimum sum of contiguous subarrays. The maximum absolute sum
     * is then determined by taking the maximum of the absolute value of the
     * minimum sum and the maximum sum.
     *
     * @param nums an array of integers
     * @return the maximum absolute sum of any contiguous subarray
     */
    public int maxAbsoluteSum(int[] nums) {
        // Initialize variables for maximum subarray sum
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        // Calculate the maximum subarray sum using Kadane's algorithm
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        // Initialize variables for minimum subarray sum
        int minEnding = nums[0];
        int minSoFar_ = nums[0];

        // Calculate the minimum subarray sum using a similar approach
        for (int i = 1; i < nums.length; i++) {
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSoFar_ = Math.min(minSoFar_, minEnding);
        }

        // Return the maximum of the absolute minimum sum and the maximum sum
        return Math.max(Math.abs(minSoFar_), maxSoFar);
    }
}
