class Solution {
    /**
     * Determines if it is possible to sort the array such that
     * elements can only be swapped if they have the same number of 1's in their binary representation.
     *
     * @param nums the array of integers to be checked
     * @return true if the array can be sorted under the given conditions, false otherwise
     */
    public boolean canSortArray(int[] nums) {
        int n = nums.length; // Get the length of the array

        // Outer loop to iterate through the array
        for (int i = 0; i < n; ++i) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - 1; ++j) {
                // If the current element is less than or equal to the next, continue
                if (nums[j] <= nums[j + 1]) {
                    continue;
                } else {
                    // If the current element and the next element have the same number of 1's in their binary representation
                    if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
                        // Swap the elements since they can be rearranged
                        swap(nums, j, j + 1);
                    } else {
                        // If they cannot be swapped, return false
                        return false;
                    }
                }
            }
        }

        // If the loop completes without returning false, the array can be sorted
        return true;
    }

    /**
     * Swaps two elements in the array.
     *
     * @param nums the array of integers
     * @param i the index of the first element to swap
     * @param j the index of the second element to swap
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i]; // Store the first element in a temporary variable
        nums[i] = nums[j];  // Assign the second element to the first position
        nums[j] = temp;     // Assign the temporary variable (original first element) to the second position
    }
}
