/**
 * The Solution class provides a method to construct a specific sequence of integers
 * based on the given integer n. The sequence is constructed such that each integer i
 * (from 1 to n) appears in the sequence and is separated by i indices.
 */
class Solution {

    /**
     * Constructs a distance sequence of integers from 1 to n.
     *
     * @param n The maximum integer to be included in the sequence.
     * @return An array representing the constructed distance sequence.
     */
    public int[] constructDistancedSequence(int n) {
        boolean used[] = new boolean[n + 1]; // Array to track used integers
        int seq[] = new int[2 * n - 1]; // The resulting sequence array
        backtrack(0, used, seq, n); // Start backtracking from index 0
        return seq; // Return the constructed sequence
    }

    /**
     * Backtracks to fill the sequence with integers while maintaining the distance constraints.
     *
     * @param index The current index in the sequence being filled.
     * @param used An array indicating which integers have been used.
     * @param seq The sequence being constructed.
     * @param n The maximum integer to be included in the sequence.
     * @return True if the sequence is successfully constructed, false otherwise.
     */
    public boolean backtrack(int index, boolean used[], int seq[], int n) {
        // Find the next empty index in the sequence
        while (index < seq.length && seq[index] != 0) index++;
        
        // If the entire sequence is filled, return true
        if (index == seq.length) return true;

        // Try placing integers from n down to 1
        for (int i = n; i >= 1; i--) {
            if (used[i]) continue; // Skip if the integer is already used

            // If the integer is 1, place it in the current index
            if (i == 1) {
                seq[index] = i; // Place 1 in the sequence
                used[i] = true; // Mark 1 as used
                if (backtrack(index + 1, used, seq, n)) return true; // Recur to fill the next index
                // If we cannot find a valid sequence, backtrack
                seq[index] = 0; // Reset the current index
                used[i] = false; // Mark 1 as unused
            } 
            // If the integer is greater than 1, check if we can place it
            else if (index + i < seq.length && seq[index + i] == 0) {
                seq[index] = i; // Place i in the current index
                seq[index + i] = i; // Place i in the index i positions away
                used[i] = true; // Mark i as used
                if (backtrack(index + 1, used, seq, n)) return true; // Recur to fill the next index
                // If we cannot find a valid sequence, backtrack
                seq[index] = 0; // Reset the current index
                seq[index + i] = 0; // Reset the index i positions away
                used[i] = false; // Mark i as unused
            }
        }
        return false; // Return false if no valid sequence can be constructed
    }
}
