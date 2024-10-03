import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Initialize a HashMap to store the frequency of remainders
        HashMap<Integer, Integer> freq = new HashMap<>();
        // We start with 0 remainder having a frequency of 1 to account for sums that are already divisible by k
        freq.put(0, 1);
        
        int prefixSum = 0; // Variable to store the cumulative sum of elements
        int result = 0; // Variable to count the number of subarrays whose sums are divisible by k

        // Iterate through each number in the array
        for (int num : nums) {
            prefixSum += num; // Update the cumulative sum
            
            // Calculate the remainder when the prefix sum is divided by k
            int rem = prefixSum % k;
            
            // Adjust for negative remainders to ensure they fall within the range [0, k-1]
            if (rem < 0) {
                rem += k;
            }
            
            // Add the count of subarrays that have this remainder to the result
            result += freq.getOrDefault(rem, 0);
            
            // Update the frequency of the current remainder in the HashMap
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }

        // Return the total count of subarrays with sums divisible by k
        return result;
    }
}
