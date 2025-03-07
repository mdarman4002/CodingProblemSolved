/**
 * The Solution class provides a method to find the two closest prime numbers
 * within a specified range [left, right].
 */
class Solution {
    
    /**
     * Finds the two closest prime numbers in the range [left, right].
     *
     * This method uses the Sieve of Eratosthenes algorithm to efficiently
     * identify all prime numbers up to the specified right limit. It then
     * iterates through the identified primes to find the pair with the smallest
     * difference.
     *
     * @param left  The lower bound of the range (inclusive).
     * @param right The upper bound of the range (inclusive).
     * @return An array of two integers representing the closest prime numbers.
     *         If no such primes exist, returns an array {-1, -1}.
     */
    public int[] closestPrimes(int left, int right) {
        boolean prime[] = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = false; 
        prime[1] = false;

        // Sieve of Eratosthenes to find all primes up to 'right'
        for (int i = 2; i * i <= right; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    prime[j] = false;
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        int res[] = new int[]{-1, -1};
        int prev = -1;

        // Iterate through the range to find the closest primes
        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                if (prev == -1) {
                    prev = i; // First prime found
                } else {
                    // Check the difference with the previous prime
                    if (i - prev < minDiff) {
                        res[0] = prev;
                        res[1] = i;
                        minDiff = i - prev; // Update minimum difference
                    }
                    prev = i; // Update previous prime
                }
            }
        }
        return res; // Return the closest primes or {-1, -1} if none found
    }
}
