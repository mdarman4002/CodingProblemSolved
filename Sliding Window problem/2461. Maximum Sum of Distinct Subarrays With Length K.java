import java.util.HashMap;
import java.util.Map;

/**
 * Solution class provides a method to find the maximum sum of a subarray
 * of length k in an array of integers where all elements in the subarray are distinct.
 */
class Solution {

    /**
     * This method finds the maximum sum of any subarray of length k in the given array,
     * with the constraint that all elements in the subarray must be distinct.
     *
     * @param nums The input array of integers.
     * @param k The length of the subarray to consider.
     * @return The maximum sum of any subarray of length k with all distinct elements.
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0; // Variable to store the maximum sum found
        Map<Integer, Integer> map = new HashMap<>(); // HashMap to store the count of each element in the current window
        long sum = 0; // Variable to store the sum of the current subarray
        int left = 0; // Left boundary of the sliding window

        // Iterate through the array with 'right' as the end index of the sliding window
        for (int right = 0; right < nums.length; right++) {
            // Add the current element to the map and update the sum
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];

            // Check if the window size is at least 'k'
            if (right >= k - 1) {
                // If all elements in the window are distinct (map size equals k), update the maximum sum
                if (map.size() == k) {
                    max = Math.max(max, sum);
                }
                // Slide the window by removing the element at the left boundary
                map.put(nums[left], map.get(nums[left]) - 1);
                // If the count of the element becomes zero, remove it from the map
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                // Update the sum by subtracting the element at the left boundary
                sum -= nums[left];
                // Move the left boundary to the right
                left++;
            }
        }

        // Return the maximum sum found
        return max;
    }
}
