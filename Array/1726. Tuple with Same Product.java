import java.util.HashMap;

/**
 * The Solution class provides a method to count the number of tuples with the same product
 * from an array of integers.
 */
class Solution {
    
    /**
     * Calculates the number of ways to choose 2 items from n items (nC2).
     *
     * @param n The number of items to choose from.
     * @return The number of ways to choose 2 items from n items.
     */
    private int nC2(int n) {
        return (n * (n - 1)) / 2; // Calculate nC2 using the formula n * (n - 1) / 2
    }

    /**
     * Counts the number of tuples (a, b, c, d) such that the product of (a, b) is equal to the product of (c, d).
     *
     * A tuple is defined as a combination of two pairs of indices (i, j) and (k, l) such that:
     * - 0 <= i < j < n
     * - 0 <= k < l < n
     * - The products nums[i] * nums[j] and nums[k] * nums[l] are equal.
     *
     * @param nums An array of integers.
     * @return The number of tuples with the same product.
     */
    public int tupleSameProduct(int[] nums) {
        int n = nums.length; // Get the length of the input array
        HashMap<Integer, Integer> freq = new HashMap<>(); // Map to store the frequency of products

        // Calculate the product of each pair of numbers and store their frequencies
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int product = nums[i] * nums[j]; // Calculate the product of the pair
                freq.put(product, freq.getOrDefault(product, 0) + 1); // Update the frequency map
            }
        }

        int count = 0; // Initialize the count of tuples
        // For each product frequency, calculate the number of tuples
        for (int frequency : freq.values()) {
            count += 8 * nC2(frequency); // Each pair can form 8 tuples
        }

        return count; // Return the total count of tuples
    }
}
