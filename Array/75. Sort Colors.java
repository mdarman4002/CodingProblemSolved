/**
 * The Solution class provides a method to sort an array of colors represented by integers.
 * The colors are represented as follows:
 * - 0: Red
 * - 1: White
 * - 2: Blue
 *
 * The sorting is done in a single pass using the Dutch National Flag algorithm, which
 * ensures that the colors are sorted in-place with a time complexity of O(n) and a space
 * complexity of O(1).
 */
class Solution {
    
    /**
     * Sorts the input array nums containing integers 0, 1, and 2 in-place.
     * 
     * @param nums an array of integers where each integer is either 0, 1, or 2.
     *             The method rearranges the elements so that all 0s come first,
     *             followed by all 1s, and all 2s come last.
     */
    public void sortColors(int[] nums) {
        int start = 0; // Pointer for the next position to place a 0
        int current = 0; // Current element being examined
        int end = nums.length - 1; // Pointer for the next position to place a 2
        
        // Iterate through the array until the current pointer exceeds the end pointer
        while (current <= end) {
            if (nums[current] == 0) {
                // If the current element is 0, swap it with the element at the start pointer
                swap(nums, start, current);
                current++; // Move to the next element
                start++; // Increment the start pointer
            } else if (nums[current] == 1) {
                // If the current element is 1, just move to the next element
                current++;
            } else {
                // If the current element is 2, swap it with the element at the end pointer
                swap(nums, end, current);
                end--; // Decrement the end pointer
                // Note: Do not increment current here, as we need to check the swapped element
            }
        }
    }

    /**
     * Swaps the elements at indices i and j in the array nums.
     * 
     * @param nums the array in which the elements will be swapped.
     * @param i the index of the first element to swap.
     * @param j the index of the second element to swap.
     */
    public void swap(int[] nums, int i, int j) {
        int k = nums[i]; // Store the value at index i
        nums[i] = nums[j]; // Assign the value at index j to index i
        nums[j] = k; // Assign the stored value to index j
    }
}
