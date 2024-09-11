/**
 * This class provides a solution to the minimum bit flips problem.
 */
class Solution {
    /**
     * This method calculates the minimum number of bit flips required to transform the start number into the goal number.
     * 
     * @param start The starting number.
     * @param goal The goal number.
     * @return The minimum number of bit flips required.
     */
    public int minBitFlips(int start, int goal) {
        /**
         * If the start and goal numbers are the same, no bit flips are required.
         */
        if (start == goal) {
            return 0;
        }
        
        /**
         * Calculate the bitwise XOR of the start and goal numbers to get the bits that need to be flipped.
         */
        int output = start ^ goal;
        
        /**
         * Convert the output to a binary string to count the number of bits that need to be flipped.
         */
        String outputBin = Integer.toBinaryString(output);
        
        /**
         * Initialize a counter to count the number of bits that need to be flipped.
         */
        int count = 0;
        
        /**
         * Iterate through the binary string and count the number of '1' bits.
         */
        for (int i = 0; i < outputBin.length(); i++) {
            char ch = outputBin.charAt(i);
            if (ch == '1') {
                count++;
            }
        }
        
        /**
         * Return the count of bits that need to be flipped.
         */
        return count;
    }
}




/**
 * This class provides a solution to the minimum bit flips problem.
 */
class Solution {
    /**
     * This method calculates the minimum number of bit flips required to transform the start number into the goal number.
     * 
     * @param start The starting number.
     * @param goal The goal number.
     * @return The minimum number of bit flips required.
     */
    public int minBitFlips(int start, int goal) {
        /**
         * Initialize a counter to count the number of bits that need to be flipped.
         */
        int count = 0;
        
        /**
         * Calculate the bitwise XOR of the start and goal numbers to get the bits that need to be flipped.
         */
        int xor = start ^ goal;
        
        /**
         * Use a while loop to count the number of bits that need to be flipped.
         * The loop continues until all bits that need to be flipped are counted.
         */
        while (xor > 0) {
            /**
             * Use the bitwise AND operation to clear the least significant bit that is set to 1.
             * This is done by performing a bitwise AND with the number and the number minus 1.
             */
            xor = xor & (xor - 1);
            /**
             * Increment the count for each iteration of the loop.
             */
            count++;
        }
        
        /**
         * Return the count of bits that need to be flipped.
         */
        return count;
    }
}
