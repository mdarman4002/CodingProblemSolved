class Solution {
    /**
     * This method calculates the minimum number of operations required to 
     * make all elements in a binary array equal to 1 by flipping three 
     * consecutive elements at a time.
     *
     * @param nums The binary array consisting of 0s and 1s.
     * @return The minimum number of operations required to make all elements 1,
     *         or -1 if it is impossible.
     */
    public int minOperations(int[] nums) {
        int operations = 0; // Counter for the number of operations performed
        int len = nums.length; // Length of the input array

        // Iterate through the array, stopping at len - 3 to avoid out-of-bounds
        for (int i = 0; i <= len - 3; i++) {
            // If the current element is 0, we need to perform a flip
            if (nums[i] == 0) {
                operations++; // Increment the operation count

                // Flip the current and the next two elements
                nums[i] = nums[i] == 0 ? 1 : 0; // Flip nums[i]
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0; // Flip nums[i + 1]
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0; // Flip nums[i + 2]
            }
        }

        // After processing, check the last two elements
        // If either of the last two elements is still 0, return -1
        if (nums[len - 1] == 0 || nums[len - 2] == 0) {
            return -1; // Impossible to make all elements 1
        }

        // Return the total number of operations performed
        return operations;
    }
}
