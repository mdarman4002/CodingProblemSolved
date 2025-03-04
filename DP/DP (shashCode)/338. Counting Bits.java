/**
 * The {@code Solution} class provides methods to count the number of 
 * 1's in the binary representation of integers from 0 to n.
 */
class Solution {

    /**
     * Counts the number of 1's in the binary representation of integers 
     * from 0 to n using a built-in function to convert integers to binary.
     *
     * <p>
     * This method iterates through each integer from 1 to n, converts 
     * it to a binary string, and counts the number of '1's in that string.
     * </p>
     *
     * @param n the upper limit integer
     * @return an array where the index i contains the number of 1's in 
     *         the binary representation of i
     *
     * @time complexity O(n log n) - due to the conversion of each integer 
     * to a binary string and counting the bits.
     * @space complexity O(n) - for the result array.
     */
    public int[] countBitsUsingBuiltInFunction(int n) {
        int res[] = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            String bin = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < bin.length(); j++) {
                if (bin.charAt(j) == '1') {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * Counts the number of 1's in the binary representation of integers 
     * from 0 to n without using built-in functions.
     *
     * <p>
     * This method uses bit manipulation to count the number of 1's 
     * by repeatedly clearing the least significant 1 bit of the integer.
     * </p>
     *
     * @param n the upper limit integer
     * @return an array where the index i contains the number of 1's in 
     *         the binary representation of i
     *
     * @time complexity O(n log n) - due to the bit manipulation for each 
     * integer.
     * @space complexity O(n) - for the result array.
     */
    public int[] countBitsWithoutBuiltInFunction(int n) {
        int count;
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            count = 0;
            while (num > 0) {
                num = num & (num - 1);
                count++;
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * Counts the number of 1's in the binary representation of integers 
     * from 0 to n using dynamic programming.
     *
     * <p>
     * This method uses the relationship that the number of 1's in the 
     * binary representation of i can be derived from the number of 1's 
     * in i shifted right by 1 plus the least significant bit of i.
     * </p>
     *
     * @param n the upper limit integer
     * @return an array where the index i contains the number of 1's in 
     *         the binary representation of i
     *
     * @time complexity O(n) - as it processes each integer in constant time.
     * @space complexity O(n) - for the result array.
     */
    public int[] countBitsUsingDynamicProgramming(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
