/**
 * The Solution class provides a method to find the length of the longest 
 * Fibonacci-like subsequence in a given array of integers.
 */
class Solution {
    
    /**
     * Finds the length of the longest Fibonacci-like subsequence in the given array.
     * A Fibonacci-like sequence is defined as a sequence where the sum of the 
     * two preceding numbers equals the next number in the sequence.
     *
     * @param arr an array of integers where the Fibonacci-like subsequence is to be found.
     * @return the length of the longest Fibonacci-like subsequence. If no such 
     *         subsequence exists, returns 0.
     */
    public int lenLongestFibSubseq(int[] arr) {
        // Create a HashSet to store the elements of the array for O(1) lookups
        HashSet<Integer> set = new HashSet<>();
        for(int ele: arr) set.add(ele);
        
        int n = arr.length; // Length of the input array
        int maxLen = 0; // Variable to keep track of the maximum length found
        
        // Iterate through all pairs of elements in the array
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int prev = arr[j]; // The second last element in the current Fibonacci-like sequence
                int cur = arr[i] + arr[j]; // The next element in the sequence
                int len = 2; // Length of the current Fibonacci-like sequence
                
                // Continue to find the next elements in the sequence
                while(set.contains(cur)){
                    int temp = cur; // Store the current element
                    cur = cur + prev; // Update cur to the next Fibonacci-like number
                    prev = temp; // Update prev to the last number in the sequence
                    len++; // Increment the length of the sequence
                    maxLen = Math.max(maxLen, len); // Update maxLen if the current length is greater
                }
            }
        }
        
        return maxLen; // Return the maximum length found
    }
}
