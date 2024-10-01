/**
 * Solution to the "Check If Array Pairs Are Divisible by k" problem.
 */
class Solution {
    /**
     * Checks if the array can be divided into pairs with sums divisible by k.
     * 
     * @param arr the input array
     * @param k the divisor
     * @return true if the array can be divided into pairs with sums divisible by k, false otherwise
     */
    public boolean canArrange(int[] arr, int k) {
        // Initialize a frequency array to count the occurrences of each remainder
        int freq[] = new int[k];
        
        // Iterate over the array and count the occurrences of each remainder
        for (int i = 0; i < arr.length; i++) {
            int indexFreq = ((arr[i] % k) + k) % k;
            freq[indexFreq]++;
        }
        
        // Check if the count of the remainder 0 is even
        if (freq[0] % 2 != 0) {
            return false;
        }
        
        // Check if the counts of the remainders and their complements are equal
        for (int i = 1; i < k; i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        
        // If all checks pass, return true
        return true;
    }
}
