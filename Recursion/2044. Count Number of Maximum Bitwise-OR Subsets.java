/**
 * The Solution class provides a method to count the number of subsets
 * of an integer array that achieve the maximum bitwise OR value.
 */
class Solution {

    /**
     * Counts the number of subsets that produce the maximum bitwise OR value.
     *
     * @param nums An array of integers.
     * @return The number of subsets that yield the maximum OR value.
     */
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        // Calculate the maximum OR value possible from all elements in nums.
        for (int ele : nums) {
            target |= ele;
        }

        // Find and return the count of subsets that match the maximum OR value.
        return findTarget(nums, 0, target, 0);
    }

    /**
     * A recursive helper method to find the count of subsets that yield
     * the target maximum OR value.
     *
     * @param nums   An array of integers.
     * @param index  The current index in the nums array being considered.
     * @param target The target maximum OR value that subsets should achieve.
     * @param cur    The current OR value of the subset being formed.
     * @return The number of subsets that match the target OR value.
     */
    public int findTarget(int[] nums, int index, int target, int cur) {
        // Base case: if we've considered all elements in nums
        if (index == nums.length) {
            // Check if the current OR value matches the target
            return cur == target ? 1 : 0;
        }

        // Include the current element in the subset and calculate the new OR value
        int includeCur = findTarget(nums, index + 1, target, cur | nums[index]);
        // Exclude the current element from the subset
        int excludeCur = findTarget(nums, index + 1, target, cur);

        // Return the total count of subsets that match the target OR value
        return includeCur + excludeCur;
    }
}
