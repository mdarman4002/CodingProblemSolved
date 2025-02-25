/**
 * The Solution class provides a method to count the number of subarrays 
 * with an odd sum in a given integer array.
 */
class Solution {
    
    /**
     * Counts the number of contiguous subarrays with an odd sum.
     *
     * @param arr an array of integers
     * @return the number of subarrays with an odd sum, modulo 10^9 + 7
     */
    public int numOfSubarrays(int[] arr) {
        int res = 0; // Result variable to store the count of odd-sum subarrays
        int modulo = 1000000007; // Modulo value to prevent overflow
        int prefixSum = 0; // Variable to store the cumulative sum of elements
        int even = 1; // Count of prefix sums that are even (initially 1 for the empty subarray)
        int odd = 0; // Count of prefix sums that are odd
        
        // Iterate through each element in the array
        for(int ele: arr) {
            prefixSum += ele; // Update the cumulative sum
            
            // Check if the current prefix sum is even or odd
            if(prefixSum % 2 == 0) {
                // If even, add the count of odd prefix sums to the result
                res += odd;
                even++; // Increment the count of even prefix sums
            } else {
                // If odd, add the count of even prefix sums to the result
                res += even;
                odd++; // Increment the count of odd prefix sums
            }
            
            // Ensure the result stays within the modulo limit
            res = res % modulo;
        }
       
        return res; // Return the final count of odd-sum subarrays
    }
}
